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

    @Override
    public FullInvoiceDTO getFullInvoiceById(int id, boolean test) {
        if(cache.containsKey(id)) {
            return cache.get(id);
        } else {
            FullInvoiceDTO returnVal = displayInvoiceDAO.getByInvoiceNumber(id, test);
            if(returnVal != null) {
                cache.put(id, returnVal);
                return returnVal;
            } else {
                return null;
            }
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
    public boolean update(FullInvoiceDTO invoice, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(FullInvoiceDTO invoice, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Invoice getListViewInvoiceById(int id, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
