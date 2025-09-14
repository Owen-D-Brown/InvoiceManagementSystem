/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Owen
 */
public class Client {
    
    private int clientID;
    private String clientName;
    private String clientEmail;
    private String clientNumber;
    private String clientWebsite;
    
    public Client() { };

    public Client(int clientID, String clientName, String clientEmail, String clientNumber, String clientWebsite) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientNumber = clientNumber;
        this.clientWebsite = clientWebsite;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientWebsite() {
        return clientWebsite;
    }

    public void setClientWebsite(String clientWebsite) {
        this.clientWebsite = clientWebsite;
    }

    @Override
    public String toString() {
        return "Client{" + "clientID=" + clientID + ", clientName=" + clientName + ", clientEmail=" + clientEmail + ", clientNumber=" + clientNumber + ", clientWebsite=" + clientWebsite + '}';
    }
    
    
}
