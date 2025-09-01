/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.InvoiceDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
