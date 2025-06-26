/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author student
 */
public class CircleButton extends JButton {
    BufferedImage image;
    Color color;
    public CircleButton(String label, Color color) {
        super(label);
        this.color = color;
        setContentAreaFilled(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(Color.white);
        }
        try {
            image = ImageIO.read(new File("src/Assets/document.png")); // Load custom image
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(0, 0, getSize().width - 1, getSize().height - 1));
       
         // Draw custom image on the button
        if (image != null) {
            int x = (getWidth() - image.getWidth()) / 2;
            int y = (getHeight() - image.getHeight()) / 2;
            g.drawImage(image, x, y, this);
        }
        super.paintComponent(g);
        
  }
    protected void paintExtra(Graphics g) {
        Graphics2D g3 = (Graphics2D) g;
        if (getModel().isArmed()) {
        g3.setColor(Color.blue);
        } else {
            g3.setColor(this.color);
        }
        g3.fill(new Ellipse2D.Double(40, 0, getSize().width - 40, getSize().height - 40));
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        //g.setColor(getForeground());
        //g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
        paintExtra(g);
    }
       
    @Override
    public boolean contains(int x, int y) {
        Shape shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        return shape.contains(x, y);
    }
}
