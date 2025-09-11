/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import dto.FullInvoiceDTO;
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
public class DisplayInvoiceDAOTest {
    
    public DisplayInvoiceDAOTest() {
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
     * Test of getByInvoiceNumber method, of class DisplayInvoiceDAO.
     */
    @Test
    public void testGetByInvoiceNumber() {
        System.out.println("getByInvoiceNumber");
        int invoiceNumber = 1;
        boolean test = false;
        DisplayInvoiceDAO instance = new DisplayInvoiceDAO();
        
        FullInvoiceDTO result = instance.getByInvoiceNumber(invoiceNumber, test);
        System.out.println(result);
    }
    
}
