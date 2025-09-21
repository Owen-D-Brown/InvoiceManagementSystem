/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementations;

import dao.Implementations.MenuDAO;
import java.util.ArrayList;
import model.MenuItem;

/**
 *
 * @author owen
 */
public class MenuService {
 
    MenuDAO menuDAO = new MenuDAO();
    
    public ArrayList<MenuItem> getAll() {
        return menuDAO.getAll();
    }
    
}
