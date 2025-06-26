/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Owen
 */
public class Invoice {
    
    private int invoiceNumber;
    private Date invoiceDate;
    private Date invoiceDueDate;
    private Date invoiceBookingDate;
    private float invoiceSubtotal;
    private boolean invoicePaid;
    private String invoiceNotes;
    private int clientID;
    private int contactID;

    public Invoice() { }

    public Invoice(int invoiceNumber, Date invoiceDate, Date invoiceDueDate, Date invoiceBookingDate, float invoiceSubtotal, boolean invoicePaid, String invoiceNotes, int clientID, int contactID) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceDueDate = invoiceDueDate;
        this.invoiceBookingDate = invoiceBookingDate;
        this.invoiceSubtotal = invoiceSubtotal;
        this.invoicePaid = invoicePaid;
        this.invoiceNotes = invoiceNotes;
        this.clientID = clientID;
        this.contactID = contactID;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public Date getInvoiceBookingDate() {
        return invoiceBookingDate;
    }

    public void setInvoiceBookingDate(Date invoiceBookingDate) {
        this.invoiceBookingDate = invoiceBookingDate;
    }

    public float getInvoiceSubtotal() {
        return invoiceSubtotal;
    }

    public void setInvoiceSubtotal(float invoiceSubtotal) {
        this.invoiceSubtotal = invoiceSubtotal;
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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", invoiceDueDate=" + invoiceDueDate + ", invoiceBookingDate=" + invoiceBookingDate + ", invoiceSubtotal=" + invoiceSubtotal + ", invoicePaid=" + invoicePaid + ", invoiceNotes=" + invoiceNotes + ", clientID=" + clientID + ", contactID=" + contactID + '}';
    }
    
    
    
    
    
    
}
