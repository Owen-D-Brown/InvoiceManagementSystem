/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import model.Contact;

/**
 *
 * @author Owen
 */
public interface ContactDAOInterface {
    Contact getByClientId(int id);
    Contact getByName(String name);
}
