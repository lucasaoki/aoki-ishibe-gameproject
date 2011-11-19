/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;

/**
 *
 * @author Lucas Aoki
 */
public class PlayerSelectPanel extends StatePanel {

    GameContainer gc;

    public PlayerSelectPanel(GameContainer gc) {
        super(640,300);/////Arrumar
        this.gc = gc;
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BG", "/images/backgrounds/bg4.jpg"));
    }

}
