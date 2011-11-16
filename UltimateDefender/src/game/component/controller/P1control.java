/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.controller;

import game.util.Timer;
import game.util.TimerListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author Lucas
 */
public class P1control extends PlayerCtrl {

    Timer holdDelay;

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
        if (input[KeyEvent.VK_L] == true && hold == false) {
            setHold(true);
            holdDelay = new Timer(new TimerListener() {

                @Override
                public void update(Timer timer) {
                    setHold(false);
                }
            }, 2000);
            holdDelay.start();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAttacking() {
        return input[KeyEvent.VK_J];
    }

    @Override
    public void update() {
    }
}
