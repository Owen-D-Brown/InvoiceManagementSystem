package model;

public class Contact {
    
    private int contactID;
    private int clientID;
    private String contactFirstName;
    private String contactLastName;
    private String contactNumber;//better naming
    private String contactEmail;

    public Contact() { }

    public Contact(int contactID, int clientID, String contactFirstName, String contactLastName, String contactNumber, String contactEmail) {
        this.contactID = contactID;
        this.clientID = clientID;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactID=" + contactID + ", clientID=" + clientID + ", contactFirstName=" + contactFirstName + ", contactLastName=" + contactLastName + ", contactNumber=" + contactNumber + ", contactEmail=" + contactEmail + '}';
    }
    
    
    
}
