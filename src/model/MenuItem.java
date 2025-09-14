/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author owen
 */
public class MenuItem {
    
    private int itemID;
    private String itemName;
    private float itemPrice;
    private float itemWeight;
    private float itemCost;
    
    public MenuItem() { }

    public MenuItem(int itemID, String itemName, float itemPrice, float itemWeight, float itemCost) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemWeight = itemWeight;
        this.itemCost = itemCost;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(float itemWeight) {
        this.itemWeight = itemWeight;
    }

    public float getItemCost() {
        return itemCost;
    }

    public void setItemCost(float itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemWeight=" + itemWeight + ", itemCost=" + itemCost + '}';
    }
    
    
}
