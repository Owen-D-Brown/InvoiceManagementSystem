/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import GuiComponents.MainFrame;
import GuiFactories.InvoiceTableModelFactory;
import dto.FullClientDTO;
import dto.FullContactDTO;
import dto.FullInvoiceDTO;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
import model.ClientAddress;
import model.Contact;
import model.Invoice;
import model.PONumber;
import service.implementations.ClientService;
import service.implementations.InvoiceService;

/**
 *
 * @author owen
 */
public class InvoiceController {
    private InvoiceService invoiceService = new InvoiceService();
    private ClientService clientService = new ClientService();
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
    
    int currentRowCount = 0;
    
    public void swapToEditView(int invoiceNo) {
        
        //Get invoice and client info
        Invoice invoice = invoiceService.getListViewInvoiceById(invoiceNo, false);
        FullClientDTO client = clientService.getById(invoice.getContactID(), true);
        
        int clientId = invoice.getClientID();
        int contactId = invoice.getContactID();
        int poNumberId = invoice.getPoNumberID();
        
        //Setting box information
        frame.editInvoiceNo.setText(frame.invoiceNo.getText());
        frame.editDueDate.setText(frame.invoiceDueDate.getText());
        frame.editDate.setText(frame.invoiceDate.getText());
        
        
        //Populate Contacts for Client
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (FullContactDTO contact : client.getContacts()) {
            model.addElement(contact.getContact().getContactFirstName()+" "+contact.getContact().getContactLastName()); // or toString()
        
        frame.contactCombo.setModel(model);
        frame.contactCombo.setSelectedItem(frame.contactNameLabel.getText());
        }
        

        //Populate PONumbers for Contact
        DefaultComboBoxModel<String> poModel = new DefaultComboBoxModel<>();
        
        FullContactDTO c = client.getContactByID(contactId);
        for(PONumber no : c.getPoNumbers()) {
            poModel.addElement(no.getPONumber());
            if(no.getPONumberID() == poNumberId) {
                frame.PONumberCombo.setSelectedItem(no);
            }
        }
        frame.PONumberCombo.setModel(poModel);
        
        //Populating Addresses for Client
        DefaultComboBoxModel<String> addModel = new DefaultComboBoxModel<>();
        
        
        for(ClientAddress ca : client.getClientAddresses()) {
            addModel.addElement(ca.getClientPrintAddress());
           
        }
        frame.clientAddressCombo.setModel(poModel);
        frame.clientAddressCombo.setSelectedItem(frame.streetAddress.getText());
        
        
        //set details table
        
        
        CardLayout layout = (CardLayout) jPanel2.getLayout();
        layout.show(jPanel2, "editInvoice");
      currentRowCount = jTable3.getRowCount();
        
    }
    
    //edit invoice btn
    /*
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        
        editInvoicePanel.revalidate();
        editInvoicePanel.repaint();
        try {
            
            
            
    
    
            jTable3.setModel(searchTable("InvoiceDetails"));//populates details table
    
    
            jScrollPane3.setSize(new Dimension(587, ((jTable3.getRowCount()*jTable3.getRowHeight())+jTable3.getTableHeader().getHeight())));
            

    
    
          
            
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }                                        

    */
    
    
}
