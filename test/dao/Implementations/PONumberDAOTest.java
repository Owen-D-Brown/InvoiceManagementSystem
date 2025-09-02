/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.util.List;
import model.PONumber;
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
public class PONumberDAOTest {
    
    public PONumberDAOTest() {
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
     * Test of getByContactId method, of class PONumberDAO.
     */
    @Test
    public void testGetByContactId() {
        System.out.println("getByContactId");
        int id = 1;
        PONumberDAO instance = new PONumberDAO();
        PONumber result = instance.getByContactId(id);
        System.out.println(result);
        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class PONumberDAO.
     */
    @Test
    public void testGetById() {
         System.out.println("getByContactId");
        int id = 1;
        PONumberDAO instance = new PONumberDAO();
        PONumber result = instance.getById(id);
        System.out.println(result);
        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class PONumberDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        PONumberDAO instance = new PONumberDAO();
        List<PONumber> expResult = null;
        List<PONumber> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class PONumberDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object t = null;
        PONumberDAO instance = new PONumberDAO();
        boolean expResult = false;
        boolean result = instance.insert(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PONumberDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object t = null;
        PONumberDAO instance = new PONumberDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PONumberDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        PONumberDAO instance = new PONumberDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
