/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import GuiComponents.MainFrame;
import GuiFactories.InvoiceTableModelFactory.InvoiceDetailTableModel;
import dto.FullInvoiceDTO;
import dto.InvoiceItemDTO;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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

    int currentRowCount;
    ArrayList<String[]> items = new ArrayList<>();
    public void addRowEditBtnActionPerformed(java.awt.event.ActionEvent evt) {
    InvoiceDetailTableModel model = (InvoiceDetailTableModel) frame.jTable3.getModel();

    // If table is empty, just add a blank row and focus it.
    if (model.getRowCount() == 0) {
        model.addItem(new InvoiceItemDTO());
        frame.jTable3.editCellAt(0, 0);
        frame.jTable3.requestFocus();
        return;
    }

    int lastRow = model.getRowCount() - 1;
    // Read via model (cleaner than table)
    InvoiceItemDTO last = model.getRow(lastRow);

    String name = last.getItemName() == null ? "" : last.getItemName().trim();
    String priceStr = String.valueOf(last.getUnitPrice());
    String qtyStr   = String.valueOf(last.getQuantity());

    boolean nameOk  = !name.isEmpty();
    boolean priceOk = priceStr != null && !priceStr.trim().isEmpty();
    boolean qtyOk   = qtyStr != null && !qtyStr.trim().isEmpty();

    if (nameOk && priceOk && qtyOk) {
        // Mirror your old behavior: capture the completed row into 'items' if row count grew
        if (model.getRowCount() > currentRowCount) {
            String[] re = new String[3];
            re[0] = name;
            re[1] = priceStr;
            re[2] = qtyStr;
            items.add(re);
        }

        // Add a new blank row for the next entry
        model.addItem(new InvoiceItemDTO());

        // No need to call setModel() again; model already attached.
        // A simple revalidate/repaint is enough if you really need it:
        frame.editInvoicePanel.revalidate();
        frame.editInvoicePanel.repaint();

        // Optionally focus the first cell of the new row
        int newRow = model.getRowCount() - 1;
        frame.jTable3.changeSelection(newRow, 0, false, false);
        frame.jTable3.editCellAt(newRow, 0);
        frame.jTable3.requestFocus();

    } else {
        JOptionPane.showMessageDialog(
            frame,
            "Please ensure you have filled in the previous record before adding another.",
            "Incomplete row",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}

}
