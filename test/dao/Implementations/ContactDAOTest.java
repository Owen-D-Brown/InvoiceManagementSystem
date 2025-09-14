/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ClientAddress;
import model.Contact;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DatabasePipeline;

/**
 *
 * @author owen
 */
public class ContactDAOTest {
    
    private ContactDAO dao;
    private Integer insertedContactId;

    @Before
    public void setUp() {
        dao = new ContactDAO();
        insertedContactId = null;
    }

    //Delete the temporary record created for testing
    @After
    public void tearDown() throws Exception {
        if (insertedContactId != null) {
            try (Connection conn = DatabasePipeline.openTestConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Contacts WHERE ContactID = ?")) {
                ps.setInt(1, insertedContactId);
                ps.executeUpdate();
            }
            insertedContactId = null;
        }
    }

    //--- Individual Unit Tests ---//
    
    @Test
    public void testInsert_only() throws Exception {
        
        Contact c = new Contact();
        c.setClientID(1);
        c.setContactFirstName("TestFirst");
        c.setContactLastName("TestLast");
        c.setContactNumber("899112233");
        c.setContactEmail("test.contact@example.com");
        
   

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getContactID()> 0);
        insertedContactId = c.getContactID();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ClientID, ContactFirstName, ContactLastName, ContactNumber, ContactEmail " +
                                                         "FROM Contacts WHERE ContactID = ?")
        ) 
        {
            ps.setInt(1, insertedContactId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals(1, rs.getInt("ClientID"));
                assertEquals("TestFirst", rs.getString("ContactFirstName"));
                assertEquals("TestLast", rs.getString("ContactLastName"));
                assertEquals("899112233", rs.getString("ContactNumber"));
                assertEquals("test.contact@example.com", rs.getString("ContactEmail"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
        Contact c = new Contact();
        c.setClientID(1);
        c.setContactFirstName("TestFirst");
        c.setContactLastName("TestLast");
        c.setContactNumber("899112233");
        c.setContactEmail("test.contact@example.com");

        assertTrue(dao.insert(c, true));
        assertTrue(c.getContactID()> 0);
        insertedContactId = c.getContactID();

        c.setContactFirstName("AfterUpdateFirst");
        c.setContactLastName("AfterUpdateLast");
        c.setContactNumber("877665544");
        c.setContactEmail("after.update@example.com");


        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", updated);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ClientID, ContactFirstName, ContactLastName, ContactNumber, ContactEmail " +
                                                         "FROM Contacts WHERE ContactID = ?")
        ) 
        {
            ps.setInt(1, insertedContactId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("AfterUpdateFirst", rs.getString("ContactFirstName"));
                assertEquals("AfterUpdateLast", rs.getString("ContactLastName"));
                assertEquals("877665544", rs.getString("ContactNumber"));
                assertEquals("after.update@example.com", rs.getString("ContactEmail"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        Contact c = new Contact();
        c.setClientID(1);
        c.setContactFirstName("TestFirst");
        c.setContactLastName("TestLast");
        c.setContactNumber("899112233");
        c.setContactEmail("test.contact@example.com");


        assertTrue(dao.insert(c, true));
        assertTrue(c.getContactID()> 0);
        insertedContactId = c.getContactID();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM Contacts WHERE ContactID = ?")
        ) 
        {
            ps.setInt(1, insertedContactId);
            try (ResultSet rs = ps.executeQuery()) {
                assertFalse("Row should not exist after delete", rs.next());
            }
        }   

        //Prevents @after trying to remove an already deleted record
        insertedContactId = null;
    }

    //--- Test for all operations ---//
    
    @Test
    public void testAll_CRUD_inOrder() throws Exception {
        
        setUp();
        try { testInsert_only(); } finally { tearDown(); }

        setUp();
        try { testUpdate_only(); } finally { tearDown(); }

        setUp();
        try { testDelete_only(); } finally { tearDown(); }
    }
}
