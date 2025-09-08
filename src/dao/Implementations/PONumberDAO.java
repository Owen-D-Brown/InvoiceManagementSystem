/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.PONumberDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.MenuItem;
import model.PONumber;
import util.DatabasePipeline;

/**
 *
 * @author owen
 */
public class PONumberDAO implements PONumberDAOInterface {

    @Override
    public List<PONumber> getByContactId(int id) {
  try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PONumbers WHERE ContactID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<PONumber> pos = new ArrayList<>();
            while(rs.next()) {
                PONumber po = new PONumber();
                po.setPONumberID(rs.getInt("PONumberID"));
                po.setContactID(rs.getInt("contactID"));
                po.setPONumber(rs.getString("PONumber"));
                pos.add(po);
            }
            return pos;
    }   catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return null;    
    }

    @Override
    public PONumber getById(int id) {
  try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PONumbers WHERE PONumberID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                PONumber po = new PONumber();
                po.setPONumberID(rs.getInt("PONumberID"));
                po.setContactID(rs.getInt("contactID"));
                po.setPONumber(rs.getString("PONumber"));
                return po;
            } else {
                //throw error
                return null;
            }
    }   catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return null;
    }

    @Override
    public List<PONumber> getAll() {
try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PONumbers")
        ) {
            
            ResultSet rs = stmt.executeQuery();
            ArrayList<PONumber> pos = new ArrayList<>();
            while(rs.next()) {
                PONumber po = new PONumber();
                po.setPONumberID(rs.getInt("PONumberID"));
                po.setContactID(rs.getInt("contactID"));
                po.setPONumber(rs.getString("PONumber"));
                pos.add(po);
            }
            return pos;
    }   catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return null;        
    }

    @Override
    public boolean insert(PONumber t, boolean test) throws SQLException {
        String sql = "INSERT INTO PONumbers (ContactID, PONumber) VALUES (?, ?)";
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            
            stmt.setInt(1, t.getContactID());
            stmt.setString(2, t.getPONumber());



           

            //Update the Primary Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any POJO passed to this method should not have a valid primary key ID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setPONumberID(newId);
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
    public boolean update(PONumber t, boolean test) throws SQLException {
        String sql = "UPDATE PONumbers SET ContactID = ?, PONumber = ? WHERE PONumberID = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getContactID());
            stmt.setString(2, t.getPONumber());
            stmt.setInt(3, t.getPONumberID());

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(PONumber t, boolean test) throws SQLException {
        String sql = "DELETE from PONumbers WHERE PONumberID = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getPONumberID());
            return stmt.executeUpdate() == 1;
        }      
    }
    
}
