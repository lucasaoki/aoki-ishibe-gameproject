/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import game.component.render.ImageRenderComponent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import game.entity.Entity;
import game.gui.GameContainer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener {

    private ArrayList<Entity> entities = null;
    private JButton StartButton = null;
    private JButton ExitButton = null;
    private JButton HighscoreButton = null;
    private JButton Button = null;
    private GameContainer gc = null;

    public MenuPanel(GameContainer gc) {

        this.gc = gc;

        entities = new ArrayList<>();
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/BG.jpg"));
        

        this.setLayout(new BorderLayout());

        BasicPanel PanelNorth = new BasicPanel(640, 225);
        this.add(PanelNorth, BorderLayout.NORTH);

        BasicPanel PanelSouth = new BasicPanel(640, 0);
        BasicPanel PanelWest = new BasicPanel(225, 400);
        BasicPanel PanelEast = new BasicPanel(225, 400);
        BasicPanel PanelCenter = new BasicPanel(50, 100);
        this.add(PanelCenter, BorderLayout.CENTER);

        StartButton = ButtonConf("Start", 180, 85);
        StartButton.setRequestFocusEnabled(false);
        HighscoreButton = ButtonConf("Highscore", 100, 25);
        HighscoreButton.setRequestFocusEnabled(false);
        ExitButton = ButtonConf("Exit", 100, 25);
        ExitButton.setRequestFocusEnabled(false);

        ExitButton.addActionListener(this);
        HighscoreButton.addActionListener(this);
        StartButton.addActionListener(this);

        PanelCenter.add(StartButton);
        PanelCenter.add(HighscoreButton);
        PanelCenter.add(ExitButton);


        this.add(PanelEast, BorderLayout.EAST);
        this.add(PanelWest, BorderLayout.WEST);
        this.add(PanelSouth, BorderLayout.SOUTH);
    }

    private Entity getEntity(String id) {
        for (Entity entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Graphics2D gr2d = (Graphics2D) g;

        for (Entity entity : entities) {
            entity.render(gr2d);
        }
        repaint();
    }

    public JButton ButtonConf(String string, int width, int heigth) {
        Button = new JButton(string);
        Button.setPreferredSize(new Dimension(width, heigth));
        return Button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == StartButton) {
            gc.setGameState(GameContainer.State.GAMESTATE);

        } else if (obj == HighscoreButton) {
        } else if (obj == ExitButton) {
            System.exit(0);
        }
    }
}
