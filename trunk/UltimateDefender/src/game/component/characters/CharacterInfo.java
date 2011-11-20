/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Colision;
import game.component.Component;
import game.component.controller.PlayerCtrl;
import game.entity.Entity;
import game.stages.Stage;
import java.awt.Point;
import java.util.Iterator;

/**
 *
 * @author Lucas
 */
public class CharacterInfo extends Component implements Colision, Constants {

    float life;
    private Stage stage;
    private PlayerCtrl playerCtrl;
    private float vertSpeed;
    private float direction;
    private float speed;
    private boolean isJumping;
    private boolean isWalkingR;
    private boolean isWalkingL;
    private boolean toRight;
    private boolean isAttacking;
    private boolean isDashing;
    private boolean getHit;
    private boolean lose;

    public CharacterInfo(String id, PlayerCtrl playerCtrl, Stage stage) {
        this.id = id;
        this.vertSpeed = 0;
        this.stage = stage;
        this.playerCtrl = playerCtrl;
        this.isJumping = false;
        this.isWalkingR = false;
        this.isWalkingL = false;
        this.isAttacking = false;
        this.isDashing = false;
        this.toRight = true;
        this.getHit = false;
        this.lose = false;
        this.life = 100;
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

    public boolean isGetHit() {
        return getHit;
    }

    public boolean lose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public void setGetHit(boolean getHit) {
        this.getHit = getHit;
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
        colision();
        
        if (life < 0) {
            lose = true;
        } else {
            if (!getHit) {
                if (!isAttacking) {
                    if (playerCtrl.isMovingRight() && pos.x < 640 - 80) {
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

                    if (!isDashing && !playerCtrl.isHolding()) {
                        if (playerCtrl.isDashing()) {
                            playerCtrl.startHolding();
                            isDashing = true;
                        }
                    } else if (isDashing && playerCtrl.isHolding()) {
                        if (toRight) {
                            if (pos.x + 5 * walkSpeed < 640 - 80) {
                                pos.x += 5 * walkSpeed;
                            }
                        } else {
                            if (pos.x - 5 * walkSpeed > 0) {
                                pos.x -= 5 * walkSpeed;
                            }
                        }
                    } else if (!playerCtrl.isDashing()) {
                        playerCtrl.stopHolding();
                    }
                }
            } else {
                life--;
                
            }
        }


        owner.getColisionBox().setLocation(pos);
        owner.setPosition(pos);
    }

    @Override
    public boolean colision() {
        Iterator<Entity> it = stage.getEntityIterator();
        boolean colision = false;
        while (it.hasNext()) {
            Entity entity = it.next();
            if (owner.intersects(entity) && !entity.getId().equals("Background")) {
                if (!entity.getId().equals(owner.getId())) {
                    this.colisionAction(entity);
                    colision = true;
                }
            }
        }
        return colision;
    }

    @Override
    public void colisionAction(Entity entity) {
        if (entity.getCharInfo().isAttacking) {
            if ((entity.getCharInfo().toRight && owner.getPosition().x > entity.getPosition().x) || 
                    (!entity.getCharInfo().toRight && owner.getPosition().x < entity.getPosition().x)) {

                setGetHit(true);
            }
        } else {
            setGetHit(false);
        }
    }
}
