/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Owen
 */
public class ClientAddress {
    
    private int addressID;
    private int clientID;
    private String streetAddress;
    private String areaAddress;
    private String clientCounty;
    private String clientEircode;
    private String clientPrintAddress;
    
    public ClientAddress() { };

    public ClientAddress(int addressID, int clientID, String streetAddress, String areaAddress, String clientCounty, String clientEircode, String clientPrintAddress) {
        this.addressID = addressID;
        this.clientID = clientID;
        this.streetAddress = streetAddress;
        this.areaAddress = areaAddress;
        this.clientCounty = clientCounty;
        this.clientEircode = clientEircode;
        this.clientPrintAddress = clientPrintAddress;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getClientCounty() {
        return clientCounty;
    }

    public void setClientCounty(String clientCounty) {
        this.clientCounty = clientCounty;
    }

    public String getClientEircode() {
        return clientEircode;
    }

    public void setClientEircode(String clientEircode) {
        this.clientEircode = clientEircode;
    }

    public String getClientPrintAddress() {
        return clientPrintAddress;
    }

    public void setClientPrintAddress(String clientPrintAddress) {
        this.clientPrintAddress = clientPrintAddress;
    }

    @Override
    public String toString() {
        return "ClientAddress{" + "addressID=" + addressID + ", clientID=" + clientID + ", streetAddress=" + streetAddress + ", areaAddress=" + areaAddress + ", clientCounty=" + clientCounty + ", clientEircode=" + clientEircode + ", clientPrintAddress=" + clientPrintAddress + '}';
    }
    
    
}
