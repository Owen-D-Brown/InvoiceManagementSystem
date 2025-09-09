/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementations;

import dao.Implementations.ClientDAO;
import dao.Implementations.ContactDAO;
import dao.Implementations.InvoiceDAO;
import dao.Implementations.InvoiceDetailDAO;
import dto.FullInvoiceDTO;
import java.util.ArrayList;
import model.Client;
import model.Contact;
import model.Invoice;
import model.InvoiceDetail;
import service.interfaces.InvoiceServiceInterface;

/**
 *
 * @author owen
 */
public class InvoiceService implements InvoiceServiceInterface {

    
    InvoiceDAO invoiceDAO = new InvoiceDAO();
    ClientDAO clientDAO = new ClientDAO();
    ContactDAO contactDAO = new ContactDAO();
    InvoiceDetailDAO invoiceDetailsDAO = new InvoiceDetailDAO(); 
    
    
    @Override
    public FullInvoiceDTO getById(int id) {
        
    //get the invoice
    Invoice invoice = invoiceDAO.getById(id);
    
    //get the client
    Client client = clientDAO.getById(invoice.getClientID());
    
    //get the contact
    Contact contact = contactDAO.getById(invoice.getContactID());
    
    //get invoice details
    ArrayList<InvoiceDetail> invoiceDetails = invoiceDetailsDAO.getByInvoiceNumber(invoice.getInvoiceNumber());
    
    return new FullInvoiceDTO(invoice, client, contact, invoiceDetails);
    }

    @Override
    public ArrayList<FullInvoiceDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int create(FullInvoiceDTO invoice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(FullInvoiceDTO invoice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(FullInvoiceDTO invoice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
