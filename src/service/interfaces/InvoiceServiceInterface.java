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
    FullInvoiceDTO getById(int id);
    ArrayList<FullInvoiceDTO> getAll();
    int create(FullInvoiceDTO invoice);     // returns new id
    boolean update(FullInvoiceDTO invoice);
    boolean delete(FullInvoiceDTO invoice);
}
