/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author owen
 */
public class InvoiceHeaderDTO {
    private int invoiceNumber;
    private Date invoiceDate;
    private Date invoiceDueDate;
    private Date invoiceBookingDate;  
    private String contactName;
    private String clientName;
    private String poNumber;
    private String address;

    public InvoiceHeaderDTO() {
    }

    public InvoiceHeaderDTO(int invoiceNumber, Date invoiceDate, Date invoiceDueDate, Date invoiceBookingDate, String contactName, String clientName, String poNumber, String address) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceDueDate = invoiceDueDate;
        this.invoiceBookingDate = invoiceBookingDate;
        this.contactName = contactName;
        this.clientName = clientName;
        this.poNumber = poNumber;
        this.address = address;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "InvoiceHeaderDTO{" + "invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", invoiceDueDate=" + invoiceDueDate + ", invoiceBookingDate=" + invoiceBookingDate + ", contactName=" + contactName + ", clientName=" + clientName + ", poNumber=" + poNumber + ", address=" + address + '}';
    }
    
}
