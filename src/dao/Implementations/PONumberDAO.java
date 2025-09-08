/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.PONumberDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(PONumber t, boolean test) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(PONumber t, boolean test) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
