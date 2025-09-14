/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiComponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author student
 */
public class InvoicesTableHeader extends JTableHeader {
    
    public InvoicesTableHeader(TableColumnModel model) {
        super(model);
        setPreferredSize(new Dimension(200, 30));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Add custom rendering logic for image and buttons
        // Draw image
      //  Image img = Toolkit.getDefaultToolkit().getImage("path_to_image.jpg");
        //g.drawImage(img, 10, 10, this);
        
        // Draw buttons
        //JButton button1 = new JButton("Button 1");
        //button1.setBounds(0, 0, 100, 30);
       // add(button1);
        
       // JButton button2 = new JButton("Button 2");
       // button2.setBounds(100, 0, 100, 30);
       // add(button2);
    }
    
}
