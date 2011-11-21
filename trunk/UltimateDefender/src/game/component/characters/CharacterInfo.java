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
import java.awt.Rectangle;
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
    private boolean isJumping = false;
    private boolean isWalkingR = false;
    private boolean isWalkingL = false;
    private boolean toRight = true;
    private boolean isAttacking = false;
    private boolean isDashing = false;
    private boolean getHit = false;
    private boolean lose = false;
    private boolean won = false;
    private boolean isGuarding = false;
    private Rectangle colidedBox = null;

    public CharacterInfo(String id, PlayerCtrl playerCtrl, Stage stage) {
        this.id = id;
        this.vertSpeed = 0;
        this.stage = stage;
        this.playerCtrl = playerCtrl;
        this.life = 100;
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

    public boolean isWon() {
        return won;
    }

    public boolean isGuarding() {
        return isGuarding;
    }

    public void setIsGuarding(boolean isGuarding) {
        this.isGuarding = isGuarding;
    }

    public void setWon(boolean won) {
        this.won = won;
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


        if (!won) { //jogando
            if (life < 0) { //morreu
                lose = true;
            } else { //engine do player
                if (playerCtrl.isGuarding() && !isJumping) {
                    isGuarding = true;
                } else {
                    isGuarding = false;
                    if (!getHit) { //não levando hit
                        if (!isAttacking) {// não atacando
                            if (playerCtrl.isMovingRight() && pos.x < 640 - 80) {
                                pos.x += WALKSPEED;
                                toRight = true;
                                isWalkingR = true;
                            } else if (playerCtrl.isMovingLeft() && pos.x > 0) {
                                pos.x -= WALKSPEED;
                                toRight = false;
                                isWalkingL = true;
                            } else { //is standing
                                isWalkingL = false;
                                isWalkingR = false;
                            }
                            if (!isJumping) {
                                if (!stageColision()) {
                                    pos.y -= vertSpeed;
                                    vertSpeed -= GRAVITY;
                                } else {
                                    if (vertSpeed < 0) {
                                        vertSpeed = 0;
                                    }
                                }
                                if (stageColision()) {
                                    if (playerCtrl.isJumping() && vertSpeed == 0) {
                                        vertSpeed = JUMPSPEED;
                                        isJumping = true;
                                    } else {
                                        if (vertSpeed < 0) {
                                            double dif = colidedBox.getY() - owner.getColisionBox().getY();
                                            if (dif < 70) {
                                                vertSpeed = 0;
                                                

                                            }
                                        }
                                    }

                                } else if (playerCtrl.isAttacking()) {
                                    isAttacking = true;
                                }

                            } else { //is jumping
                                if (stageColision()) {
                                    if (vertSpeed < 0) {
                                        double dif = colidedBox.getY() - owner.getColisionBox().getY();
                                        if (dif > 70) {
                                            vertSpeed = 0;
                                            isJumping = false;

                                        } else {
                                            if (vertSpeed > -9) {
                                                pos.y -= vertSpeed;
                                                vertSpeed -= GRAVITY;
                                            } else {
                                                pos.y -= vertSpeed;
                                            }
                                        }
                                    } else {   if (vertSpeed > -9) {
                                                pos.y -= vertSpeed;
                                                vertSpeed -= GRAVITY;
                                            } else {
                                                pos.y -= vertSpeed;
                                            }
                                    }
                                } else {   if (vertSpeed > -9) {
                                                pos.y -= vertSpeed;
                                                vertSpeed -= GRAVITY;
                                            } else {
                                                pos.y -= vertSpeed;
                                            }
                                }
                            }

                            //dash
                            if (!isDashing && !playerCtrl.isHolding()) {
                                if (playerCtrl.isDashing()) {
                                    playerCtrl.startHolding();
                                    isDashing = true;
                                }
                            } else if (isDashing && playerCtrl.isHolding()) {
                                if (toRight) {
                                    if (pos.x + 10 * WALKSPEED < 640 - 80) {
                                        pos.x += 10 * WALKSPEED;
                                    }
                                } else {
                                    if (pos.x - 10 * WALKSPEED > 0) {
                                        pos.x -= 10 * WALKSPEED;
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
            }
        } else {
            isJumping = false;
            isWalkingR = false;
            isWalkingL = false;
            isAttacking = false;
            isDashing = false;
            getHit = false;
            isGuarding = false;
        }
        if (toRight) {
            owner.getColisionBox().setLocation(new Point(pos.x + 32, pos.y + 16));
        } else {
            owner.getColisionBox().setLocation(new Point(pos.x - 32, pos.y + 16));
        }
        owner.setPosition(pos);
    }

    @Override
    public boolean colision() {
        Iterator<Entity> it = stage.getEntityIterator();
        boolean colision = false;
        while (it.hasNext()) {
            Entity entity = it.next();
            if (owner.intersects(entity)) {
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
        int i = 0;
        if (entity.getCharInfo().lose) {
            i++;
            if (i == 1) {
                this.won = true;
            }
        }
        if (entity.getCharInfo().isAttacking) {
            if ((entity.getCharInfo().toRight && owner.getPosition().x > entity.getPosition().x)
                    || (!entity.getCharInfo().toRight && owner.getPosition().x < entity.getPosition().x)) {
                setGetHit(true);
            }
        } else {
            setGetHit(false);
        }
    }

    @Override
    public boolean stageColision() {
        Iterator<Rectangle> it = stage.getBoxesIterator();
        while (it.hasNext()) {
            Rectangle box = it.next();
            if (owner.intersects(box)) {
                colidedBox = box;
                return true;
            }
        }
        return false;
    }
}
