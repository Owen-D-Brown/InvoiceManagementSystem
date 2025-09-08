/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.ArrayList;
import model.Invoice;
import model.InvoiceDetail;
import java.sql.SQLException;

/**
 *
 * @author Owen
 */
public interface InvoiceDetailDAOInterface extends BaseDAOInterface<InvoiceDetail> {
    ArrayList<InvoiceDetail> getByInvoiceNumber(int number);
    
    boolean deleteByInvoiceNumber(Invoice t, boolean test) throws SQLException;
}
