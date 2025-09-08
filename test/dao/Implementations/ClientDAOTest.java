/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.util.List;
import model.Client;
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
public class ClientDAOTest {
    
    public ClientDAOTest() {
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
     * Test of getByName method, of class ClientDAO.
     */
    @Test
    public void testGetByName() {
        System.out.println("getByName");
        String name = "";
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.getByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByNumber method, of class ClientDAO.
     */
    @Test
    public void testGetByNumber() {
        System.out.println("getByNumber");
        int number = 0;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.getByNumber(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class ClientDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        ClientDAO instance = new ClientDAO();
        Client expResult = null;
        Client result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ClientDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ClientDAO instance = new ClientDAO();
        List<Client> expResult = null;
        List<Client> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class ClientDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object t = null;
        ClientDAO instance = new ClientDAO();
        boolean expResult = false;
        boolean result = instance.insert(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object t = null;
        ClientDAO instance = new ClientDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClientDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        ClientDAO instance = new ClientDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
