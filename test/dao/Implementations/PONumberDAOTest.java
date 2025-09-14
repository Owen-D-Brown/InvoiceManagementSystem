/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.MenuItem;
import model.PONumber;
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
public class PONumberDAOTest {
    
    private PONumberDAO dao;
    private Integer insertedPONumberId;

    @Before
    public void setUp() {
        dao = new PONumberDAO();
        insertedPONumberId = null;
    }

    //Delete the temporary record created for testing
    @After
    public void tearDown() throws Exception {
        if (insertedPONumberId != null) {
            try (Connection conn = DatabasePipeline.openTestConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM PONumbers WHERE PONumberID = ?")) {
                ps.setInt(1, insertedPONumberId);
                ps.executeUpdate();
            }
            insertedPONumberId = null;
        }
    }

    //--- Individual Unit Tests ---//
    
    @Test
    public void testInsert_only() throws Exception {
        
        PONumber c = new PONumber();
        c.setContactID(1);
        c.setPONumber("333123");
   

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getPONumberID()> 0);
        insertedPONumberId = c.getPONumberID();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ContactID, PONumber " +
                                                         "FROM PONumbers WHERE PONumberID = ?")
        ) 
        {
            ps.setInt(1, insertedPONumberId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals(1, rs.getInt("ContactID"));
                assertEquals("333123", rs.getString("PONumber"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
        PONumber c = new PONumber();
        c.setContactID(1);
        c.setPONumber("000123");

        assertTrue(dao.insert(c, true));
        assertTrue(c.getPONumberID()> 0);
        insertedPONumberId = c.getPONumberID();

        c.setContactID(2);
        c.setPONumber("444123");



        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", updated);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ContactID, PONumber " +
                                                         "FROM PONumbers WHERE PONumberID = ?")
        ) 
        {
            ps.setInt(1, insertedPONumberId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals(2, rs.getInt("ContactID"));
                assertEquals("444123", rs.getString("PONumber"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        PONumber c = new PONumber();
        c.setContactID(1);
        c.setPONumber("000123");


        assertTrue(dao.insert(c, true));
        assertTrue(c.getPONumberID()> 0);
        insertedPONumberId = c.getPONumberID();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM PONumbers WHERE PONumberID = ?")
        ) 
        {
            ps.setInt(1, insertedPONumberId);
            try (ResultSet rs = ps.executeQuery()) {
                assertFalse("Row should not exist after delete", rs.next());
            }
        }   

        //Prevents @after trying to remove an already deleted record
        insertedPONumberId = null;
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
