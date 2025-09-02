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
import model.Client;
import model.ClientAddress;
import util.DatabasePipeline;

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
        return null;        }

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
