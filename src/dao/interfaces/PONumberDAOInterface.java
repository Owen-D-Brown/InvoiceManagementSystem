/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import java.util.List;
import model.PONumber;

/**
 *
 * @author Owen
 */
public interface PONumberDAOInterface extends BaseDAOInterface<PONumber> {
    List<PONumber> getByContactId(int id);
    
}
