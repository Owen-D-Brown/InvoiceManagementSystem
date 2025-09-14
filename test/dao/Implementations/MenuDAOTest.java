/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.InvoiceDetail;
import model.MenuItem;
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
public class MenuDAOTest {
    
    private MenuDAO dao;
    private Integer insertedItemId;

    @Before
    public void setUp() {
        dao = new MenuDAO();
        insertedItemId = null;
    }

    //Delete the temporary record created for testing
    @After
    public void tearDown() throws Exception {
        if (insertedItemId != null) {
            try (Connection conn = DatabasePipeline.openTestConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Menu WHERE ItemID = ?")) {
                ps.setInt(1, insertedItemId);
                ps.executeUpdate();
            }
            insertedItemId = null;
        }
    }

    //--- Individual Unit Tests ---//
    
    @Test
    public void testInsert_only() throws Exception {
        
        MenuItem c = new MenuItem();
        c.setItemName("insert item");
        c.setItemPrice(1);
        c.setItemWeight(1);
        c.setItemCost(1);
        
   

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getItemID()> 0);
        insertedItemId = c.getItemID();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ItemName, ItemPrice, ItemWeight, ItemCost " +
                                                         "FROM Menu WHERE ItemID = ?")
        ) 
        {
            ps.setInt(1, insertedItemId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("insert item", rs.getString("ItemName"));
                assertEquals(1, rs.getInt("ItemPrice"));
                assertEquals(1, rs.getInt("ItemWeight"));
                assertEquals(1, rs.getInt("ItemCost"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
        MenuItem c = new MenuItem();
        c.setItemName("insert item");
        c.setItemPrice(1);
        c.setItemWeight(1);
        c.setItemCost(1);

        assertTrue(dao.insert(c, true));
        assertTrue(c.getItemID()> 0);
        insertedItemId = c.getItemID();

        c.setItemName("insert item update");
        c.setItemPrice(2);
        c.setItemWeight(2);
        c.setItemCost(2);


        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", updated);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT ItemName, ItemPrice, ItemWeight, ItemCost " +
                                                         "FROM Menu WHERE ItemID = ?")
        ) 
        {
            ps.setInt(1, insertedItemId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("insert item update", rs.getString("ItemName"));
                assertEquals(2, rs.getInt("ItemPrice"));
                assertEquals(2, rs.getInt("ItemWeight"));
                assertEquals(2, rs.getInt("ItemCost"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        MenuItem c = new MenuItem();
        c.setItemName("insert item");
        c.setItemPrice(1);
        c.setItemWeight(1);
        c.setItemCost(1);


        assertTrue(dao.insert(c, true));
        assertTrue(c.getItemID()> 0);
        insertedItemId = c.getItemID();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM Menu WHERE ItemID = ?")
        ) 
        {
            ps.setInt(1, insertedItemId);
            try (ResultSet rs = ps.executeQuery()) {
                assertFalse("Row should not exist after delete", rs.next());
            }
        }   

        //Prevents @after trying to remove an already deleted record
        insertedItemId = null;
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
