/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Lucas
 */
public class CharacterInfo extends Component implements KeyListener, Constants {

    private float vertSpeed;
    private boolean isJumping;
    private boolean isWalkingR;
    private boolean isWalkingL;
    private boolean isAttacking;
    float direction;
    float speed;
    private boolean[] input = new boolean[256];

    public CharacterInfo(String id) {
        this.id = id;
        this.vertSpeed = 0;
        isJumping = false;
        isWalkingR = false;
        isWalkingL = false;
        isAttacking = false;
    }

    public float getDirection() {
        return direction;
    }

    public float getSpeed() {
        return speed;
    }

    public float getVertSpeed() {
        return vertSpeed;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public boolean isWalkingR() {
        return isWalkingR;
    }

    public boolean isWalkingL() {
        return isWalkingL;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        input[e.getKeyCode() & 0xff] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        input[e.getKeyCode() & 0xff] = false;
    }

    @Override
    public void update() {
        Point pos = owner.getPosition();
        AffineTransform af = owner.getAf();
        float scale = owner.getScale();


        if (!isAttacking) {
            if (input[KeyEvent.VK_RIGHT & 0xff] && pos.x < 640) {
                if (af.getScaleX() == -1) {
                    af.translate(45, 0);
                    af.scale(-scale, scale);
                }
                af.translate(walkSpeed, 0);
                isWalkingR = true;
            } else if (input[KeyEvent.VK_LEFT & 0xff] && pos.x > 0) {
                if (af.getScaleX() == 1) {
                    af.translate(45, 0);
                    af.scale(-scale, scale);
                }
                af.translate(walkSpeed, 0);
                isWalkingL = true;
            } else {
                isWalkingL = false;
                isWalkingR = false;
            }
            if (isJumping) {
                af.translate(0, -vertSpeed);
                if (vertSpeed <= -jumpSpeed) {
                    vertSpeed = 0;
                    isJumping = false;
                }
                vertSpeed -= gravity;
            } else if (input[KeyEvent.VK_UP & 0xff]) {
                vertSpeed = jumpSpeed;
                isJumping = true;
            } else if (input[KeyEvent.VK_C & 0xff]) {
                isAttacking = true;
            }

        }

        owner.setAf(af);
    }
}
