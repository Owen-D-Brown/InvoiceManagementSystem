/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.InvoiceDetailDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import model.Contact;
import model.Invoice;
import model.InvoiceDetail;
import util.DatabasePipeline;

/**
 *
 * @author owen
 */
public class InvoiceDetailDAO implements InvoiceDetailDAOInterface {

    @Override
    public ArrayList<InvoiceDetail> getByInvoiceNumber(int number) {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM InvoiceDetails WHERE InvoiceNumber = ?")
        ) {
            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();
            ArrayList<InvoiceDetail> invoiceDetails = new ArrayList<>();
            while(rs.next()) {
                int detailID = rs.getInt("DetailID");
                int invoiceNumber = rs.getInt("InvoiceNumber");
                int itemID = rs.getInt("ItemID");
                int quantity = rs.getInt("ItemQuantity");

                InvoiceDetail detail = new InvoiceDetail(detailID, invoiceNumber, itemID, quantity);
                invoiceDetails.add(detail);
        }
            
            return invoiceDetails;
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;        
    }

    @Override
    public InvoiceDetail getById(int id) {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM InvoiceDetails WHERE DetailID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                int detailID = rs.getInt("DetailID");
                int invoiceNumber = rs.getInt("InvoiceNumber");
                int itemID = rs.getInt("ItemID");
                int quantity = rs.getInt("ItemQuantity");

                InvoiceDetail detail = new InvoiceDetail(detailID, invoiceNumber, itemID, quantity);
                return detail;
        } else {
                return null;
            }
            
         
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;            }

    @Override
    public List<InvoiceDetail> getAll() {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM InvoiceDetails")
        ) {
            
            ResultSet rs = stmt.executeQuery();
            ArrayList<InvoiceDetail> invoiceDetails = new ArrayList<>();
            while(rs.next()) {
                int detailID = rs.getInt("DetailID");
                int invoiceNumber = rs.getInt("InvoiceNumber");
                int itemID = rs.getInt("ItemID");
                int quantity = rs.getInt("ItemQuantity");

                InvoiceDetail detail = new InvoiceDetail(detailID, invoiceNumber, itemID, quantity);
                invoiceDetails.add(detail);
        }
            
            return invoiceDetails;
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;           
    }

    @Override
    public boolean insert(InvoiceDetail t, boolean test) throws SQLException {
        String sql = "INSERT INTO InvoiceDetails " +
                     "(InvoiceNumber, ItemID, ItemQuantity) " +
                     "VALUES (?, ?, ?)";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            stmt.setInt(1, t.getInvoiceNumber());
            stmt.setInt(2, t.getItemID());
            stmt.setInt(3, t.getItemQuantity());


           

            //Update the Primary Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any POJO passed to this method should not have a valid primary key ID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setDetailID(newId);
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
    public boolean update(InvoiceDetail t, boolean test) throws SQLException {
        String sql = "UPDATE InvoiceDetails SET " +
                     "InvoiceNumber = ?, ItemID = ?, ItemQuantity = ? " +
                     "WHERE DetailID = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getInvoiceNumber());
            stmt.setInt(2, t.getItemID());
            stmt.setInt(3, t.getItemQuantity());
            stmt.setInt(4, t.getDetailID());

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(InvoiceDetail t, boolean test) throws SQLException {
        String sql = "DELETE from InvoiceDetails WHERE DetailID = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getDetailID());
            return stmt.executeUpdate() == 1;
        }      
    }
    
    @Override
    public boolean deleteByInvoiceNumber(Invoice t, boolean test) throws SQLException {
        String sql = "DELETE * from InvoiceDetails WHERE InvoiceNumber = ?"; 
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

    @Override
    public boolean updateByInvoiceNumber(ArrayList<InvoiceDetail> details, int invoiceNo, boolean test) throws SQLException {
        String sql = "DELETE * from InvoiceDetails WHERE InvoiceNumber = ?"; 
        String uSql ="INSERT INTO InvoiceDetails " +
                     "(InvoiceNumber, ItemID, ItemQuantity) " +
                     "VALUES (?, ?, ?)";
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            PreparedStatement uStmt = conn.prepareStatement(uSql)
        ) 
        {
            stmt.setInt(1, invoiceNo);
            stmt.executeUpdate();
            for(InvoiceDetail d : details) {
                uStmt.setInt(1, invoiceNo);
                uStmt.setInt(2, d.getItemID());
                uStmt.setInt(3, d.getItemQuantity());
                uStmt.executeUpdate();
                
            }
            return true;
        }       }
    
    
}
