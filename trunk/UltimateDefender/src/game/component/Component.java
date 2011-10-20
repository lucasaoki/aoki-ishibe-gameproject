/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import game.entity.Entity;

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
}
