/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Colision;
import game.component.Component;
import game.component.controller.PlayerCtrl;
import game.entity.Entity;
import game.stage.Stage;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

/**
 * Classe que carrega as informações e as ações do caracter.
 * Engine dos poersonagens.
 * @author Lucas
 */
public class CharacterInfo extends Component implements Colision, Constants {

    private static int creepsCtrl = 0;
    private int score = 0;
    private float life;
    private Stage stage;
    private PlayerCtrl playerCtrl;
    private double vertSpeed;
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

    /**
     * Método que guarda os informações do caracter.
     * @param id 
     * @param playerCtrl 
     * @param stage 
     */
    public CharacterInfo(String id, PlayerCtrl playerCtrl, Stage stage) {
        this.id = id;
        this.score = 0;
        this.creepsCtrl = 0;
        this.vertSpeed = 0;
        this.stage = stage;/*Informações da fase*/
        this.playerCtrl = playerCtrl;/*Informações do controlador*/
        this.life = 1000;
    }

    /*****************************************************************************/
    /**
     * Conjunto de métodos que lê as informações do personagem.
     */
    public int getLife() {
        return (int) life;
    }

    public double getVertSpeed() {
        return vertSpeed;
    }

    /*****************************************************************************/
    /**
     * Conjunto de métodos boleanos que verificam se o usuário está em alguma ação.
     */
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

    /**
     * Checagem da direção do personagem
     * @toRight 
     */
    public boolean toRight() {
        return toRight;
    }

    public boolean isHit() {
        return getHit;
    }

    public boolean lose() {
        return lose;
    }

    public boolean won() {
        return won;
    }

    public boolean isGuarding() {
        return isGuarding;
    }

    /*****************************************************************************/
    /**
     * Conjunto de métodos de controle de valor. 
     */
    public void setIsGuarding(boolean isGuarding) {
        this.isGuarding = isGuarding;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public void setIsHit(boolean getHit) {
        this.getHit = getHit;
    }

    public void setIsAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }

    public void setIsDashing(boolean isDashing) {
        this.isDashing = isDashing;
    }

    /*****************************************************************************/
    /**
     * Método que controlador das ações do usuário.
     */
    @Override
    public void update() {
        if (!(stage.isPause())) { //controle de pause do jogo
            Point pos = owner.getPosition();
            colision();
            if (!stage.getMainPlayer().getCharInfo().won() && !stage.getMainPlayer().getCharInfo().lose()) { //jogando
                if (life < 0) { //morreu
                    if (!owner.getId().equals(stage.getMainPlayer().getId()) && !owner.getCharInfo().lose()) {
                        creepsCtrl++;
                        if (creepsCtrl >= 3) {
                            stage.getMainPlayer().getCharInfo().setWon(true);
                        }
                    }
                    lose = true;
                } else { //engine do player
                    if (playerCtrl.isGuarding() && !isJumping) {//defendendo
                        isGuarding = true;
                    } else {
                        isGuarding = false;
                        if (!getHit) { //não levando hit
                            if (!isAttacking) {// não atacando
                                if (playerCtrl.isMovingRight() && pos.getX() < 640 - 80) {
                                    pos.setLocation(pos.getX() + WALKSPEED, pos.getY());
                                    toRight = true;
                                    isWalkingR = true;
                                } else if (playerCtrl.isMovingLeft() && pos.getX() > 0) {
                                    pos.setLocation(pos.getX() - WALKSPEED, pos.getY());
                                    toRight = false;
                                    isWalkingL = true;
                                } else { //is standing
                                    isWalkingL = false;
                                    isWalkingR = false;
                                }
                                if (!isJumping) { //not jumping
                                    //começou a pular
                                    if (playerCtrl.isJumping() && vertSpeed == 0) {
                                        vertSpeed = JUMPSPEED;
                                        isJumping = true;
                                    } else if (stageColision()) {
                                        if (vertSpeed <= 0) {
                                            isJumping = false;
                                            vertSpeed = 0;
                                        }
                                    } else {
                                        isJumping = true;
                                        pos.setLocation(pos.getX(), pos.getY() - vertSpeed);
                                        vertSpeed -= GRAVITY;
                                    }
                                    if (playerCtrl.isAttacking()) {//ataque basico nao pode ser executado enquanto pula
                                        isAttacking = true;
                                    }

                                } else { //is jumping
                                    if (stageColision()) {
                                        if (vertSpeed < 0) {
                                            if (colidedBox.getY() > owner.getColisionBox().getY()) {
                                                if (owner.getColisionBox().getHeight() - (colidedBox.getY() - owner.getColisionBox().getY()) < 12.5) {
                                                    vertSpeed = 0;
                                                    isJumping = false;
                                                } else {
                                                    pos.setLocation(pos.getX(), pos.getY() - vertSpeed);
                                                    vertSpeed -= GRAVITY / 2;
                                                }
                                            } else {
                                                pos.setLocation(pos.getX(), pos.getY() - vertSpeed);
                                                vertSpeed -= GRAVITY / 2;
                                            }
                                        } else {
                                            pos.setLocation(pos.getX(), pos.getY() - vertSpeed);
                                            vertSpeed -= GRAVITY / 2;
                                        }
                                    } else {
                                        pos.setLocation(pos.getX(), pos.getY() - vertSpeed);
                                        vertSpeed -= GRAVITY / 2;
                                    }
                                }

                                //dash
                                if (!isDashing && !playerCtrl.isHolding()) {//controle do dash com controle de holding de tecla
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
                            } else {
                                if (colision() && owner.getId().equals(stage.getMainPlayer().getId())) {
                                    score += 100;
                                }
                            }
                        } else {//getting hit
                            life = life - 5f;
                            if (colision() && owner.getId().equals(stage.getMainPlayer().getId())) {
                                score += 2;
                            }
                        }
                    }
                }
            } else {//ganhou
                isJumping = false;
                isWalkingR = false;
                isWalkingL = false;
                isAttacking = false;
                isDashing = false;
                getHit = false;
                isGuarding = false;
//                }
            }
            if (toRight) {//controle da caixa de colisao para seguir a posição do personagem
                owner.getColisionBox().setLocation(new Point(pos.x + 32, pos.y + 16));
            } else {
                owner.getColisionBox().setLocation(new Point(pos.x - 32, pos.y + 16));
            }
            owner.setPosition(pos);
            stage.setScore(score);
        }
    }

    /*****************************************************************************/
    /**
     * Método que verifica a colisão do personagem com outro.
     */
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

    /*****************************************************************************/
    /**
     * Ação do personagem caso haja colição
     */
    @Override
    public void colisionAction(Entity entity) {
        int i = 0;
        if (entity.getCharInfo().isAttacking) {
            if ((entity.getCharInfo().toRight && owner.getPosition().x > entity.getPosition().x)
                    || (!entity.getCharInfo().toRight && owner.getPosition().x < entity.getPosition().x)) {
                setIsHit(true);
            }
        } else {
            setIsHit(false);
        }
    }

    /*****************************************************************************/
    /**
     * Controle de colisão com o cenario. 
     */
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
