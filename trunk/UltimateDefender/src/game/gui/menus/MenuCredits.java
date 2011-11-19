/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui.menus;

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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Seiji
 */
public class MenuCredits extends JPanel implements MouseListener, ActionListener {

    private JButton back = null;
    private JButton button = null;
    private BasicPanel creditPanel = null;
    private BasicPanel panelWest = null;
    private BasicPanel panelEast = null;
    private BasicPanel panelSouth = null;
    private ArrayList<Entity> entities = null;
    private GameContainer gc = null;

    public MenuCredits(GameContainer gc) {
        this.gc = gc;

        this.entities = new ArrayList<>();
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/BG4.jpg"));

        creditPanel = new BasicPanel(640, 280);

        back = ButtonConf("back", 100, 50);
        back.addActionListener(this);

        panelWest = new BasicPanel(200, 200);
        panelEast = new BasicPanel(200, 200);
        panelSouth = new BasicPanel(640, 100);

        panelSouth.add(back);

        this.setLayout(new BorderLayout());

        this.add(panelSouth, BorderLayout.SOUTH);


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
            gc.setGameState(GameContainer.State.MENUSTATE);
        }

    }

    public JButton ButtonConf(String string, int width, int heigth) {
        button = new JButton(string);
        button.setPreferredSize(new Dimension(width, heigth));
        return button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
