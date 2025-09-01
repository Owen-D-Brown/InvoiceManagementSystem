/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import model.MenuItem;

/**
 *
 * @author Owen
 */
public interface MenuDAOInterface extends BaseDAOInterface {
    MenuItem getByName(String name);
    
}
