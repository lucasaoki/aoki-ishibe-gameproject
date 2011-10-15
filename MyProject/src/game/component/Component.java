/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import game.entity.Entity;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Aoki
 */
public abstract class Component {

    protected String id;
    protected Entity owner;

    public String getID() {
        return id;
    }

    public void setOwnerEntity(Entity owner) {
        this.owner = owner;
    }

    public abstract void update(GameContainer gc, StateBasedGame sb, int delta);
}
