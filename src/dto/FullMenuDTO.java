/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;
import model.MenuItem;

/**
 *
 * @author Owen
 */
public class FullMenuDTO {
    
    private List<MenuItem> menu;
    
    public FullMenuDTO() { };

    public FullMenuDTO(List<MenuItem> menu) {
        this.menu = menu;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "FullMenuDTO{" + "menu=" + menu + '}';
    }
    
    
}
