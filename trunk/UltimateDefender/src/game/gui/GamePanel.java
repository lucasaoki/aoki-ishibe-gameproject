/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.characters.Kenshin;
import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.util.Timer;
import game.util.TimerListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class GamePanel extends JPanel implements ActionListener, TimerListener {

    private Entity kenshin;
    private Entity background;
    JButton exitButton = null;

    public GamePanel() {
        exitButton = new JButton("Exit");
        this.setLayout(new BorderLayout());
        this.add(exitButton, BorderLayout.SOUTH);
        exitButton.addActionListener(this);

        background = new Entity("Background");
        background.addComponent(new ImageRenderComponent("BGImage", "/BG.jpg"));
        background.setPosition(new Point(0, 0));
        
        kenshin = new Kenshin("Kenshin", this);
        kenshin.setPosition(new Point(250, 250));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        background.render(g);
        kenshin.render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evtSource = e.getSource();

        if (evtSource == exitButton) {
            System.exit(0);
        }
    }

    @Override
    public void update(Timer timer) {
//        repaint();
    }
}
