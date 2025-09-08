/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.MenuDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Invoice;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(MenuItem t, boolean test) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(MenuItem t, boolean test) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
