/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Seiji
 */
public class ButtonsPanel extends JPanel {

    JButton credits = null;
    JButton exit = null;

    public ButtonsPanel() {


        this.setBackground(new Color(255, 255, 255, 0));
        this.setPreferredSize(new Dimension(640, 80));

        exit = new JButton("Exit");
        credits = new JButton("Credits");
        
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        credits.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                } catch (Throwable ex) {
                    Logger.getLogger(ButtonsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        

        this.add(credits);
        this.add(exit);

    }
}
