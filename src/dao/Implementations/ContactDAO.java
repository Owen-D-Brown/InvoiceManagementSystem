/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.ContactDAOInterface;
import dto.FullContactDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Client;
import model.ClientAddress;
import model.Contact;
import model.PONumber;
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
    public Contact getByFirstName(String name) {
   try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Contacts WHERE ContactFirstName = ?")
        ) {
            stmt.setString(1, name);
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
        return null;       }

  

    @Override
    public List<Contact> getAll() {
 try (
            java.sql.Connection conn = DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Contacts")
        ) {
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
    public boolean insert(Contact t, boolean test) throws SQLException {
        String sql = "INSERT INTO Contacts " +
                     "(ClientID, ContactFirstName, ContactLastName, ContactNumber, ContactEmail) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) 
        {
            stmt.setInt(1, t.getClientID());
            stmt.setString(2, t.getContactFirstName());
            stmt.setString(3, t.getContactLastName());
            stmt.setString(4, t.getContactNumber());
            stmt.setString(5, t.getContactEmail());

           

            //Update the Primary Key in the POJO of the record just added to database. 
            //Needed because the DB auto-increments this field. Any POJO passed to this method should not have a valid primary key ID until after resolution.
            int rows = stmt.executeUpdate();
            
            if (rows == 1) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        int newId = keys.getInt(1);
                        t.setContactID(newId);
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
    public boolean update(Contact t, boolean test) throws SQLException {
        String sql = "UPDATE Contacts " +
                     "SET ClientID = ?, ContactFirstName = ?, ContactLastName = ?, " +
                     "ContactNumber = ?, ContactEmail = ? " +
                     "WHERE ContactID = ?";

        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getClientID());
            stmt.setString(2, t.getContactFirstName());
            stmt.setString(3, t.getContactLastName());
            stmt.setString(4, t.getContactNumber());
            stmt.setString(5, t.getContactEmail());
            stmt.setInt(6, t.getContactID()); //Primary key for update

            int rows = stmt.executeUpdate();
            return rows == 1;
        }   
    }

    //Delete Record from Database
    @Override
    public boolean delete(Contact t, boolean test) throws SQLException {
        String sql = "DELETE from Contacts WHERE ContactID = ?"; 
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) 
        {
            stmt.setInt(1, t.getContactID());
            return stmt.executeUpdate() == 1;
        }      
    }
    
    public ArrayList<FullContactDTO> getFullContactDTOsForClient(int clientid, boolean test) throws SQLException {
        
        String sql = "SELECT c.ContactID, c.ClientID, c.ContactFirstName, c.ContactLastName, " +
                    "       c.ContactNumber, c.ContactEmail, " +
                    "       GROUP_CONCAT(DISTINCT p.PONumber) AS po_numbers " +
                    "FROM Contacts c " +
                    "LEFT JOIN PONumbers p ON p.ContactID = c.ContactID " +
                    "WHERE c.ClientID = ? " +
                    "GROUP BY c.ContactID, c.ClientID, c.ContactFirstName, c.ContactLastName, " +
                    "         c.ContactNumber, c.ContactEmail";
        
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) 
          {
            stmt.setInt(1, clientid);
            ResultSet rs = stmt.executeQuery();
            ArrayList<FullContactDTO> returns = new ArrayList<>();
            
            while(rs.next()) {
                int contactID = rs.getInt("ContactID");
                int clientID = rs.getInt("ClientID");
                String firstName = rs.getString("ContactFirstName");
                String lastName = rs.getString("ContactLastName");
                String number = rs.getString("ContactNumber");
                String email = rs.getString("ContactEmail");
                Contact co = new Contact(contactID, clientID, firstName, lastName, number, email);
                
                
                  // Build PO list from the aggregated CSV
                String poCsv = rs.getString("po_numbers");
                ArrayList<PONumber> poList = new ArrayList<>();
                if (poCsv != null && !poCsv.isEmpty()) {
                    for (String po : poCsv.split(",")) {
                        poList.add(new PONumber(0, contactID, po.trim())); 
                        FullContactDTO dto = new FullContactDTO(co, poList);
                        returns.add(dto);
                    }
                }
                
            }
            
            return returns;
        } 
    }
}
