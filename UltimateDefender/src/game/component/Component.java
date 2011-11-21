/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import game.entity.Entity;

/**
 * Componentes que uma determinada entidade carrega.
 * @author Lucas Aoki
 */
public abstract class Component {
    /*id da componente*/
    protected String id;
    /*Entidade pai*/
    protected Entity owner;

    public String getID() {
        return id;
    }

    public void setOwnerEntity(Entity owner) {
        this.owner = owner;
    }

    public abstract void update();
}
