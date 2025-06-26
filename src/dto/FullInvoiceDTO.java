/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


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
    private Client client;
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
    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
        invoice.setClientID(client.getClientID());
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
    
    public void updateInvoiceDetail(InvoiceDetail invoiceDetail) {
        for(int i = 0; i<invoiceDetails.size(); i++) {
            if(invoiceDetails.get(i).getDetailID() != invoiceDetail.getDetailID()) {
                
            } else {
                invoiceDetails.set(i, invoiceDetail);
                return;
            }
        }
    }
}
