/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.InvoiceDetailDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contact;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(InvoiceDetail t, boolean test) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(InvoiceDetail t, boolean test) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
