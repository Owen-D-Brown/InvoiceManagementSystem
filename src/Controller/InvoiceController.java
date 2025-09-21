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
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Client;
import model.ClientAddress;
import model.Contact;
import model.Invoice;
import model.PONumber;
import service.implementations.ClientService;
import service.implementations.ContactService;
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
    
    private void updateEditClientComboBox() {
        ArrayList<Client> clients = clientService.getAll(false);
        DefaultComboBoxModel clientModel = new DefaultComboBoxModel<>();
        clientModel.addAll(clients);
        frame.clientCombo.setModel(clientModel);
        for (int i = 0; i < clientModel.getSize(); i++) {
            Client c = clients.get(i);
            if (c.getClientName().equals(frame.clientName.getText())) {
                frame.clientCombo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    ContactService contactService = new ContactService();
    private void updateEditContactComboBox() throws SQLException {
        Client client = (Client) frame.clientCombo.getSelectedItem();
        int selectedClientID = client.getClientID();
        ArrayList<FullContactDTO> contacts = contactService.getByClientid(selectedClientID);
        for(FullContactDTO c : contacts)
            System.out.println(c);
        DefaultComboBoxModel contactModel = new DefaultComboBoxModel<>();
        contactModel.addAll(contacts);
        
        frame.contactCombo.setModel(contactModel);
        for (int i = 0; i < contactModel.getSize(); i++) {
            FullContactDTO c = contacts.get(i);
            String name = c.getContact().getContactFirstName()+" "+c.getContact().getContactLastName();
            
            if (name.equals(frame.contactNameLabel.getText())) {
                frame.contactCombo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    private void updateEditPONumberComboBox(FullContactDTO c) {
        //Populate PONumbers for Contact
        DefaultComboBoxModel<String> poModel = new DefaultComboBoxModel<>();
        
     
        
        if(c != null) {
            if(!c.getPoNumbers().isEmpty()) {
                for(PONumber no : c.getPoNumbers()) {
                    poModel.addElement(no.getPONumber());
                    System.out.println("Comparing: "+no+" | "+frame.poNumber.getText());
                    if(no.equals(frame.poNumber.getText())) {
                        frame.PONumberCombo.setSelectedItem(no);
                    } else {
                    }
                }
                frame.PONumberCombo.setModel(poModel);
            } else {
                frame.PONumberCombo.setModel((ComboBoxModel<String>) new DefaultTableModel());//empty
            }
        }
    }
    
    private void updateEditAddressComboBox(FullClientDTO client) {
          
        //Populating Addresses for Client
        DefaultComboBoxModel<String> addModel = new DefaultComboBoxModel<>();
        System.out.println("CLIENT "+client);
        
        for(ClientAddress ca : client.getClientAddresses()) {
            addModel.addElement(ca.getClientPrintAddress());
           
        }
        frame.clientAddressCombo.setModel(addModel);
        frame.clientAddressCombo.setSelectedItem(frame.streetAddress.getText());
    }
    
    private void updateEditInvoiceDetailsTable(FullInvoiceDTO fullInvoice) {
        TableModel details = InvoiceTableModelFactory.getInvoiceDetailTableModel(fullInvoice.getInvoiceItems());
        frame.jTable3.setModel(details);
        frame.jScrollPane3.setSize(new Dimension(587, ((frame.jTable3.getRowCount()*frame.jTable3.getRowHeight())+frame.jTable3.getTableHeader().getHeight())));

        

    } 
    
    int currentRowCount = 0;
    
    public void swapToEditView(int invoiceNo) throws SQLException {
      
        //Get invoice and client info
        Invoice invoice = invoiceService.getListViewInvoiceById(invoiceNo, false);
        FullInvoiceDTO fullInvoice = invoiceService.getFullInvoiceById(invoiceNo, false);
        
        FullClientDTO client = clientService.getById(invoice.getClientID(), false);
        
        int clientId = invoice.getClientID();
        int contactId = invoice.getContactID();
        int poNumberId = invoice.getPoNumberID();
        
        //Setting box information
        frame.editInvoiceNo.setText(frame.invoiceNo.getText());
        frame.editDueDate.setText(frame.invoiceDueDate.getText());
        frame.editDate.setText(frame.invoiceDate.getText());
        
        updateEditClientComboBox();
        
        //Populate Contacts for Client
        updateEditContactComboBox();
        
        //Populate PONumbers for Contact
        updateEditPONumberComboBox(client.getContactByID(contactId));
        
        //Populating Addresses for Client
        updateEditAddressComboBox(client);
        
        //set details table
        updateEditInvoiceDetailsTable(fullInvoice);

        frame.jTextArea1.setText(fullInvoice.getInvoiceFooter().getInvoiceNotes());
        
        frame.editInvoicePanel.revalidate();
        frame.editInvoicePanel.repaint();
        CardLayout layout = (CardLayout) frame.jPanel2.getLayout();
        layout.show(frame.jPanel2, "editInvoice");
        currentRowCount = frame.jTable3.getRowCount();
        
    }
}
