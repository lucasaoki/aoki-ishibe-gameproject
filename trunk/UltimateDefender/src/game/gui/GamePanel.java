/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.controller.CreepCtrl;
import game.component.controller.P1control;
import game.entity.Entity;
import game.entity.Kenshin;
import game.entity.Zoro;
import game.stages.Stage;
import game.util.Timer;
import game.util.TimerListener;

/**
 *
 * @author Lucas
 */
public class GamePanel extends StatePanel {

    private final Timer timer;

    public GamePanel(GameContainer gc) {
        super(640, 380);
        gc.setMainPanel(this);
        entities.add(new Stage("Background", gc));

        Kenshin kenshin = new Kenshin(gc, new P1control("KenshinCtrl"));
        entities.add(kenshin);
        Zoro zoro = new Zoro(gc, new CreepCtrl("ZoroCtrl", kenshin));
        entities.add(zoro);

        timer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                for (Entity entity : entities) {
                    entity.update();
                }
            }
        }, 50);

        timer.start();
    }
}
