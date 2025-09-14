/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.interfaces;

import dto.FullClientDTO;
import dto.FullInvoiceDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public interface ClientServiceInterface {
    FullClientDTO getById(int id, boolean test) throws SQLException;
    ArrayList<FullClientDTO> getAll(boolean test);
    int create(FullClientDTO client, boolean test);     // returns new id
    boolean update(FullClientDTO client, boolean test);
    boolean delete(FullClientDTO client, boolean test); 
}
