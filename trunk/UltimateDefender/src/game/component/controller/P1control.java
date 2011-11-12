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
        return input[KeyEvent.VK_RIGHT];
    }

    @Override
    public boolean isMovingLeft() {
        return input[KeyEvent.VK_LEFT];
    }

    @Override
    public boolean isJumping() {
        return input[KeyEvent.VK_X];
    }

    @Override
    public boolean isDashing() {
        return input[KeyEvent.VK_Z];
    }

    @Override
    public boolean isAttacking() {
        return input[KeyEvent.VK_C];
    }

    @Override
    public void update() {
        System.out.println(input[KeyEvent.VK_RIGHT]);
    }
}
