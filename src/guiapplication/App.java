/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guiapplication;

import dao.Implementations.ClientAddressDAO;
import dao.Implementations.ClientDAO;
import dao.Implementations.ContactDAO;
import dao.Implementations.InvoiceDAO;
import java.util.ArrayList;
import model.*;

public class App {
    public static void main(String[] args) {
        InvoiceDAO invoiceDAO = new InvoiceDAO();

        int invoiceNumberToTest = 1;  // Replace with an actual InvoiceNumber from your DB

        Invoice invoice = invoiceDAO.getById(invoiceNumberToTest);

        if (invoice != null) {
            System.out.println("✅ Invoice found:");
            System.out.println(invoice);  // uses your toString()
        } else {
            System.out.println("❌ No invoice found with number " + invoiceNumberToTest);
        }
    }   
}


