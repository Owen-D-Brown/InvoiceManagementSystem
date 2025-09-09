/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service.implementations;

import dto.FullInvoiceDTO;
import java.util.ArrayList;
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
public class InvoiceServiceTest {
    
    public InvoiceServiceTest() {
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
     * Test of getById method, of class InvoiceService.
     */
    @Test
    public void testGetById() {
       InvoiceService service = new InvoiceService();
      FullInvoiceDTO fidto = service.getById(1);
      System.out.println(fidto);
    }

    /**
     * Test of getAll method, of class InvoiceService.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        InvoiceService instance = new InvoiceService();
        ArrayList<FullInvoiceDTO> expResult = null;
        ArrayList<FullInvoiceDTO> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class InvoiceService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        FullInvoiceDTO invoice = null;
        InvoiceService instance = new InvoiceService();
        int expResult = 0;
        int result = instance.create(invoice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class InvoiceService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        FullInvoiceDTO invoice = null;
        InvoiceService instance = new InvoiceService();
        boolean expResult = false;
        boolean result = instance.update(invoice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class InvoiceService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        FullInvoiceDTO invoice = null;
        InvoiceService instance = new InvoiceService();
        boolean expResult = false;
        boolean result = instance.delete(invoice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
