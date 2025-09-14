/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guiapplication;
import GuiComponents.MainFrame;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class GuiApplication {
    public static MainFrame frame;
   // public static String url = "jdbc:sqlite:c:/database/database.db";
     public static String url = "jdbc:sqlite:" + new File("Assets/database.db").getPath();

   
     //Main method of entire project
    public static void main(String[] args) throws SQLException, Exception {
 
        
        //Setting up Frame
    frame = new MainFrame();
    frame.setVisible(true);
    
    //Loading in inital data into table
    frame.jTable1.setModel(GuiApplication.populateTable("Invoices"));
    frame.clientName.setText(GuiApplication.getClient());
    frame.streetAddress.setText(GuiApplication.getClientAddy("StreetAddress"));
    frame.areaAddress.setText(GuiApplication.getClientAddy("AreaAddress"));
    frame.eircode.setText(GuiApplication.getClientAddy("ClientEircode"));
    frame.countyAddress.setText(GuiApplication.getClientAddy("ClientCounty"));
    frame.invoiceNo.setText((String) frame.jTable1.getValueAt(frame.jTable1.getSelectedRow(), 0));
    frame.invoiceDate.setText((String) frame.jTable1.getValueAt(frame.jTable1.getSelectedRow(), 1));
    frame.poNumber.setText(GuiApplication.getPONumber());
    frame.invoiceDueDate.setText((String) frame.jTable1.getValueAt(frame.jTable1.getSelectedRow(), 2));
    frame.contactNameLabel.setText(GuiApplication.getContact());
    frame.jTable2.setModel(frame.searchTable("InvoiceDetails"));
    frame.jTable1.requestFocus();
    }
    
    //SQL code for retrieving client record
 public static String getClient() throws SQLException {
     
    //Getting the index of selected record in table 
    int selectedRow = frame.jTable1.getSelectedRow();
    
    if (selectedRow != -1) { // Check if a row is selected
       // System.out.println("debugging "+frame.jTable1.getValueAt(selectedRow, 8));
       
       //
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        //
        
        //Column 8 holds the clientID value in the table. We retrieve it and use it to search the databse.
        Object clientID = frame.jTable1.getValueAt(selectedRow, 8); 
        ResultSet rs = stmt.executeQuery("SELECT c.ClientName FROM Clients c WHERE c.ClientID =" + clientID);

        String reValue = null;
        if (rs.next()) {
            reValue = rs.getString(1);
        }
        conn.close();
        stmt.close();
        rs.close();
        return reValue;
    } else {
        return null; // No row is selected, return null or handle the case accordingly
    }
}

    
    public static String[] getClients() throws SQLException {

        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT c.ClientName FROM Clients c");
        System.out.println(rs.getString(1));
        ArrayList<String> reValue = new ArrayList<>();
        while(rs.next()) {
            reValue.add(rs.getString(1));
        }
       
       conn.close();
       stmt.close();
       rs.close();
       return(String[]) reValue.toArray(new String[reValue.size()]);
    }
      
    public static String[] getContacts() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT c.ContactFirstName, c.ContactLastName FROM Contacts c INNER JOIN Clients cl ON c.ClientID = cl.ClientID WHERE cl.ClientName = "+"'"+frame.clientCombo.getSelectedItem().toString()+"'");
        
        ArrayList<String> reValue = new ArrayList<>();
        
        while(rs.next()) {
            reValue.add(rs.getString(1)+" "+rs.getString(2));
        }
       
       conn.close();
       stmt.close();
       rs.close();
       return(String[]) reValue.toArray(new String[reValue.size()]);
    }
        public static String[] getAddContacts() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT c.ContactFirstName, c.ContactLastName FROM Contacts c");
        
        ArrayList<String> reValue = new ArrayList<>();
        
        while(rs.next()) {
            reValue.add(rs.getString(1)+" "+rs.getString(2));
        }
       
       conn.close();
       stmt.close();
       rs.close();
       return(String[]) reValue.toArray(new String[reValue.size()]);
    }
    
    public static String[] getPONumbers() throws SQLException {
        String s = "";
        if(frame.contactCombo.getSelectedItem() != null)
            s = (String) frame.contactCombo.getSelectedItem();
        String name ="";
        ArrayList<String> reValue = new ArrayList<>();
        
        for(int i = 0; i< s.length(); i++) {
            
            if(s.charAt(i) == ' ')
                break;
            else
              name += s.charAt(i);
        }
        
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT p.PONumber FROM PONumbers p INNER JOIN Contacts c on c.ContactID = p.ContactID WHERE c.ContactFirstName = "+" '"+name+"'");
        while(rs.next())
            reValue.add(rs.getString(1));
        return reValue.toArray(new String[reValue.size()]);
    }
    
  
    
    public static String getClientAddy(String condition) throws SQLException {
        if(frame.jTable1.getSelectedRow() == -1)
            frame.jTable1.getSelectionModel().setSelectionInterval( 1, 1 );
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT c."+condition+" FROM ClientAddresses c WHERE c.ClientID ="+frame.jTable1.getValueAt(frame.jTable1.getSelectedRow(), 8));
        if(!rs.isClosed()) {
            String reValue = rs.getString(1);
            conn.close();
            stmt.close();
            rs.close();
            return reValue;
        } else {
            return "";
        }
        
    }
    
    public static String getContact() throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT c.ContactFirstName, c.ContactLastName from Contacts c WHERE c.ContactID = "+frame.jTable1.getValueAt(frame.jTable1.getSelectedRow(), 9));
        String reValue = rs.getString(1)+" "+rs.getString(2);
        conn.close();
        stmt.close();
        rs.close();
        return reValue;
    }
    
public static String getPONumber() throws SQLException {
    DriverManager.registerDriver(new org.sqlite.JDBC());
    Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT c.PONumber FROM PONumbers c WHERE c.ContactID =" + frame.jTable1.getValueAt(frame.jTable1.getSelectedRow(), 9));
    
    String reValue = null;
    if (rs != null && !rs.isClosed()) {
        reValue = rs.getString(1);
    }
    
    rs.close();
    stmt.close();
    conn.close();
    
    return reValue;
}
    public static DefaultTableModel populateTable(String table) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        Vector columnNames = new Vector();
        Vector rows = new Vector();
    
      
           
           ResultSet rs = stmt.executeQuery("select * from "+table);
            if (rs != null && !rs.isClosed()) {
                
                ResultSetMetaData  metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                //System.out.println(columnCount);
                for(int i = 0; i < columnCount; i++) {
                    String label = metaData.getColumnLabel(i+1);
                   
                        
                    
                    columnNames.addElement(label);
                    
                    //System.out.println(columnNames.get(i));
                }
                while(rs.next()) {
                    Vector newRow = new Vector();
                    
                    for(int i = 1; i<= columnCount; i++) {
                        newRow.addElement(rs.getString(i));
                    }
                    rows.addElement(newRow);
                }
                
                
                
                

                // ... rest of your code here
            } else {
                throw new RuntimeException("Invalid ResultSet!");
            }
            rs.close();
            stmt.close();
            conn.close();
            return new DefaultTableModel (rows, columnNames);
    }
    
       
    
}
