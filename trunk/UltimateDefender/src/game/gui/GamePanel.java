/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.characters.Hiei;
import game.component.characters.Ichigo;
import game.component.characters.Kenshin;
import game.component.characters.Zoro;
import game.component.controller.P1control;
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

    public GamePanel(GameContainer gc) {

        exitButton = new JButton("Exit");
        entities = new ArrayList<>();

        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/BG.jpg"));
        getEntity("Background").setPosition(new Point(0, 0));

        entities.add(new Kenshin("Kenshin", gc, new P1control("KenshinCtrl")));
        entities.add(new Hiei("Hiei", gc, new P1control("HieiCtrl")));
        entities.add(new Ichigo("Ichigo", gc, new P1control("IchigoCtrl")));
        entities.add(new Zoro("Zoro", gc, new P1control("ZoroCtrl")));

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
