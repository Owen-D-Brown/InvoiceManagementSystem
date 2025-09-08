/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao.Implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ClientAddress;
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
public class ClientAddressDAOTest {
    
    public ClientAddressDAOTest() {
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
     * Test of getByClientId method, of class ClientAddressDAO.
     */
    @Test
    public void testGetByClientId() {
        System.out.println("getByClientId");
        int id = 0;
        ClientAddressDAO instance = new ClientAddressDAO();
        ArrayList<ClientAddress> expResult = null;
        ArrayList<ClientAddress> result = instance.getByClientId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class ClientAddressDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        ClientAddressDAO instance = new ClientAddressDAO();
        ClientAddress expResult = null;
        ClientAddress result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ClientAddressDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ClientAddressDAO instance = new ClientAddressDAO();
        List<ClientAddress> expResult = null;
        List<ClientAddress> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class ClientAddressDAO.
     */
    @Test
    public void testInsert() throws SQLException {
        System.out.println("insert");
        ClientAddressDAO instance = new ClientAddressDAO();
        boolean expResult = true;
        ClientAddress ca = new ClientAddress();
        ca.setClientID(1);
        ca.setStreetAddress("123 Main Street");
        ca.setAreaAddress("Dublin City Centre");
        ca.setClientCounty("Dublin");
        ca.setClientEircode("D01 ABC1");
        ca.setClientPrintAddress("123 Main Street, Dublin City Centre, Dublin, D01 ABC1");
        boolean result = instance.insert(ca, true);
        assertEquals(expResult, result);
   
    }

    /**
     * Test of update method, of class ClientAddressDAO.
     */
    @Test
    public void testUpdate() throws SQLException {
        ClientAddressDAO dao = new ClientAddressDAO();
        ClientAddress ca = new ClientAddress();
        ca.setAddressID(5);
        ca.setClientID(1); // MUST exist in Clients for FK, or have FK enforcement off in test DB
        ca.setStreetAddress("123 Main Street");
        ca.setAreaAddress("Dublin City Centre");
        ca.setClientCounty("Dublin");
        ca.setClientEircode("D01 ABC1");
        ca.setClientPrintAddress("123 Main Street, Dublin City Centre, Dublin, D01 ABC1");

        // ---------- Act: update a couple of fields ----------
        ca.setStreetAddress("456 New Street");
        ca.setAreaAddress("Dublin 2");
        boolean updated = dao.update(ca, true);

        // ---------- Assert: update call result ----------
        assertTrue("Update should return true", updated);

    }


    /**
     * Test of delete method, of class ClientAddressDAO.
     */
    @Test
    public void testDelete() throws SQLException {
      System.out.println("delete");
        int id = 11;
        ClientAddressDAO instance = new ClientAddressDAO();
        boolean expResult = true;
        ClientAddress ca = new ClientAddress();
        ca.setAddressID(id);
        ca.setClientID(1);
        ca.setStreetAddress("123 Main Street");
        ca.setAreaAddress("Dublin City Centre");
        ca.setClientCounty("Dublin");
        ca.setClientEircode("D01 ABC1");
        ca.setClientPrintAddress("123 Main Street, Dublin City Centre, Dublin, D01 ABC1");
        boolean result = instance.delete(ca, true);
        assertEquals(expResult, true);
    }
    
    
}
