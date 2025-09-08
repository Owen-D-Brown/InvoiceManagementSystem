/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.util.List;
import model.Invoice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author owen
 */
public class InvoiceDAOTest {
    
    public InvoiceDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getById method, of class InvoiceDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        InvoiceDAO instance = new InvoiceDAO();
        Invoice expResult = null;
        Invoice result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class InvoiceDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        InvoiceDAO instance = new InvoiceDAO();
        List<Invoice> expResult = null;
        List<Invoice> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class InvoiceDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object t = null;
        InvoiceDAO instance = new InvoiceDAO();
        boolean expResult = false;
        boolean result = instance.insert(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class InvoiceDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object t = null;
        InvoiceDAO instance = new InvoiceDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class InvoiceDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        InvoiceDAO instance = new InvoiceDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
