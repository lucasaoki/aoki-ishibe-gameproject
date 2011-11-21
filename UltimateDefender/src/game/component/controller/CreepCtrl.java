/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.controller;

import game.component.characters.CharacterInfo;
import game.component.characters.Constants;
import game.entity.Entity;
import game.util.Timer;
import game.util.TimerListener;

/**
 * Classe de controle da inteligencia artificial
 * @author Seiji
 */
public class CreepCtrl extends PlayerCtrl implements Constants {

    Entity entity = null;
    CharacterInfo entityInfo = null;
    private boolean followNow = false;
    private boolean attackNow = false;
    private boolean standing = true;
    private Timer chaseTimer;
    private Timer attackTimer;
    private Timer standTimer;
    private int timesAttacking = 0;

    public CreepCtrl(String id, Entity entity) {
        super(id);
        this.entity = entity;

        if (CharacterInfo.class.isInstance(entity.getComponent(entity.getId() + "Info"))) {
            entityInfo = (CharacterInfo) entity.getComponent(entity.getId() + "Info");
        }

        chaseTimer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                standing = false;
                followNow = true;
            }
        }, 3500);

        attackTimer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                standing = false;
                attackNow = true;
            }
        }, 4500);

        standTimer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                standing = true;
                attackNow = false;
                followNow = false;
            }
        }, 2500);
        standTimer.start();
        chaseTimer.start();
        attackTimer.start();
    }

    @Override
    public boolean isMovingRight() {
        if ((entity.getPosition().y - 50 > owner.getPosition().y) && owner.getPosition().x > 100) {
            return true;
        }
        if (owner.getPosition().x < entity.getPosition().x - 50 && followNow) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isMovingLeft() {
        if ((entity.getPosition().y - 50 > owner.getPosition().y) && owner.getPosition().x < 640) {
            return true;
        }
        if (owner.getPosition().x > entity.getPosition().x + 50 && followNow) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isJumping() {
        if (followNow && entity.getPosition().y + 150 < owner.getPosition().y) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isDashing() {
        return false;
    }

    @Override
    public boolean isAttacking() {
        if (entity.getPosition().y > owner.getPosition().y - 40 && entity.getPosition().x - 70
                < owner.getPosition().x && owner.getPosition().x < entity.getPosition().x + 70 && attackNow) {
            if (timesAttacking == ATTACKMULTIPLY) {
                attackNow = false;
                this.update();
            }
            followNow = false;
            timesAttacking++;
            return true;
        }
        return false;
    }

    @Override
    public boolean isGuarding() {
        if (entityInfo.isAttacking() && standing) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if (owner.getPosition().getX() > 320) {
            attackTimer.setTime(owner.getPosition().x * 5);
            chaseTimer.setTime(owner.getPosition().x * 4);
        }
        else {
            attackTimer.setTime(owner.getPosition().x * 15);
            chaseTimer.setTime(owner.getPosition().x * 14);            
        }
    }
}
