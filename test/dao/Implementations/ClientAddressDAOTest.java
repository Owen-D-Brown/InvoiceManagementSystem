package dao.Implementations;

import model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DatabasePipeline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ClientAddress;

import static org.junit.Assert.*;

public class ClientAddressDAOTest {

    private ClientAddressDAO dao;
    private Integer insertedAddresstId;

    @Before
    public void setUp() {
        dao = new ClientAddressDAO();
        insertedAddresstId = null;
    }

    //Delete the temporary record created for testing
    @After
    public void tearDown() throws Exception {
        if (insertedAddresstId != null) {
            try (Connection conn = DatabasePipeline.openTestConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM ClientAddresses WHERE AddressID = ?")) {
                ps.setInt(1, insertedAddresstId);
                ps.executeUpdate();
            }
            insertedAddresstId = null;
        }
    }

    //--- Individual Unit Tests ---//
    
    @Test
    public void testInsert_only() throws Exception {
        
        ClientAddress c = new ClientAddress();
        c.setClientID(1);
        c.setStreetAddress("1 Street");
        c.setAreaAddress("Dublin");
        c.setClientCounty("Inserted County");
        c.setClientEircode("DDD DDDD");
        c.setClientPrintAddress("Inserted Print Address");
        
   

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getAddressID()> 0);
        insertedAddresstId = c.getAddressID();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ClientID, StreetAddress, AreaAddress, ClientCounty, ClientEircode, ClientPrintAddress " +
                                                         "FROM ClientAddresses WHERE AddressID = ?")
        ) 
        {
            ps.setInt(1, insertedAddresstId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals(1, rs.getInt("ClientID"));
                assertEquals("1 Street", rs.getString("StreetAddress"));
                assertEquals("Dublin", rs.getString("AreaAddress"));
                assertEquals("Inserted County", rs.getString("ClientCounty"));
                assertEquals("DDD DDDD", rs.getString("ClientEircode"));
                assertEquals("Inserted Print Address", rs.getString("ClientPrintAddress"));
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
        ClientAddress c = new ClientAddress();
        c.setClientID(1);
        c.setStreetAddress("1 Street");
        c.setAreaAddress("Dublin");
        c.setClientCounty("Inserted County");
        c.setClientEircode("DDD DDDD");
        c.setClientPrintAddress("Inserted Print Address");

        assertTrue(dao.insert(c, true));
        assertTrue(c.getAddressID()> 0);
        insertedAddresstId = c.getAddressID();

        c.setStreetAddress("2 Updated Street");
        c.setAreaAddress("Updated Area");
        c.setClientCounty("Updated County");
        c.setClientEircode("AAA AAAA");
        c.setClientPrintAddress("Updated Print Address");


        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", updated);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT StreetAddress, AreaAddress, ClientCounty, ClientEircode, ClientPrintAddress " +
                                                         "FROM ClientAddresses WHERE AddressID = ?")
        ) 
        {
            ps.setInt(1, insertedAddresstId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("2 Updated Street", rs.getString("StreetAddress"));
                assertEquals("Updated Area", rs.getString("AreaAddress"));
                assertEquals("Updated County", rs.getString("ClientCounty"));
                assertEquals("AAA AAAA", rs.getString("ClientEircode"));
                assertEquals("Updated Print Address", rs.getString("ClientPrintAddress"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        ClientAddress c = new ClientAddress();
        c.setClientID(1);  
        c.setStreetAddress("Delete St");
        c.setAreaAddress("Dublin");
        c.setClientCounty("Delete County");
        c.setClientEircode("DEL 1234");
        c.setClientPrintAddress("Delete Address, Dublin, Delete County, DEL 1234");


        assertTrue(dao.insert(c, true));
        assertTrue(c.getAddressID()> 0);
        insertedAddresstId = c.getAddressID();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (Connection conn = DatabasePipeline.openTestConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM ClientAddresses WHERE AddressID = ?")) {
            ps.setInt(1, insertedAddresstId);
            try (ResultSet rs = ps.executeQuery()) {
                assertFalse("Row should not exist after delete", rs.next());
            }
        }

        //Prevents @after trying to remove an already deleted record
        insertedAddresstId = null;
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
