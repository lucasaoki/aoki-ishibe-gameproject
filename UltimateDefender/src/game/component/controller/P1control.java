/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.controller;

import java.awt.event.KeyEvent;

/**
 *
 * @author Lucas
 */
public class P1control extends PlayerCtrl {

    public P1control(String id) {
        super(id);
    }

    @Override
    public boolean isMovingRight() {
        return input[KeyEvent.VK_D];
    }

    @Override
    public boolean isMovingLeft() {
        return input[KeyEvent.VK_A];
    }

    @Override
    public boolean isJumping() {
        return input[KeyEvent.VK_K];
    }

    @Override
    public boolean isDashing() {
        return input[KeyEvent.VK_L];
    }

    @Override
    public boolean isAttacking() {
        return input[KeyEvent.VK_J];
    }

    @Override
    public void update() {
    }
}
