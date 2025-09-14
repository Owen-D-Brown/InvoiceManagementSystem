/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import model.Client;

/**
 *
 * @author Owen
 */
public interface ClientDAOInterface extends BaseDAOInterface<Client> {
    Client getByName(String name);
    Client getByNumber(int number);
}
