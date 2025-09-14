/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


import java.util.ArrayList;


/**
 *
 * @author Owen
 */
public class FullInvoiceDTO {
    
    private InvoiceHeaderDTO invoiceHeader;
    private ArrayList<InvoiceItemDTO> invoiceItems;
    private InvoiceFooterDTO invoiceFooter;

    public FullInvoiceDTO() {
    }

    public FullInvoiceDTO(InvoiceHeaderDTO invoiceHeader, ArrayList<InvoiceItemDTO> invoiceItems, InvoiceFooterDTO invoiceFooter) {
        this.invoiceHeader = invoiceHeader;
        this.invoiceItems = invoiceItems;
        this.invoiceFooter = invoiceFooter;
    }

    public InvoiceHeaderDTO getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvoiceHeaderDTO invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public ArrayList<InvoiceItemDTO> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(ArrayList<InvoiceItemDTO> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public InvoiceFooterDTO getInvoiceFooter() {
        return invoiceFooter;
    }

    public void setInvoiceFooter(InvoiceFooterDTO invoiceFooter) {
        this.invoiceFooter = invoiceFooter;
    }

    @Override
    public String toString() {
        return "FullInvoiceDTO{" + "invoiceHeader=" + invoiceHeader + ", invoiceItems=" + invoiceItems + ", invoiceFooter=" + invoiceFooter + '}';
    }
    
 
    
}
