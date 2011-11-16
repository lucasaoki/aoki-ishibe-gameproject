/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Component;
import game.component.controller.PlayerCtrl;
import java.awt.Point;
import java.awt.geom.AffineTransform;

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

    public void setIsDashing(boolean isDashing) {
        this.isDashing = isDashing;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    @Override
    public void update() {
        Point pos = owner.getPosition();
        AffineTransform af = owner.getAf();
        float scale = owner.getScale();


        if (!isAttacking) {
            if (playerCtrl.isMovingRight() && pos.x < 600) {
                if (af.getScaleX() == -1) {
                    af.translate(45, 0);
                    af.scale(-scale, scale);
                }
                af.translate(walkSpeed, 0);
                isWalkingR = true;
            } else if (playerCtrl.isMovingLeft() && pos.x > 0) {
                if (af.getScaleX() == 1) {
                    af.translate(45, 0);
                    af.scale(-scale, scale);
                }
                af.translate(walkSpeed, 0);
                isWalkingL = true;
            } else { //is standing
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
            } else if (playerCtrl.isJumping()) {
                vertSpeed = jumpSpeed;
                isJumping = true;
            } else if (playerCtrl.isAttacking()) {
                isAttacking = true;
            } else if (playerCtrl.isDashing()) {
                af.translate(10 * walkSpeed, 0);
                isDashing = true;
            }

        }

        owner.setAf(af);
    }
}
