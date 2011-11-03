/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.characters.CharacterInfo;
import game.component.characters.Kenshin;
import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.util.Timer;
import game.util.TimerListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class GamePanel extends JPanel {

    private ArrayList<Entity> entities = null;
    JButton exitButton = null;
    private final Timer timer;

    public GamePanel(GamePlay gameframe) {

        exitButton = new JButton("Exit");
        entities = new ArrayList<Entity>();

        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/BG.jpg"));
        getEntity("Background").setPosition(new Point(0, 0));

        entities.add(new Kenshin("Kenshin", this));
        gameframe.addKeyListener((CharacterInfo) getEntity("Kenshin").getComponent("KenshinInfo"));

        timer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                for (Entity entity : entities) {
                    entity.update(null);
                }
            }
        }, 50);

        timer.start();
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
}
