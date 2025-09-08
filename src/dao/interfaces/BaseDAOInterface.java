/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Owen
 */
public interface BaseDAOInterface<T> {
    
    T getById(int id);
    List<T> getAll();
    boolean insert(T obj, boolean test) throws SQLException;
    boolean update(T obj, boolean test) throws SQLException;
    boolean delete(T obj, boolean test) throws SQLException;
}
