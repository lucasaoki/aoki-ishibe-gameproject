/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Component;
import game.component.movement.playerMoviment;
import game.entity.Entity;

/**
 *
 * @author Lucas
 */
public class Kenshin extends Entity{

    public Kenshin(String id) {
        super(id);
        this.addComponent(new playerMoviment());
    }
}
