/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dto.FullInvoiceDTO;
import service.implementations.InvoiceService;

/**
 *
 * @author owen
 */
public class InvoiceController {
    private InvoiceService invoiceService = new InvoiceService();
    public FullInvoiceDTO getDisplayInvoice(int id, boolean test) {
        return invoiceService.getFullInvoiceById(id, test);
    }
    
}
