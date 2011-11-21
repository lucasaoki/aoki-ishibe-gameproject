/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.controller;

import game.component.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe padrão para controle do personagem
 * com os métodos necessário para as classes herdadas.
 * @author Lucas
 */
public abstract class PlayerCtrl extends Component implements KeyListener {

    protected boolean[] input = new boolean[256];
    protected boolean holding;

    public PlayerCtrl(String id) {
        this.id = id;
        holding = false;
    }

    /**
     * Controle de tecla pressionada e segurada
     * Checa se parou de segurar
     */
    public void stopHolding() {
        holding = false;
    }
    
    /**
     * Checa se começou a segurar a tecla
     */
    public void startHolding(){
        holding = true;
    }
    
    /**
     * Checa se está segurando a tecla
     * @return 
     * true se está segurando e false c.c.
     */
    public boolean isHolding(){
        return holding;
    }

    /**
     * Se o personagem estaria se movendo para a direita
     * @return 
     * true se está se movendo, false c.c
     */
    public abstract boolean isMovingRight();
    
    /**
     * Se o personagem estaria se movendo para a direita
     * @return 
     * true se está se movendo, false c.c
     */
    public abstract boolean isMovingLeft();

    /**
     * Se o personagem estaria se movendo para a esquerda
     * @return 
     * true se está se movendo, false c.c
     */
    public abstract boolean isJumping();

    /**
     * Se o personagem estaria pulando
     * @return 
     * true se está pulando, false c.c
     */
    public abstract boolean isDashing();

    /**
     * Se o personagem estaria dando dash
     * @return 
     * true se está dando dash, false c.c
     */
    public abstract boolean isAttacking();
    
    /**
     * Se o personagem estaria se defendendo
     * @return 
     * true se está se defendendo, false c.c
     */
    public abstract boolean isGuarding();

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