/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementations;

import dao.Implementations.ClientDAO;
import dao.Implementations.ContactDAO;
import dao.Implementations.DisplayInvoiceDAO;
import dao.Implementations.InvoiceDAO;
import dao.Implementations.InvoiceDetailDAO;
import dto.FullInvoiceDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private final Map<Integer, FullInvoiceDTO> cache = new HashMap<>();
    
    InvoiceDAO invoiceDAO = new InvoiceDAO();
    ClientDAO clientDAO = new ClientDAO();
    ContactDAO contactDAO = new ContactDAO();
    InvoiceDetailDAO invoiceDetailsDAO = new InvoiceDetailDAO(); 
    DisplayInvoiceDAO displayInvoiceDAO = new DisplayInvoiceDAO();

    private FullInvoiceDTO checkCache(int invoiceNo) {
         if(cache.containsKey(invoiceNo)) {
            return cache.get(invoiceNo);
        } else {
             return null;
         }
    }
    
    @Override
    public FullInvoiceDTO getFullInvoiceById(int id, boolean test) {
        FullInvoiceDTO invoice = checkCache(id);
        if(invoice !=null) {
            return invoice;
        } else {
            invoice = displayInvoiceDAO.getByInvoiceNumber(id, test);
            cache.put(id, invoice);
            return invoice;
        }
    }

    @Override
    public ArrayList<FullInvoiceDTO> getAll(boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int create(FullInvoiceDTO invoice, boolean test) {
        return 0;
    }

    @Override
    public FullInvoiceDTO update(Invoice invoice,ArrayList<InvoiceDetail> details, boolean test) throws SQLException {
        invoiceDAO.update(invoice, test);
        invoiceDetailsDAO.updateByInvoiceNumber(details, invoice.getInvoiceNumber(), test);
        FullInvoiceDTO updatedInvoice = displayInvoiceDAO.getByInvoiceNumber(invoice.getInvoiceNumber(), test);
        cache.remove(invoice.getInvoiceNumber());
        cache.put(invoice.getInvoiceNumber(), updatedInvoice);
        return updatedInvoice;
    }

    @Override
    public boolean delete(FullInvoiceDTO invoice, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Invoice getListViewInvoiceById(int id, boolean test) {
        return invoiceDAO.getById(id);
    }
   
    
    

}
