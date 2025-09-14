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
import model.Contact;
import model.Invoice;
import model.InvoiceDetail;
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
public class InvoiceDetailDAOTest {
    
    private InvoiceDetailDAO dao;
    private Integer insertedDetailId;

    @Before
    public void setUp() {
        dao = new InvoiceDetailDAO();
        insertedDetailId = null;
    }

    //Delete the temporary record created for testing
    @After
    public void tearDown() throws Exception {
        if (insertedDetailId != null) {
            try (Connection conn = DatabasePipeline.openTestConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM InvoiceDetails WHERE DetailID = ?")) {
                ps.setInt(1, insertedDetailId);
                ps.executeUpdate();
            }
            insertedDetailId = null;
        }
    }

    //--- Individual Unit Tests ---//
    
    @Test
    public void testInsert_only() throws Exception {
        
        InvoiceDetail c = new InvoiceDetail();
        c.setInvoiceNumber(1);
        c.setItemID(1);
        c.setItemQuantity(1);
        
   

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getDetailID()> 0);
        insertedDetailId = c.getDetailID();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT InvoiceNumber, ItemID, ItemQuantity " +
                                                         "FROM InvoiceDetails WHERE DetailID = ?")
        ) 
        {
            ps.setInt(1, insertedDetailId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals(1, rs.getInt("InvoiceNumber"));
                assertEquals(1, rs.getInt("ItemID"));
                assertEquals(1, rs.getInt("ItemQuantity"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
        InvoiceDetail c = new InvoiceDetail();
        c.setInvoiceNumber(1);
        c.setItemID(1);
        c.setItemQuantity(1);

        assertTrue(dao.insert(c, true));
        assertTrue(c.getDetailID()> 0);
        insertedDetailId = c.getDetailID();

        c.setInvoiceNumber(2);
        c.setItemID(2);
        c.setItemQuantity(2);


        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", updated);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT InvoiceNumber, ItemID, ItemQuantity " +
                                                         "FROM InvoiceDetails WHERE DetailID = ?")
        ) 
        {
            ps.setInt(1, insertedDetailId);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals(2, rs.getInt("InvoiceNumber"));
                assertEquals(2, rs.getInt("ItemID"));
                assertEquals(2, rs.getInt("ItemQuantity"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        InvoiceDetail c = new InvoiceDetail();
        c.setInvoiceNumber(1);
        c.setItemID(1);
        c.setItemQuantity(1);


        assertTrue(dao.insert(c, true));
        assertTrue(c.getDetailID()> 0);
        insertedDetailId = c.getDetailID();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM InvoiceDetails WHERE DetailID = ?")
        ) 
        {
            ps.setInt(1, insertedDetailId);
            try (ResultSet rs = ps.executeQuery()) {
                assertFalse("Row should not exist after delete", rs.next());
            }
        }   

        //Prevents @after trying to remove an already deleted record
        insertedDetailId = null;
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
