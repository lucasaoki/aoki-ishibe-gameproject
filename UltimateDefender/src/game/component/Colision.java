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
public interface Colision {
    
    public boolean colision();
    public void colisionAction(Entity entity);
}
