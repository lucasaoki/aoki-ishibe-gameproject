/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.entity.Hiei;
import game.entity.Ichigo;
import game.entity.Kenshin;
import game.entity.Zoro;
import game.component.controller.P1control;
import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.util.Timer;
import game.util.TimerListener;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class GamePanel extends StatePanel {

    private final Timer timer;

    public GamePanel(GameContainer gc) {
        gc.setMainPanel(this);
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/images/backgrounds/bg_bleach.png"));
        getEntity("Background").setPosition(new Point(0, 0));
        
        entities.add(new Kenshin("Kenshin", gc, new P1control("KenshinCtrl")));
        entities.add(new Hiei("Hiei", gc, new P1control("HieiCtrl")));
        entities.add(new Ichigo("Ichigo", gc, new P1control("IchigoCtrl")));
        entities.add(new Zoro("Zoro", gc, new P1control("ZoroCtrl")));
        
        timer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                for (Entity entity : entities) {
                    entity.update();
                }
            }
        }, 30);

        timer.start();
    }
}
