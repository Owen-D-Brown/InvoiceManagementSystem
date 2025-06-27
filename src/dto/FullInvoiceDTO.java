/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Client;
import model.Contact;
import model.Invoice;
import model.InvoiceDetail;
import model.PONumber;

/**
 *
 * @author Owen
 */
public class FullInvoiceDTO {
    
    private Invoice invoice;
    private FullClientDTO client;
    private Contact contact;
    private List<InvoiceDetail> invoiceDetails;
    //private PONumber poNumber;

    //Invoice Number
    public int getInvoiceNumber() {
        return invoice.getInvoiceNumber();
    }

    //Invoice Date
    public Date getInvoiceDate() {
        return invoice.getInvoiceDate();
    }

    public void setInvoiceDate(Date invoiceDate) {
        invoice.setInvoiceDate(invoiceDate);
    }

    //Invoice Due Date
    public Date getInvoiceDueDate() {
        return invoice.getInvoiceDueDate();
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        invoice.setInvoiceDueDate(invoiceDueDate);
    }

    //Invoice Booking Date
    public Date getInvoiceBookingDate() {
        return invoice.getInvoiceBookingDate();
    }

    public void setInvoiceBookingDate(Date invoiceBookingDate) {
        invoice.setInvoiceBookingDate(invoiceBookingDate);
    }

    //Invoice Subtotal
    public float getInvoiceSubtotal() {
        return invoice.getInvoiceSubtotal();
    }

    public void setInvoiceSubtotal(float invoiceSubtotal) {
        invoice.setInvoiceSubtotal(invoiceSubtotal);
    }

    //Is Invoice Paid
    public boolean isInvoicePaid() {
        return invoice.isInvoicePaid();
    }

    public void setInvoicePaid(boolean invoicePaid) {
        invoice.setInvoicePaid(invoicePaid);
    }

    //Invoice Notes
    public String getInvoiceNotes() {
        return invoice.getInvoiceNotes();
    }

    public void setInvoiceNotes(String invoiceNotes) {
        invoice.setInvoiceNotes(invoiceNotes);
    }

    //Client
    public FullClientDTO getClient() {
        return this.client;
    }

    public void setClient(FullClientDTO client) {
        this.client = client;
        invoice.setClientID(client.getClient().getClientID());
    }

    //Contact
    public Contact getContact() {
        return this.contact;
    }

    //There must be a rule here that does not allow contacts that don't belong to the client to be added to invoices
    public void setContact(Contact contact) {
        this.contact = contact;
        invoice.setContactID(contact.getContactID());
    }
    
    public void updateInvoiceDetail(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
    
    public List<InvoiceDetail> getInvoiceDetails() {
        return this.invoiceDetails;
    }

    @Override
    public String toString() {
        return "FullInvoiceDTO{" + "invoice=" + invoice + ", client=" + client + ", contact=" + contact + ", invoiceDetails=" + invoiceDetails + '}';
    }
 
    
}
