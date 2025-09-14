/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author owen
 */
public class InvoiceItemDTO {
    
    private int detailId;
    private int itemId;
    private String itemName;
    private float unitPrice;
    private int quantity;
    private float lineTotal;
    
    public InvoiceItemDTO() { };

    public InvoiceItemDTO(int detailId, int itemId, String itemName, float unitPrice, int quantity, float lineTotal) {
        this.detailId = detailId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(float lineTotal) {
        this.lineTotal = lineTotal;
    }

    @Override
    public String toString() {
        return "InvoiceItemDTO{" + "detailId=" + detailId + ", itemId=" + itemId + ", itemName=" + itemName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", lineTotal=" + lineTotal + '}';
    }
    
    
}
