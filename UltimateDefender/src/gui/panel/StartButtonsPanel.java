/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Seiji
 */
public class StartButtonsPanel extends BasicPanel implements ActionListener {

    JButton start = new JButton();

    public StartButtonsPanel() {
        super(640,400);
        this.setBackground( new Color(255, 255, 255, 0));
        start =  new ButtonConf(start, 200, 200);
        this.add(start);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
