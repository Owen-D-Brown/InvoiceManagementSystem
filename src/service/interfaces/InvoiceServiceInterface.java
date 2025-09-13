/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.interfaces;

import dto.FullInvoiceDTO;
import java.util.ArrayList;
import model.Invoice;
import java.sql.SQLException;
import model.InvoiceDetail;

/**
 *
 * @author owen
 */
public interface InvoiceServiceInterface {
    FullInvoiceDTO getFullInvoiceById(int id, boolean test);
    Invoice getListViewInvoiceById(int id, boolean test);
    
    ArrayList<FullInvoiceDTO> getAll(boolean test);
    int create(FullInvoiceDTO invoice, boolean test);     // returns new id
    FullInvoiceDTO update(Invoice invoice,ArrayList<InvoiceDetail> details, boolean test) throws SQLException;
    boolean delete(FullInvoiceDTO invoice, boolean test);
    
}
