/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.controller.CreepCtrl;
import game.component.controller.P1control;
import game.entity.Entity;
import game.entity.Hiei;
import game.entity.Ichigo;
import game.entity.Kenshin;
import game.entity.Zoro;
import game.stage.Stage;
import game.util.Timer;
import game.util.TimerListener;

/**
 * Painel principal do jogo
 * @author Lucas
 */
public class GamePanel extends StatePanel {
    
    private Stage stage;
    private final Timer timer;
    
    public GamePanel(GameContainer gc) {
        super(gc);
        gc.getMainFrame().setSize(640, 580);
        gc.setMainPanel(this);
        stage = new Stage("Stage", gc);
        entities.add(stage);
        setPlayer(gc, gc.getChoice());
        gc.resetScore();
        timer = new Timer(new TimerListener() {
            
            @Override
            public void update(Timer timer) {
                for (Entity entity : entities) {
                    entity.update();
                }
            }
        }, 15);
        timer.start();
    }
     /**
     * Inicializa os personagens, de acordo com a escolha do usuário
     * @param gc
     * Container do jogo
     * @param playerChoice 
     * Escolha do jogador
     */
    private void setPlayer(GameContainer gc, int playerChoice) {
        switch (playerChoice) {
            case 0:
                Kenshin kenshin = new Kenshin(gc, new P1control("KenshinCtrl"));
                entities.add(new Hiei(gc, new CreepCtrl("HieiCtrl", kenshin)));
                entities.add(new Ichigo(gc, new CreepCtrl("IchigoCtrl", kenshin)));
                entities.add(new Zoro(gc, new CreepCtrl("ZoroCtrl", kenshin)));
                entities.add(kenshin);
                stage.setMainPlayer(kenshin);
                gc.setPlayerChoice(kenshin);
                break;
            case 1:
                Hiei hiei = new Hiei(gc, new P1control("HieiCtrl"));
                entities.add(new Kenshin(gc, new CreepCtrl("KenshinCtrl", hiei)));
                entities.add(new Ichigo(gc, new CreepCtrl("IchigoCtrl", hiei)));
                entities.add(new Zoro(gc, new CreepCtrl("ZoroCtrl", hiei)));
                entities.add(hiei);
                stage.setMainPlayer(hiei);
                gc.setPlayerChoice(hiei);
                break;
            case 2:
                Ichigo ichigo = new Ichigo(gc, new P1control("IchigoCtrl"));
                entities.add(new Hiei(gc, new CreepCtrl("HieiCtrl", ichigo)));
                entities.add(new Kenshin(gc, new CreepCtrl("KenshinCtrl", ichigo)));
                entities.add(new Zoro(gc, new CreepCtrl("ZoroCtrl", ichigo)));
                entities.add(ichigo);
                stage.setMainPlayer(ichigo);
                gc.setPlayerChoice(ichigo);
                break;
            case 3:
                Zoro zoro = new Zoro(gc, new P1control("ZoroCtrl"));
                entities.add(new Hiei(gc, new CreepCtrl("HieiCtrl", zoro)));
                entities.add(new Ichigo(gc, new CreepCtrl("IchigoCtrl", zoro)));
                entities.add(new Kenshin(gc, new CreepCtrl("KenshinCtrl", zoro)));
                entities.add(zoro);
                stage.setMainPlayer(zoro);
                gc.setPlayerChoice(zoro);
                break;
        }
    }
}
