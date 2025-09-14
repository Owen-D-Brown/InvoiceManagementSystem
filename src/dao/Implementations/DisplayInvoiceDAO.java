/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Implementations;

import dao.interfaces.DisplayInvoiceDAOInterface;
import dto.FullInvoiceDTO;
import dto.InvoiceFooterDTO;
import dto.InvoiceHeaderDTO;
import dto.InvoiceItemDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Invoice;
import util.DatabasePipeline;

/**
 *
 * @author owen
 * This class is for the display render of the invoice, unlike the InvoiceDAO which interacts with the invoice table only. 
 * This aggregates information from various tables to display a complete invoice to the use.
 */
public class DisplayInvoiceDAO implements DisplayInvoiceDAOInterface {
    
    private static final SimpleDateFormat DB_FMT = new SimpleDateFormat("dd/MM/yyyy");

    private String SQLStatement = """
                                  SELECT
                                  
                                    i.InvoiceNumber        AS invoice_number,
                                    i.InvoiceDate          AS invoice_date,
                                    i.InvoiceDueDate       AS invoice_due_date,
                                    i.InvoiceBookingDate   AS invoice_booking_date,
                                    i.InvoicePaid          AS invoice_paid,
                                    i.InvoiceNotes         AS invoice_notes,
                                  
                                    c.ClientName           AS client_name,
                                    co.ContactFirstName         AS contact_Fname,
                                    co.ContactLastName AS contact_LName,
                                  
                                    ca.ClientPrintAddress  AS address,
                                  
                                    pn.PONumber            AS po_number,
                                  
                                    d.DetailID             AS detail_id,
                                    d.ItemID               AS item_id,
                                    d.ItemQuantity         AS quantity,
                                    m.ItemName             AS item_name,
                                    m.ItemPrice            AS unit_price
                                  
                                  FROM Invoices i
                                  JOIN Clients c              ON i.ClientID      = c.ClientID
                                  LEFT JOIN Contacts co       ON i.ContactID     = co.ContactID
                                  LEFT JOIN ClientAddresses ca ON i.AddressID    = ca.AddressID
                                  LEFT JOIN PONumbers pn      ON i.PONumberID    = pn.PONumberID
                                  JOIN InvoiceDetails d       ON i.InvoiceNumber = d.InvoiceNumber
                                  JOIN Menu m                 ON d.ItemID        = m.ItemID
                                  WHERE i.InvoiceNumber = ?
                                  ORDER BY d.DetailID;""";
    
    @Override
    public FullInvoiceDTO getByInvoiceNumber(int invoiceNumber, boolean test) {
        try (
            java.sql.Connection conn = test 
            ? DatabasePipeline.openTestConnection()
            : DatabasePipeline.openConnection();
            PreparedStatement stmt = conn.prepareStatement(SQLStatement);
        ) 
        {
                
            
         
        
            stmt.setInt(1, invoiceNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) return null; // not found

                // ----- Header (first row only) -----
                FullInvoiceDTO dto = new FullInvoiceDTO();
                InvoiceHeaderDTO headerDto = new InvoiceHeaderDTO();
                InvoiceFooterDTO footerDto = new InvoiceFooterDTO();
                headerDto.setInvoiceNumber(rs.getInt("invoice_number"));
                headerDto.setInvoiceDate(parseDate(rs.getString("invoice_date")));
                headerDto.setInvoiceDueDate(parseDate(rs.getString("invoice_due_date")));
                headerDto.setInvoiceBookingDate(parseDate(rs.getString("invoice_booking_date")));
                footerDto.setInvoicePaid(rs.getBoolean("invoice_paid"));
                footerDto.setInvoiceNotes(rs.getString("invoice_notes"));
                headerDto.setClientName(rs.getString("client_name"));

                // Contact name = first + " " + last (you said these are never null)
                String first = rs.getString("contact_Fname");
                String last  = rs.getString("contact_Lname");
                headerDto.setContactName(first + " " + last);

                headerDto.setAddress(rs.getString("address"));
                headerDto.setPoNumber(getStringOrZero(rs,"po_number"));

                // ----- Lines (include the current row) -----
                ArrayList<InvoiceItemDTO> lines = new ArrayList<>();
                float subtotal = 0f;

                do {
                    lines.add(mapLine(rs));
                    subtotal += lines.get(lines.size() - 1).getLineTotal();
                } while (rs.next());

                dto.setInvoiceItems(lines);
                dto.setInvoiceFooter(footerDto);
                dto.setInvoiceHeader(headerDto);
                footerDto.setInvoiceSubtotal(subtotal);
                footerDto.setInvoiceTotal(subtotal); // adjust later if VAT/discounts apply

                return dto;
        }   
        catch (SQLException ex) {
            System.getLogger(InvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
            return null;
        } catch (SQLException ex) { 
            System.getLogger(DisplayInvoiceDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
    
      private InvoiceItemDTO mapLine(ResultSet rs) throws SQLException {
        int qty = rs.getInt("quantity");
        float unit = (float) rs.getDouble("unit_price"); // SQLite returns double; cast to float for your DTO
        float lineTotal = unit * qty;

        InvoiceItemDTO line = new InvoiceItemDTO();
        line.setDetailId(rs.getInt("detail_id"));
        line.setItemId(rs.getInt("item_id"));
        line.setItemName(rs.getString("item_name"));
        line.setUnitPrice(unit);
        line.setQuantity(qty);
        line.setLineTotal(lineTotal); // calculated in app
        return line;
    }

    private Date parseDate(String s) {
        if (s == null || s.isEmpty()) return null;
        try { return DB_FMT.parse(s); } catch (Exception e) { return null; }
    }
    
       private String getStringOrZero(ResultSet rs, String col) throws SQLException {
    Object o = rs.getObject(col);
    return (o == null) ? "0" : o.toString();
}

    }
    
