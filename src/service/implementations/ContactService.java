/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implementations;

import dao.Implementations.ContactDAO;
import dto.FullContactDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author owen
 */
public class ContactService {
    ContactDAO dao = new ContactDAO();
    
    public ArrayList<FullContactDTO> getByClientid(int id) throws SQLException {
        return dao.getFullContactDTOsForClient(id, false);
    }
}