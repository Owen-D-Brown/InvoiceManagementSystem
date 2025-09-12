/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package GuiFactories;

import Controller.InvoiceController;
import dto.FullInvoiceDTO;
import dto.InvoiceItemDTO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
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
public class InvoiceTableModelFactoryTest {
    
    public InvoiceTableModelFactoryTest() {
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
     * Test of fromDTOs method, of class InvoiceTableModelFactory.
     */
    @Test
    public void testFromDTOs() {
        System.out.println("fromDTOs");
        List<FullInvoiceDTO> data = null;
        AbstractTableModel expResult = null;
        AbstractTableModel result = InvoiceTableModelFactory.fromDTOs(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoiceDetailTableModel method, of class InvoiceTableModelFactory.
     */
    @Test
    public void testGetInvoiceDetailTableModel() {
        InvoiceController controller = new InvoiceController();
        FullInvoiceDTO fullInvoiceDTO = controller.getDisplayInvoice(1, true);
        TableModel model = InvoiceTableModelFactory.getInvoiceDetailTableModel(fullInvoiceDTO.getInvoiceItems());
        
        // Print header row
        for (int c = 0; c < model.getColumnCount(); c++) {
            System.out.print(model.getColumnName(c) + "\t");
        }
        System.out.println();

        // Print table data
        for (int r = 0; r < model.getRowCount(); r++) {
            for (int c = 0; c < model.getColumnCount(); c++) {
                System.out.print(model.getValueAt(r, c) + "\t");
            }
            System.out.println();
        }
    }
    
}
