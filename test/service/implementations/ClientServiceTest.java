/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service.implementations;

import dao.Implementations.ClientDAO;
import dto.FullClientDTO;
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
public class ClientServiceTest {
    
    public ClientServiceTest() {
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
     * Test of getById method, of class ClientService.
     */
  
    @Test
    public void testGetById() {
          ClientService dao = new ClientService();
        FullClientDTO client = dao.getById(1, true);
        System.out.println(client);
        
    }

    /**
     * Test of getAll method, of class ClientService.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        boolean test = false;
        ClientService instance = new ClientService();
        ArrayList<FullClientDTO> expResult = null;
        ArrayList<FullClientDTO> result = instance.getAll(test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ClientService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        FullClientDTO client = null;
        boolean test = false;
        ClientService instance = new ClientService();
        int expResult = 0;
        int result = instance.create(client, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        FullClientDTO client = null;
        boolean test = false;
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.update(client, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClientService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        FullClientDTO client = null;
        boolean test = false;
        ClientService instance = new ClientService();
        boolean expResult = false;
        boolean result = instance.delete(client, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
