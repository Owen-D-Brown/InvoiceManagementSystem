/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author owen
 */
public class PONumber {
    
    private int PONumberID;
    private int contactID;
    private String PONumber;
    
    public PONumber() { };

    public PONumber(int PONumberID, int contactID, String PONumber) {
        this.PONumberID = PONumberID;
        this.contactID = contactID;
        this.PONumber = PONumber;
    }

    public int getPONumberID() {
        return PONumberID;
    }

    public void setPONumberID(int PONumberID) {
        this.PONumberID = PONumberID;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getPONumber() {
        return PONumber;
    }

    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
    }

    @Override
    public String toString() {
        return "PONumber{" + "PONumberID=" + PONumberID + ", contactID=" + contactID + ", PONumber=" + PONumber + '}';
    }
    
    
}
