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
    public boolean insert(Client t, boolean test) throws SQLException {
        String sql = "INSERT INTO Clients " +
                     "(ClientName, ClientEmail, ClientNumber, ClientWebsite) " +
                     "VALUES (?, ?, ?, ?)";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            stmt.setString(1, t.getClientName());
            stmt.setString(2, t.getClientEmail());
            stmt.setString(3, t.getClientNumber());
            stmt.setString(4, t.getClientWebsite());
           

            //Update the Primary Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any POJO passed to this method should not have a valid primary key ID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setClientID(newId);
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
    public boolean update(Client t, boolean test) throws SQLException {
        String sql = "UPDATE Clients " +
                     "SET ClientName = ?, ClientEmail = ?, ClientNumber = ?, ClientWebsite = ? " +
                     "WHERE ClientID = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setString(1, t.getClientName());
            stmt.setString(2, t.getClientEmail());
            stmt.setString(3, t.getClientNumber());
            stmt.setString(4, t.getClientWebsite());

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(Client t, boolean test) throws SQLException {
        String sql = "DELETE from Clients WHERE ClientID = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getClientID());
            return stmt.executeUpdate() == 1;
        }      
    }
    
}
