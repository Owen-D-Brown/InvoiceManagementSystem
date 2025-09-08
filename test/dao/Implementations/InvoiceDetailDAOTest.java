/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.util.ArrayList;
import java.util.List;
import model.Invoice;
import model.InvoiceDetail;
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
public class InvoiceDetailDAOTest {
    
    public InvoiceDetailDAOTest() {
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
     * Test of getByInvoiceNumber method, of class InvoiceDetailDAO.
     */
    @Test
    public void testGetByInvoiceNumber() {
        System.out.println("getByInvoiceNumber");
        int number = 0;
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        ArrayList<InvoiceDetail> expResult = null;
        ArrayList<InvoiceDetail> result = instance.getByInvoiceNumber(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class InvoiceDetailDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        InvoiceDetail expResult = null;
        InvoiceDetail result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class InvoiceDetailDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        List<InvoiceDetail> expResult = null;
        List<InvoiceDetail> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class InvoiceDetailDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object t = null;
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        boolean expResult = false;
        boolean result = instance.insert(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class InvoiceDetailDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object t = null;
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class InvoiceDetailDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByInvoiceNumber method, of class InvoiceDetailDAO.
     */
    @Test
    public void testDeleteByInvoiceNumber() throws Exception {
        System.out.println("deleteByInvoiceNumber");
        Invoice t = null;
        boolean test = false;
        InvoiceDetailDAO instance = new InvoiceDetailDAO();
        boolean expResult = false;
        boolean result = instance.deleteByInvoiceNumber(t, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
