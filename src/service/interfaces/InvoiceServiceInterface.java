/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.interfaces;

import dto.FullInvoiceDTO;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public interface InvoiceServiceInterface {
    FullInvoiceDTO getById(int id, boolean test);
    ArrayList<FullInvoiceDTO> getAll(boolean test);
    int create(FullInvoiceDTO invoice, boolean test);     // returns new id
    boolean update(FullInvoiceDTO invoice, boolean test);
    boolean delete(FullInvoiceDTO invoice, boolean test);
}
