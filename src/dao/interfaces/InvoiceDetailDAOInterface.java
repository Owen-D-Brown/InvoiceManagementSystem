/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import model.InvoiceDetail;

/**
 *
 * @author Owen
 */
public interface InvoiceDetailDAOInterface {
    InvoiceDetail getByInvoiceNumber(int number);
}
