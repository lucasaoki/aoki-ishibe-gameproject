/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.controller;

import game.entity.Entity;

/**
 *
 * @author Seiji
 */
public class CreepCtrl extends PlayerCtrl {

    Entity entities = null;

    public CreepCtrl(String id, Entity entities) {
        super(id);
        this.entities = entities;
    }

    @Override
    public boolean isMovingRight() {
        if (owner.getPosition().x < entities.getPosition().x - 50) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isMovingLeft() {
        if (owner.getPosition().x > entities.getPosition().x + 50) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isJumping() {
        return false;
    }

    @Override
    public boolean isDashing() {
        return false;
    }

    @Override
    public boolean isAttacking() {
        if (entities.getPosition().y > owner.getPosition().y - 40 && entities.getPosition().x - 70 < 
                   owner.getPosition().x && owner.getPosition().x < entities.getPosition().x + 70) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {
    }
}
