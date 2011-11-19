/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Seiji
 */
public class MenuHighscore extends JPanel implements ActionListener {

    private JButton back = null;
    private JButton button = null;
    private HighScorePanel highScorePanel = null;
    private BasicPanel panelNorth = null;
    private BasicPanel panelWest = null;
    private BasicPanel panelEast = null;
    private BasicPanel panelSouth = null;
    private ArrayList<Entity> entities = null;
    private GameContainer gc = null;

    public MenuHighscore(GameContainer gc) throws FileNotFoundException, IOException {
        //Make sure we have nice window decorations.
        this.gc = gc;

        this.entities = new ArrayList<>();
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/Scroll2.jpg"));

        highScorePanel = new HighScorePanel(200,200);

        back = ButtonConf("back", 100, 50);
        panelNorth =new BasicPanel(640,100);
        panelWest = new BasicPanel(200, 100);
        panelEast = new BasicPanel(0, 100);
        panelSouth = new BasicPanel(640, 100);

        panelSouth.add(back);
        back.addActionListener(this);
        
        this.setLayout(new BorderLayout());
        this.add(highScorePanel, BorderLayout.CENTER);
        this.add(panelNorth,BorderLayout.NORTH);
        this.add(panelWest, BorderLayout.WEST);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panelSouth, BorderLayout.SOUTH);

        JFrame.setDefaultLookAndFeelDecorated(true);

    }

    private Entity getEntity(String id) {
        for (Entity entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Graphics2D gr2d = (Graphics2D) g;

        for (Entity entity : entities) {
            entity.render(gr2d);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == back) {
            try {
                gc.setGameState(GameContainer.State.MENUSTATE);
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        }

    }

    public JButton ButtonConf(String string, int width, int heigth) {
        button = new JButton(string);
        button.setPreferredSize(new Dimension(width, heigth));
        return button;
    }
}
