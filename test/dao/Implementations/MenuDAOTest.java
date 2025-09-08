/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.util.List;
import model.MenuItem;
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
public class MenuDAOTest {
    
    public MenuDAOTest() {
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
     * Test of getByName method, of class MenuDAO.
     */
    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String name = "";
        MenuDAO instance = new MenuDAO();
        MenuItem expResult = null;
        MenuItem result = instance.getByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class MenuDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        MenuDAO instance = new MenuDAO();
        MenuItem expResult = null;
        MenuItem result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class MenuDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        MenuDAO instance = new MenuDAO();
        List<MenuItem> expResult = null;
        List<MenuItem> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class MenuDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object t = null;
        MenuDAO instance = new MenuDAO();
        boolean expResult = false;
        boolean result = instance.insert(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MenuDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object t = null;
        MenuDAO instance = new MenuDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MenuDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        MenuDAO instance = new MenuDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
