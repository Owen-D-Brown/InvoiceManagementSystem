/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import java.util.List;

/**
 *
 * @author Owen
 */
public interface BaseDAOInterface {
    
    Object getById(int id);
    List<Object> getAll();
    boolean insert(Object t);
    boolean update(Object t);
    boolean delete(int id);
}
