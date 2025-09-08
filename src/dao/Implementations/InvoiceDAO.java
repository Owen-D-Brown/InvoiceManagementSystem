/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.InvoiceDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Contact;
import model.Invoice;
import util.DatabasePipeline;

/**
 *
 * @author owen
 */
public class InvoiceDAO implements InvoiceDAOInterface {

    private static final SimpleDateFormat DB_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public Invoice getById(int id) {
        try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Invoices WHERE InvoiceNumber = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                int invoiceNumber = rs.getInt("InvoiceNumber");
                String rawInvoiceDate = rs.getString("InvoiceDate");
                String rawDueDate = rs.getString("InvoiceDueDate");
                String rawBookingDate = rs.getString("InvoiceBookingDate");
                Date invoiceDate = DB_DATE_FORMAT.parse(rawInvoiceDate);
                Date invoiceDueDate = DB_DATE_FORMAT.parse(rawDueDate);
                Date invoiceBookingDate = DB_DATE_FORMAT.parse(rawBookingDate);
                float subtotal = rs.getFloat("InvoiceSubtotal");
                float total = rs.getFloat("InvoiceTotal");
                boolean paid = rs.getBoolean("InvoicePaid");
                String notes = rs.getString("InvoiceNotes");
                int clientId = rs.getInt("ClientID");
                int contactId = rs.getInt("ContactID");

                return new Invoice(
                    invoiceNumber,
                    invoiceDate,
                    invoiceDueDate,
                    invoiceBookingDate,
                    subtotal,
                    total,
                    paid,
                    notes,
                    clientId,
                    contactId
                );
            } else {
                //throw error no client found;
                return null;
            }
    }   catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ParseException ex) {
        System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
        return null;
    }

    @Override
    public List<Invoice> getAll() {
try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Invoices")
        ) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Invoice> is = new ArrayList<>();
            while(rs.next()) {
                int invoiceNumber = rs.getInt("InvoiceNumber");
                String rawInvoiceDate = rs.getString("InvoiceDate");
                String rawDueDate = rs.getString("InvoiceDueDate");
                String rawBookingDate = rs.getString("InvoiceBookingDate");
                Date invoiceDate = DB_DATE_FORMAT.parse(rawInvoiceDate);
                Date invoiceDueDate = DB_DATE_FORMAT.parse(rawDueDate);
                Date invoiceBookingDate = DB_DATE_FORMAT.parse(rawBookingDate);
                float subtotal = rs.getFloat("InvoiceSubtotal");
                float total = rs.getFloat("InvoiceTotal");
                boolean paid = rs.getBoolean("InvoicePaid");
                String notes = rs.getString("InvoiceNotes");
                int clientId = rs.getInt("ClientID");
                int contactId = rs.getInt("ContactID");

                Invoice i = new Invoice(
                    invoiceNumber,
                    invoiceDate,
                    invoiceDueDate,
                    invoiceBookingDate,
                    subtotal,
                    total,
                    paid,
                    notes,
                    clientId,
                    contactId
                );
                is.add(i);
            }
            return is;
    }   catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ParseException ex) {
        System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
        return null;
    }

       @Override
    public boolean insert(Invoice t, boolean test) throws SQLException {
        String sql = "INSERT INTO Invoices " +
                     "(InvoiceDate, InvoiceDueDate, InvoiceBookingDate, " +
                     " InvoiceSubtotal, InvoiceTotal, InvoicePaid, InvoiceNotes, " +
                     " ClientID, ContactID) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            stmt.setString(1, DB_DATE_FORMAT.format(t.getInvoiceDate()));
            stmt.setString(2, DB_DATE_FORMAT.format(t.getInvoiceDueDate()));
            stmt.setString(3, DB_DATE_FORMAT.format(t.getInvoiceBookingDate()));
            stmt.setDouble(4, t.getInvoiceSubtotal());
            stmt.setDouble(5, t.getInvoiceTotal());     
            stmt.setBoolean(6, t.isInvoicePaid());      
            stmt.setString(7, t.getInvoiceNotes());     
            stmt.setInt(8, t.getClientID());
            stmt.setInt(9, t.getContactID());

           

            //Update the Primary Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any POJO passed to this method should not have a valid primary key ID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setInvoiceNumber(newId);
                        return true;
                    }
                }
            }
            System.out.println("ISSUE SETTING PRIMARY KEY of POJO: "+t);
            System.out.println("CHECK DATABASE FOR ADDED RECORD");
            return false;
        }
    }

    //Update Record in Database
    @Override
    public boolean update(Invoice t, boolean test) throws SQLException {
        String sql = "UPDATE Invoices SET " +
                     " InvoiceDate = ?, InvoiceDueDate = ?, InvoiceBookingDate = ?, " +
                     " InvoiceSubtotal = ?, InvoiceTotal = ?, InvoicePaid = ?, InvoiceNotes = ?, " +
                     " ClientID = ?, ContactID = ? " +
                     "WHERE InvoiceNumber = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setString(1, DB_DATE_FORMAT.format(t.getInvoiceDate()));
            stmt.setString(2, DB_DATE_FORMAT.format(t.getInvoiceDueDate()));
            stmt.setString(3, DB_DATE_FORMAT.format(t.getInvoiceBookingDate()));
            stmt.setDouble(4, t.getInvoiceSubtotal());
            stmt.setDouble(5, t.getInvoiceTotal());     // remove if you don’t store total
            stmt.setBoolean(6, t.isInvoicePaid());
            stmt.setString(7, t.getInvoiceNotes());
            stmt.setInt(8, t.getClientID());
            stmt.setInt(9, t.getContactID());
            stmt.setInt(10, t.getInvoiceNumber());

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(Invoice t, boolean test) throws SQLException {
        String sql = "DELETE from Invoices WHERE InvoiceNumber = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getInvoiceNumber());
            return stmt.executeUpdate() == 1;
        }      
    }
    
    
}
