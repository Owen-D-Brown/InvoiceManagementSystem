/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.MenuDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Invoice;
import model.InvoiceDetail;
import model.MenuItem;
import util.DatabasePipeline;

/**
 *
 * @author owen
 */
public class MenuDAO implements MenuDAOInterface {

    @Override
    public MenuItem getByName(String name) {
try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Menu WHERE ItemName = ?")
        ) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("ItemID"),
                    rs.getString("ItemName"),
                    rs.getFloat("ItemPrice"),
                    rs.getFloat("ItemWeight"),
                    rs.getFloat("ItemCost")
                );
                return item;
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
    public MenuItem getById(int id) {
        try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Menu WHERE ItemID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("ItemID"),
                    rs.getString("ItemName"),
                    rs.getFloat("ItemPrice"),
                    rs.getFloat("ItemWeight"),
                    rs.getFloat("ItemCost")
                );
                return item;
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
    public List<MenuItem> getAll() {
try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Menu")
        ) {
            ArrayList<MenuItem> items = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                MenuItem item = new MenuItem(
                    rs.getInt("ItemID"),
                    rs.getString("ItemName"),
                    rs.getFloat("ItemPrice"),
                    rs.getFloat("ItemWeight"),
                    rs.getFloat("ItemCost")
                );
                items.add(item);
            } 
            return items;
    }   catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return null;
    }

    @Override
    public boolean insert(MenuItem t, boolean test) throws SQLException {
        String sql = "INSERT INTO Menu " +
                     "(ItemName, ItemPrice, ItemWeight, ItemCost) " +
                     "VALUES (?, ?, ?, ?)";
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            stmt.setString(1, t.getItemName());
            stmt.setDouble(2, t.getItemPrice());
            stmt.setDouble(3, t.getItemWeight());
            stmt.setDouble(4, t.getItemCost());



           

            //Update the Primary Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any POJO passed to this method should not have a valid primary key ID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setItemID(newId);
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
    public boolean update(MenuItem t, boolean test) throws SQLException {
        String sql = "UPDATE Menu SET " +
                     "ItemName = ?, ItemPrice = ?, ItemWeight = ?, ItemCost = ? " +
                     "WHERE ItemID = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setString(1, t.getItemName());
            stmt.setDouble(2, t.getItemPrice());
            stmt.setDouble(3, t.getItemWeight());
            stmt.setDouble(4, t.getItemCost());
            stmt.setInt(5, t.getItemID());

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(MenuItem t, boolean test) throws SQLException {
        String sql = "DELETE from Menu WHERE ItemID = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getItemID());
            return stmt.executeUpdate() == 1;
        }      
    }
    
    
}
