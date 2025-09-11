/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author owen
 */
public class InvoiceFooterDTO {
    private float invoiceSubtotal;
    private float invoiceTotal;
    private boolean invoicePaid;
    private String invoiceNotes;
    
    public InvoiceFooterDTO() { };

    public InvoiceFooterDTO(float invoiceSubtotal, float invoiceTotal, boolean invoicePaid, String invoiceNotes) {
        this.invoiceSubtotal = invoiceSubtotal;
        this.invoiceTotal = invoiceTotal;
        this.invoicePaid = invoicePaid;
        this.invoiceNotes = invoiceNotes;
    }

    public float getInvoiceSubtotal() {
        return invoiceSubtotal;
    }

    public void setInvoiceSubtotal(float invoiceSubtotal) {
        this.invoiceSubtotal = invoiceSubtotal;
    }

    public float getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(float invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public boolean isInvoicePaid() {
        return invoicePaid;
    }

    public void setInvoicePaid(boolean invoicePaid) {
        this.invoicePaid = invoicePaid;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }

    public void setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
    }

    @Override
    public String toString() {
        return "InvoiceFooterDTO{" + "invoiceSubtotal=" + invoiceSubtotal + ", invoiceTotal=" + invoiceTotal + ", invoicePaid=" + invoicePaid + ", invoiceNotes=" + invoiceNotes + '}';
    }
    
    
}
