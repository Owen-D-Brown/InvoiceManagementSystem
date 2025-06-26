/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author owen
 */
public class InvoiceDetail {
    
    private int detailID;
    private int invoiceNumber;
    private int itemID;
    private int itemQuantity;
    
    public InvoiceDetail() { }

    public InvoiceDetail(int detailID, int invoiceNumber, int itemID, int itemQuantity) {
        this.detailID = detailID;
        this.invoiceNumber = invoiceNumber;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" + "detailID=" + detailID + ", invoiceNumber=" + invoiceNumber + ", itemID=" + itemID + ", itemQuantity=" + itemQuantity + '}';
    }
    
    
    
}
