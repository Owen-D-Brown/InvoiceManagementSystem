/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;
import model.Client;
import model.ClientAddress;
import model.Contact;

/**
 *
 * @author Owen
 */
public class FullClientDTO {
    
    private Client client;
    private List<Contact> contacts;
    private List<ClientAddress> clientAddresses;
    
    public FullClientDTO() { };

    public FullClientDTO(Client client, List<Contact> contacts, List<ClientAddress> clientAddresses) {
        this.client = client;
        this.contacts = contacts;
        this.clientAddresses = clientAddresses;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<ClientAddress> getClientAddresses() {
        return clientAddresses;
    }

    public void setClientAddresses(List<ClientAddress> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    @Override
    public String toString() {
        return "FullClientDTO{" + "client=" + client + ", contacts=" + contacts + ", clientAddresses=" + clientAddresses + '}';
    }
    
}
