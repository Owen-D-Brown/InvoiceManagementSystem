/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementations;

import dao.Implementations.ClientAddressDAO;
import dao.Implementations.ClientDAO;
import dao.Implementations.ContactDAO;
import dto.FullClientDTO;
import java.util.ArrayList;
import model.Client;
import model.ClientAddress;
import model.Contact;
import service.interfaces.ClientServiceInterface;

/**
 *
 * @author owen
 */
public class ClientService implements ClientServiceInterface {

    ClientDAO clientDAO = new ClientDAO();
    ContactDAO contactDAO = new ContactDAO();
    ClientAddressDAO addressDAO = new ClientAddressDAO();
    
    @Override
    public FullClientDTO getById(int id, boolean test) {
        Client client = clientDAO.getById(id);
        ArrayList<Contact> contacts = contactDAO.getByClientId(id);
        ArrayList<ClientAddress> addresses = addressDAO.getByClientId(id);
        return new FullClientDTO(client, contacts, addresses);
    }

    @Override
    public ArrayList<FullClientDTO> getAll(boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int create(FullClientDTO client, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(FullClientDTO client, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(FullClientDTO client, boolean test) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
