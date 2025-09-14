/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import GuiComponents.MainFrame;
import GuiFactories.InvoiceTableModelFactory;
import dto.FullInvoiceDTO;
import java.text.SimpleDateFormat;
import javax.swing.table.TableModel;
import service.implementations.InvoiceService;

/**
 *
 * @author owen
 */
public class InvoiceController {
    private InvoiceService invoiceService = new InvoiceService();
    MainFrame frame;
    
    public InvoiceController(MainFrame instance) {
        this.frame = instance;
    }

    public FullInvoiceDTO getDisplayInvoice(int id, boolean test) {
        return invoiceService.getFullInvoiceById(id, test);
    }
    
    public void populateViewInvoiceOnTableChange(int invoiceNo) {
     
        FullInvoiceDTO invoice = getDisplayInvoice(invoiceNo, false);
        TableModel details = InvoiceTableModelFactory.getInvoiceDetailTableModel(invoice.getInvoiceItems());
        
        
        frame.clientName.setText(invoice.getInvoiceHeader().getClientName());
        frame.streetAddress.setText(invoice.getInvoiceHeader().getAddress());
        frame.invoiceNo.setText(Integer.toString(invoice.getInvoiceHeader().getInvoiceNumber()));
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
        String dateStr = fmt.format(invoice.getInvoiceHeader().getInvoiceDate());
        String dueDateStr = fmt.format(invoice.getInvoiceHeader().getInvoiceDate());
        frame.invoiceDate.setText(dateStr);
        frame.poNumber.setText(invoice.getInvoiceHeader().getPoNumber());
        frame.invoiceDueDate.setText(dueDateStr);
        frame.contactNameLabel.setText(invoice.getInvoiceHeader().getContactName());
        frame.jTable2.setModel(details);
      
        frame.updateViewInvoicePanel();
    }
    
    
    
}
