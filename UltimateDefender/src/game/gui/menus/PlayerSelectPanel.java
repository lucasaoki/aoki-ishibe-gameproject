/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui.menus;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import game.gui.StatePanel;

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
