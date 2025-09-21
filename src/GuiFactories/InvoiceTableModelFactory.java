/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiFactories;

import dto.FullInvoiceDTO;
import dto.InvoiceItemDTO;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author owen
 */
public class InvoiceTableModelFactory {
    
    private InvoiceTableModelFactory() {}

    public static AbstractTableModel fromDTOs(List<FullInvoiceDTO> data) {
      //  return new InvoiceTableModel(data);
      return null;
    }
    
    public static AbstractTableModel getInvoiceDetailTableModel(List<InvoiceItemDTO> data) {
      //  return new InvoiceTableModel(data);
      
      return new InvoiceDetailTableModel(data);
    }

    private static class InvoiceTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public int getColumnCount() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Object getValueAt(int i, int i1) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        /*
        private final String[] cols = {"#", "Client", "Date", "Due", "Total", "Paid"};
        private final List<FullInvoiceDTO> rows;
        private final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        InvoiceTableModel(List<InvoiceDTO> rows) { this.rows = rows; }

        @Override public int getRowCount() { return rows.size(); }
        @Override public int getColumnCount() { return cols.length; }
        @Override public String getColumnName(int c) { return cols[c]; }
        @Override public Class<?> getColumnClass(int c) {
            return switch (c) { case 0 -> Integer.class; case 5 -> Boolean.class; default -> String.class; };
        }
        @Override public Object getValueAt(int r, int c) {
            var dto = rows.get(r);
            return switch (c) {
                case 0 -> dto.getInvoiceNumber();
                case 1 -> dto.getClientName();
                case 2 -> dto.getInvoiceDate()==null? "" : DF.format(dto.getInvoiceDate());
                case 3 -> dto.getInvoiceDueDate()==null? "" : DF.format(dto.getInvoiceDueDate());
                case 4 -> String.format("€%.2f", dto.getInvoiceTotal());
                case 5 -> dto.isPaid();
                default -> "";
            };
        }

        public InvoiceDTO getRow(int r) { return rows.get(r); }
    }*/
    }
    


public static class InvoiceDetailTableModel extends AbstractTableModel {

    private final String[] cols = {"Name", "Unit Price", "Quantity", "Line Total"};
    private final List<InvoiceItemDTO> rows;

    public InvoiceDetailTableModel(List<InvoiceItemDTO> rows) {
        this.rows = rows;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int c) {
        return cols[c];
    }

    @Override
    public Object getValueAt(int r, int c) {
        InvoiceItemDTO dto = rows.get(r);
        return switch (c) {
            case 0 -> dto.getItemName();
            case 1 -> dto.getUnitPrice();
            case 2 -> dto.getQuantity();
            case 3 -> dto.getLineTotal();
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col != 3;
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {
        InvoiceItemDTO dto = rows.get(row);
        switch (col) {
            case 0 -> dto.setItemName((String) aValue);
            case 1 -> dto.setUnitPrice((float) Double.parseDouble(aValue.toString()));
            case 2 -> dto.setQuantity(Integer.parseInt(aValue.toString()));
        }
        fireTableRowsUpdated(row, row);
    }

    public void addItem(InvoiceItemDTO dto) {
        int idx = rows.size();
        rows.add(dto);
        fireTableRowsInserted(idx, idx);
    }

    public void removeRow(int row) {
        if (row >= 0 && row < rows.size()) {
            rows.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

    public InvoiceItemDTO getRow(int row) {
        return rows.get(row);
    }

    public List<InvoiceItemDTO> getAllRows() {
        return rows;
    }
}

    
}
