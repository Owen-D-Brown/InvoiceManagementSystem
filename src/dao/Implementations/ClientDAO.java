/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.ClientDAOInterface;
import java.util.List;
import model.Client;
import util.DatabasePipeline;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public class ClientDAO implements ClientDAOInterface {

    @Override
    public Client getByName(String name) {
        try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Clients WHERE ClientName = ?")
        ) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("ClientID");
                String cName = rs.getString("ClientName");
                String email = rs.getString("ClientEmail");
                String number = Integer.toString(rs.getInt("ClientNumber"));
                String website = rs.getString("ClientWebsite");
                return new Client(id, cName, email, number, website);
                
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
    public Client getByNumber(int number) {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Clients WHERE ClientNumber = ?")
        ) {
            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("ClientID");
                String name = rs.getString("ClientName");
                String email = rs.getString("ClientEmail");
                String cNumber = Integer.toString(rs.getInt("ClientNumber"));
                String website = rs.getString("ClientWebsite");
                return new Client(id, name, email, cNumber, website);
               
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
    public Client getById(int id) {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Clients WHERE ClientID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                int cId = rs.getInt("ClientID");
                String name = rs.getString("ClientName");
                String email = rs.getString("ClientEmail");
                String number = Integer.toString(rs.getInt("ClientNumber"));
                String website = rs.getString("ClientWebsite");
                Client c = new Client(cId, name, email, number, website);
                return c;
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
    public List<Client> getAll() {
try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Clients")
        ) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<Client> cs = new ArrayList<>();//this wont handle when its a bad search it returns empty array not null
            while(rs.next()) {
                int id = rs.getInt("ClientID");
                String cName = rs.getString("ClientName");
                String email = rs.getString("ClientEmail");
                String number = Integer.toString(rs.getInt("ClientNumber"));
                String website = rs.getString("ClientWebsite");
                cs.add(new Client(id, cName, email, number, website));
                
            } 
            return cs;
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;
    }

    @Override
    public boolean insert(Object t) {
        return true;
    }

    @Override
    public boolean update(Object t) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
    
}
