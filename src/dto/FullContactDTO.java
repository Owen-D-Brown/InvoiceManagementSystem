/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import model.Contact;
import model.PONumber;

/**
 *
 * @author owen
 */
public class FullContactDTO {
    private Contact contact;
    private ArrayList<PONumber> poNumbers;

    public FullContactDTO() {
    }

    public FullContactDTO(Contact contact, ArrayList<PONumber> poNumbers) {
        this.contact = contact;
        this.poNumbers = poNumbers;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ArrayList<PONumber> getPoNumbers() {
        return poNumbers;
    }

    public void setPoNumbers(ArrayList<PONumber> poNumbers) {
        this.poNumbers = poNumbers;
    }

    @Override
    public String toString() {
        return this.contact.getContactFirstName()+" "+this.getContact().getContactLastName();
    }
    
}
