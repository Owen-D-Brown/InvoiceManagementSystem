package dao.Implementations;

import model.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DatabasePipeline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        
        Client c = new Client();
        c.setClientName("Test Client");
        c.setClientEmail("testclient@example.com");
        c.setClientNumber("999888777");
        c.setClientWebsite("www.testclient.com");

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getClientID() > 0);
        insertedAddresstId = c.getClientID();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ClientName, ClientEmail, ClientNumber, ClientWebsite FROM Clients WHERE ClientID = ?")
        ) 
        {
            ps.setInt(1, insertedAddresstId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("Test Client", rs.getString("ClientName"));
                assertEquals("testclient@example.com", rs.getString("ClientEmail"));
                assertEquals("999888777", rs.getString("ClientNumber"));
                assertEquals("www.testclient.com", rs.getString("ClientWebsite"));
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
        Client c = new Client();
        c.setClientName("Before Update");
        c.setClientEmail("before@example.com");
        c.setClientNumber("111222333");
        c.setClientWebsite("www.before.com");

        assertTrue(dao.insert(c, true));
        assertTrue(c.getClientID() > 0);
        insertedAddresstId = c.getClientID();

        c.setClientName("After Update");
        c.setClientEmail("after@example.com");
        c.setClientNumber("444555666");
        c.setClientWebsite("www.after.com");

        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", updated);

        try (Connection conn = DatabasePipeline.openTestConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT ClientName, ClientEmail, ClientNumber, ClientWebsite FROM Clients WHERE ClientID = ?")) {
            ps.setInt(1, insertedAddresstId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("After Update", rs.getString("ClientName"));
                assertEquals("after@example.com", rs.getString("ClientEmail"));
                assertEquals("444555666", rs.getString("ClientNumber"));
                assertEquals("www.after.com", rs.getString("ClientWebsite"));
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        Client c = new Client();
        c.setClientName("To Delete");
        c.setClientEmail("delete@example.com");
        c.setClientNumber("777888999");
        c.setClientWebsite("www.delete.com");

        assertTrue(dao.insert(c, true));
        assertTrue(c.getClientID() > 0);
        insertedAddresstId = c.getClientID();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (Connection conn = DatabasePipeline.openTestConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM Clients WHERE ClientID = ?")) {
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
