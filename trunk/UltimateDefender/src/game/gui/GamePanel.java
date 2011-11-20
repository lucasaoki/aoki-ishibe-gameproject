/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.controller.P1control;
import game.entity.Entity;
import game.entity.Hiei;
import game.entity.Ichigo;
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

    public GamePanel(GameContainer gc, int playerChoice) {
        super(640, 480);
        gc.getMainFrame().setSize(640, 580);
        gc.setMainPanel(this);
        entities.add(new Stage("Stage", gc));

        setPlayer(gc, playerChoice);

        timer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                for (Entity entity : entities) {
                    entity.update();
                }
            }
        }, 40);

        timer.start();
    }
    
    private void setPlayer(GameContainer gc, int playerChoice){
        switch (playerChoice) {
            case 0:
                Kenshin kenshin = new Kenshin(gc, new P1control("KenshinCtrl"));
                entities.add(kenshin);
                break;
            case 1:
                Hiei hiei = new Hiei(gc, new P1control("HieiCtrl"));
                entities.add(hiei);
                break;
            case 2:
                Ichigo ichigo = new Ichigo(gc, new P1control("IchigoCtrl"));
                entities.add(ichigo);
                break;
            case 3:
                Zoro zoro = new Zoro(gc, new P1control("ZoroCtrl"));
                entities.add(zoro);
                break;
        }
    }
}
