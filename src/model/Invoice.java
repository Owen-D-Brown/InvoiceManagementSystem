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
    private float invoiceTotal;
    private boolean invoicePaid;
    private String invoiceNotes;
    private int clientID;
    private int contactID;
    private int poNumberID;

    public Invoice() { }

    public Invoice(int invoiceNumber, Date invoiceDate, Date invoiceDueDate, Date invoiceBookingDate, float invoiceSubtotal, float invoiceTotal, boolean invoicePaid, String invoiceNotes, int clientID, int contactID, int poNumberID) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceDueDate = invoiceDueDate;
        this.invoiceBookingDate = invoiceBookingDate;
        this.invoiceSubtotal = invoiceSubtotal;
        this.invoiceTotal = invoiceTotal;
        this.invoicePaid = invoicePaid;
        this.invoiceNotes = invoiceNotes;
        this.clientID = clientID;
        this.contactID = contactID;
        this.poNumberID = poNumberID;
    }

    public int getPoNumberID() {
        return poNumberID;
    }

    public void setPoNumberID(int poNumberID) {
        this.poNumberID = poNumberID;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }
    
    public void setInvoiceNumber(int no) {
        this.invoiceNumber = no;
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
    
    public float getInvoiceTotal() {
        return this.invoiceTotal;
    }
    
    public void setInvoiceTotal(float total) {
        this.invoiceTotal = total;
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
        return "Invoice{" + "invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate +  ", PONumberID=" + poNumberID + ", invoiceDueDate=" + invoiceDueDate + ", invoiceBookingDate=" + invoiceBookingDate + ", invoiceSubtotal=" + invoiceSubtotal + ", invoiceTotal=" + invoiceTotal + ", invoicePaid=" + invoicePaid + ", invoiceNotes=" + invoiceNotes + ", clientID=" + clientID + ", contactID=" + contactID + '}';
    }
    
    
    
    
    
    
}
