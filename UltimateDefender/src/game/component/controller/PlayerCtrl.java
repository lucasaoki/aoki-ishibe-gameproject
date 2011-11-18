/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.controller;

import game.component.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Lucas
 */
public abstract class PlayerCtrl extends Component implements KeyListener {

    protected boolean[] input = new boolean[256];
    protected boolean holding;

    public PlayerCtrl(String id) {
        this.id = id;
        holding = false;
    }

    public void stopHolding() {
        holding = false;
    }
    
    public void startHolding(){
        holding = true;
    }
    
    public boolean isHolding(){
        return holding;
    }

    public abstract boolean isMovingRight();

    public abstract boolean isMovingLeft();

    public abstract boolean isJumping();

    public abstract boolean isDashing();

    public abstract boolean isAttacking();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        input[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        input[e.getKeyCode()] = false;
    }
}
