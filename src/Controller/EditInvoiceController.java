/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import GuiComponents.MainFrame;
import dto.FullInvoiceDTO;
import dto.InvoiceItemDTO;
import java.util.ArrayList;
import model.Invoice;
import service.implementations.InvoiceService;

/**
 *
 * @author owen
 */
public class EditInvoiceController {
    private InvoiceService invoiceService = new InvoiceService();
    MainFrame frame;
    
    public EditInvoiceController(MainFrame mF) {
        this.frame = mF;
    }
    
    public void updateInvoice(InvoiceController ctl) {
        
        /*create invioce from edit invoice elements
        ArrayList<InvoiceItemDTO> details = fullInvoice.getInvoiceItems();
        Invoice invoice = new Invoice();
        invoice.setClientID(fullInvoice.getInvoiceHeader().get);
        invoice.setContactID(0);
        invoice.setInvoiceBookingDate(invoiceBookingDate);
        invoice.setInvoiceDate(invoiceDate);
        invoice.setInvoiceDueDate(invoiceDueDate);
        invoice.setInvoiceNotes(invoiceNotes);
        invoice.setInvoiceNumber(0);
        invoice.setInvoicePaid(true);
        invoice.setInvoiceSubtotal(0);
        invoice.setInvoiceTotal(0);
        invoiceService.update(invoice, details, false);
        */
        
        //update jtable1
        ctl.populateViewInvoiceOnTableChange(0);//update view invoice
        frame.jTable1.setRowSelectionInterval(0,0);//select edited invoice on table
        //swap card layout
    }
}
