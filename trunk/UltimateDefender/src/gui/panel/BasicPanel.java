/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Seiji
 */
public class BasicPanel extends JPanel{

    public BasicPanel(int width , int height) {
        
    this.setPreferredSize(new Dimension(width,height));
    this.setBackground(new Color(255, 255, 255, 0));
    
    }
    
}
