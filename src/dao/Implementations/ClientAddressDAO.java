/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.ClientAddressDAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClientAddress;
import util.DatabasePipeline;
import java.sql.Statement;

/**
 *
 * @author owen
 * gonna need a method that returns a list of clientaddresses for all addresses of a given clientID.
 */
public class ClientAddressDAO implements ClientAddressDAOInterface {

    @Override
    public ArrayList<ClientAddress> getByClientId(int id) {
         try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClientAddresses WHERE ClientID = ?")
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ArrayList<ClientAddress> ca = new ArrayList<>();
            while(rs.next()) {
                int cId = rs.getInt("AddressID");
                int clientID = rs.getInt("ClientID");
                String streetAddress = rs.getString("StreetAddress");
                String areaAddress = rs.getString("AreaAddress");
                String county = rs.getString("ClientCounty");
                String eircode = rs.getString("ClientEircode");
                String printAddress = rs.getString("ClientPrintAddress");
                ClientAddress c = new ClientAddress(cId, clientID, streetAddress, areaAddress, county, eircode, printAddress);
                ca.add(c);
        }
            
            return ca;
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;    
    }

    @Override
    public ClientAddress getById(int id) {
        try (
                 java.sql.Connection conn = DatabasePipeline.openConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClientAddresses WHERE AddressID = ?")
            ) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                    int cId = rs.getInt("AddressID");
                    int clientID = rs.getInt("ClientID");
                    String streetAddress = rs.getString("StreetAddress");
                    String areaAddress = rs.getString("AreaAddress");
                    String county = rs.getString("ClientCounty");
                    String eircode = rs.getString("ClientEircode");
                    String printAddress = rs.getString("ClientPrintAddress");
                    ClientAddress c = new ClientAddress(cId, clientID, streetAddress, areaAddress, county, eircode, printAddress);
                    return c;
               }
            
           
                }    
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;        
    }

    @Override
    public List<ClientAddress> getAll() {
        try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClientAddresses")
        ) {
            
            ResultSet rs = stmt.executeQuery();
            ArrayList<ClientAddress> ca = new ArrayList<>();
            while(rs.next()) {
                int cId = rs.getInt("AddressID");
                int clientID = rs.getInt("ClientID");
                String streetAddress = rs.getString("StreetAddress");
                String areaAddress = rs.getString("AreaAddress");
                String county = rs.getString("ClientCounty");
                String eircode = rs.getString("ClientEircode");
                String printAddress = rs.getString("ClientPrintAddress");
                ClientAddress c = new ClientAddress(cId, clientID, streetAddress, areaAddress, county, eircode, printAddress);
                ca.add(c);
        }
            
            return ca;
        } 
        
        catch (SQLException ex) {
            System.getLogger(ClientDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            
        }
        return null;        
    }

    @Override
    public boolean insert(ClientAddress t, boolean test) throws SQLException {
        String sql = "INSERT INTO ClientAddresses " +
                     "(ClientID, StreetAddress, AreaAddress, ClientCounty, ClientEircode, ClientPrintAddress) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            stmt.setInt(1, t.getClientID());
            stmt.setString(2, t.getStreetAddress());
            stmt.setString(3, t.getAreaAddress());
            stmt.setString(4, t.getClientCounty());
            stmt.setString(5, t.getClientEircode());
            stmt.setString(6, t.getClientPrintAddress());

            //Update the Primary AddressID Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any ClientAddress passed to this method should not have a valid AddressID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setAddressID(newId);
                        return true;
                    }
                }
            }
            System.out.println("ISSUE SETTING AddressID of POJO: "+t);
            System.out.println("CHECK DATABASE FOR ADDED RECORD");
            return false;
        }
    }

    //Update Record in Database
    @Override
    public boolean update(ClientAddress t, boolean test) throws SQLException {
        String sql = "UPDATE ClientAddresses " +
                     "SET ClientID = ?, StreetAddress = ?, AreaAddress = ?, " +
                     "ClientCounty = ?, ClientEircode = ?, ClientPrintAddress = ? " +
                     "WHERE AddressID = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getClientID());
            stmt.setString(2, t.getStreetAddress());
            stmt.setString(3, t.getAreaAddress());
            stmt.setString(4, t.getClientCounty());
            stmt.setString(5, t.getClientEircode());
            stmt.setString(6, t.getClientPrintAddress());
            stmt.setInt(7, t.getAddressID()); //Primary Key for the WHERE Clause

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(ClientAddress t, boolean test) throws SQLException {
        String sql = "DELETE from ClientAddresses WHERE AddressID = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getAddressID());
            return stmt.executeUpdate() == 1;
        }      
    }
}
