/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Contact;
import model.Invoice;
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
public class InvoiceDAOTest {
    
    private InvoiceDAO dao;
    private Integer insertedInvoiceNo;

    @Before
    public void setUp() {
        dao = new InvoiceDAO();
        insertedInvoiceNo = null;
    }

    //Delete the temporary record created for testing
    @After
    public void tearDown() throws Exception {
        if (insertedInvoiceNo != null) {
            try (Connection conn = DatabasePipeline.openTestConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Invoices WHERE InvoiceNumber = ?")) {
                ps.setInt(1, insertedInvoiceNo);
                ps.executeUpdate();
            }
            insertedInvoiceNo = null;
        }
    }

    //--- Individual Unit Tests ---//

    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");//For date fields
    
    @Test
    public void testInsert_only() throws Exception {
        
        

        Invoice c = new Invoice();
        c.setInvoiceDate(fmt.parse("01/03/2023"));
        c.setInvoiceDueDate(fmt.parse("15/03/2023"));
        c.setInvoiceBookingDate(fmt.parse("01/03/2023"));
        c.setInvoiceSubtotal((float) 150.75);
        c.setInvoiceTotal((float) 150.75);
        c.setInvoicePaid(false);
        c.setInvoiceNotes("Test invoice insertion");
        c.setClientID(1);
        c.setContactID(2);

        assertTrue(dao.insert(c, true));
        assertTrue(c.getInvoiceNumber() > 0);
        
   

        boolean inserted = dao.insert(c, true);
        assertTrue("Insert should succeed", inserted);
        assertTrue("DAO should set generated ID", c.getInvoiceNumber()> 0);
        insertedInvoiceNo = c.getInvoiceNumber();

        //Verify that the inserted record is correct
        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT InvoiceDate, InvoiceDueDate, InvoiceBookingDate, " +
                                                         "InvoiceSubtotal, InvoiceTotal, InvoicePaid, InvoiceNotes, ClientID, ContactID " +
                                                         "FROM Invoices WHERE InvoiceNumber = ?")
        ) 
        {
            ps.setInt(1, insertedInvoiceNo);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("01/03/2023", rs.getString("InvoiceDate"));
                assertEquals("15/03/2023", rs.getString("InvoiceDueDate"));
                assertEquals("01/03/2023", rs.getString("InvoiceBookingDate"));
                assertEquals(150.75, rs.getDouble("InvoiceSubtotal"), 0.001);
                assertEquals(150.75, rs.getDouble("InvoiceTotal"), 0.001);
                assertFalse("InvoicePaid should be false", rs.getBoolean("InvoicePaid"));
                assertEquals("Test invoice insertion", rs.getString("InvoiceNotes"));
                assertEquals(1, rs.getInt("ClientID"));
                assertEquals(2, rs.getInt("ContactID"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testUpdate_only() throws Exception {
        
          Invoice c = new Invoice();
        c.setInvoiceDate(fmt.parse("01/03/2023"));
        c.setInvoiceDueDate(fmt.parse("15/03/2023"));
        c.setInvoiceBookingDate(fmt.parse("01/03/2023"));
        c.setInvoiceSubtotal((float) 150.75);
        c.setInvoiceTotal((float) 150.75);
        c.setInvoicePaid(false);
        c.setInvoiceNotes("Test invoice insertion");
        c.setClientID(1);
        c.setContactID(2);

        assertTrue(dao.insert(c, true));
        assertTrue(c.getInvoiceNumber() > 0);
        insertedInvoiceNo = c.getInvoiceNumber();

        c.setInvoiceDate(fmt.parse("02/03/2023"));
        c.setInvoiceDueDate(fmt.parse("16/03/2023"));
        c.setInvoiceBookingDate(fmt.parse("02/03/2023"));
        c.setInvoiceSubtotal((float) 200.00);
        c.setInvoiceTotal((float) 200.00);
        c.setInvoicePaid(true);
        c.setInvoiceNotes("After update");
        c.setClientID(1);
        c.setContactID(3); // choose an existing contact if needed
        boolean updated = dao.update(c, true);
        assertTrue("Update should succeed", dao.update(c, true));

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT InvoiceDate, InvoiceDueDate, InvoiceBookingDate, " +
                                                         "InvoiceSubtotal, InvoiceTotal, InvoicePaid, InvoiceNotes, ClientID, ContactID " +
                                                         "FROM Invoices WHERE InvoiceNumber = ?")
        ) 
        {
            ps.setInt(1, insertedInvoiceNo);
            try (ResultSet rs = ps.executeQuery()) {
                assertTrue("Row should exist", rs.next());
                assertEquals("02/03/2023", rs.getString("InvoiceDate"));
                assertEquals("16/03/2023", rs.getString("InvoiceDueDate"));
                assertEquals("02/03/2023", rs.getString("InvoiceBookingDate"));
                assertEquals(200.00, rs.getDouble("InvoiceSubtotal"), 0.001);
                assertEquals(200.00, rs.getDouble("InvoiceTotal"), 0.001);
                assertTrue("InvoicePaid should be true", rs.getBoolean("InvoicePaid"));
                assertEquals("After update", rs.getString("InvoiceNotes"));
                assertEquals(1, rs.getInt("ClientID"));
                assertEquals(3, rs.getInt("ContactID"));
                assertFalse("Only one row expected", rs.next());
            }
        }
    }

    @Test
    public void testDelete_only() throws Exception {
        
        Invoice c = new Invoice();
        c.setInvoiceDate(fmt.parse("01/03/2023"));
        c.setInvoiceDueDate(fmt.parse("15/03/2023"));
        c.setInvoiceBookingDate(fmt.parse("01/03/2023"));
        c.setInvoiceSubtotal((float) 150.75);
        c.setInvoiceTotal((float) 150.75);
        c.setInvoicePaid(false);
        c.setInvoiceNotes("Test invoice insertion");
        c.setClientID(1);
        c.setContactID(2);

        assertTrue(dao.insert(c, true));
        assertTrue(c.getInvoiceNumber()> 0);
        insertedInvoiceNo = c.getInvoiceNumber();

        boolean deleted = dao.delete(c, true);
        assertTrue("Delete should succeed", deleted);

        try (
            Connection conn = DatabasePipeline.openTestConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT 1 FROM Invoices WHERE InvoiceNumber = ?")
        ) 
        {
            ps.setInt(1, insertedInvoiceNo);
            try (ResultSet rs = ps.executeQuery()) {
                assertFalse("Row should not exist after delete", rs.next());
            }
        }   

        //Prevents @after trying to remove an already deleted record
        insertedInvoiceNo = null;
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
