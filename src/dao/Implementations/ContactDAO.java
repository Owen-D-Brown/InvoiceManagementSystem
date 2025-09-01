/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.ContactDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Client;
import model.ClientAddress;
import model.Contact;
import util.DatabasePipeline;

/**
 *
 * @author owen
 */
public class ContactDAO implements ContactDAOInterface {

    //Returns a list of all contacts associated with a client.
    @Override
    public ArrayList<Contact> getByClientId(int id) {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Contacts WHERE ClientID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Contact> c = new ArrayList<>();
            while(rs.next()) {
                int contactID = rs.getInt("ContactID");
                int clientID = rs.getInt("ClientID");
                String firstName = rs.getString("ContactFirstName");
                String lastName = rs.getString("ContactLastName");
                String number = rs.getString("ContactNumber");
                String email = rs.getString("ContactEmail");
                Contact co = new Contact(contactID, clientID, firstName, lastName, number, email);
                c.add(co);
        }
            
            return c;
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;        
    }

  @Override
    public Contact getById(int id) {
        try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Contacts WHERE ContactID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                int contactID = rs.getInt("ContactID");
                int clientID = rs.getInt("ClientID");
                String firstName = rs.getString("ContactFirstName");
                String lastName = rs.getString("ContactLastName");
                String number = rs.getString("ContactNumber");
                String email = rs.getString("ContactEmail");
                return new Contact(contactID, clientID, firstName, lastName, number, email);
               
            } else {
                //throw error no client found;
                return null;
            }
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;   
    }

    @Override
    public Contact getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

    @Override
    public List<Contact> getAll() {
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
