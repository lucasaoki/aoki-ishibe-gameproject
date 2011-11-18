/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Component;
import game.component.controller.PlayerCtrl;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class CharacterInfo extends Component implements Constants {

    private float vertSpeed;
    private float direction;
    private float speed;
    private PlayerCtrl playerCtrl;
    private boolean isJumping;
    private boolean isWalkingR;
    private boolean isWalkingL;
    private boolean toRight;
    private boolean isAttacking;
    private boolean isDashing;

    public CharacterInfo(String id, PlayerCtrl playerCtrl) {
        this.id = id;
        this.vertSpeed = 0;
        this.playerCtrl = playerCtrl;
        this.isJumping = false;
        this.isWalkingR = false;
        this.isWalkingL = false;
        this.isAttacking = false;
        this.isDashing = false;
        this.toRight = true;
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

    public boolean isDashing() {
        return isDashing;
    }

    public boolean toRight() {
        return toRight;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    public void setIsDashing(boolean isDashing) {
        this.isDashing = isDashing;
    }

    @Override
    public void update() {
        Point pos = owner.getPosition();

        if (!isAttacking) {
            if (playerCtrl.isMovingRight() && pos.x < 600) {
                pos.x += walkSpeed;
                toRight = true;
                isWalkingR = true;
            } else if (playerCtrl.isMovingLeft() && pos.x > 0) {
                pos.x -= walkSpeed;
                toRight = false;
                isWalkingL = true;
            } else { //is standing
                isWalkingL = false;
                isWalkingR = false;
            }
            if (isJumping) {
                pos.y -= vertSpeed;
                if (vertSpeed <= -jumpSpeed) {
                    vertSpeed = 0;
                    isJumping = false;
                }
                vertSpeed -= gravity;
            } else if (playerCtrl.isJumping()) {
                vertSpeed = jumpSpeed;
                isJumping = true;
            } else if (playerCtrl.isAttacking()) {
                isAttacking = true;
            }
        }

        if (!isDashing && !playerCtrl.isHolding()) {
            if (playerCtrl.isDashing()) {
                playerCtrl.startHolding();
                isDashing = true;
            }
        } else if (isDashing && playerCtrl.isHolding()) {
            if (toRight) {
                pos.x += 5 * walkSpeed;
            } else {
                pos.x -= 5 * walkSpeed;
            }
        }
        else if (!playerCtrl.isDashing()){
            playerCtrl.stopHolding();
        }

        owner.setPosition(pos);
    }
}
