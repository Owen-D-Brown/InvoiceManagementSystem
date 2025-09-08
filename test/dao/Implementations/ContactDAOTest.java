/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.util.ArrayList;
import java.util.List;
import model.Contact;
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
public class ContactDAOTest {
    
    public ContactDAOTest() {
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
     * Test of getByClientId method, of class ContactDAO.
     */
    @Test
    public void testGetByClientId() {
        System.out.println("getByClientId");
        int id = 0;
        ContactDAO instance = new ContactDAO();
        ArrayList<Contact> expResult = null;
        ArrayList<Contact> result = instance.getByClientId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class ContactDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        ContactDAO instance = new ContactDAO();
        Contact expResult = null;
        Contact result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByFirstName method, of class ContactDAO.
     */
    @Test
    public void testGetByFirstName() {
        System.out.println("getByFirstName");
        String name = "";
        ContactDAO instance = new ContactDAO();
        Contact expResult = null;
        Contact result = instance.getByFirstName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ContactDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ContactDAO instance = new ContactDAO();
        List<Contact> expResult = null;
        List<Contact> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class ContactDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object t = null;
        ContactDAO instance = new ContactDAO();
        boolean expResult = false;
        boolean result = instance.insert(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ContactDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object t = null;
        ContactDAO instance = new ContactDAO();
        boolean expResult = false;
        boolean result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ContactDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        ContactDAO instance = new ContactDAO();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
