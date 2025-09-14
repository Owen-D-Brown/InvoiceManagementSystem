/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import dto.FullInvoiceDTO;

/**
 *
 * @author owen
 */
public interface DisplayInvoiceDAOInterface {
       FullInvoiceDTO getByInvoiceNumber(int invoiceNumber, boolean test);
}
