/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class MyPanel extends JPanel implements ActionListener {

    JButton exitButton = new JButton("Exit");

    public MyPanel() {
        this.setLayout(new BorderLayout());
        this.add(exitButton, BorderLayout.SOUTH);
        exitButton.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evtSource = e.getSource();

        if (evtSource == exitButton) {
            System.exit(0);
        }
    }
}
