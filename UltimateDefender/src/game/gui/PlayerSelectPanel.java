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
        this.gc = gc;
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BG", "/images/backgrounds/bg2.jpg"));
    }

}
