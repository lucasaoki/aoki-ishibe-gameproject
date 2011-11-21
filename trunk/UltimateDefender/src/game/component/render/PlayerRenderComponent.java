/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import game.component.characters.CharacterInfo;
import game.component.characters.CharsMoves;
import game.gui.GameContainer;
import game.util.Timer;
import game.util.TimerListener;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;

/**
 * Controle da componente de renderização do personagem animado.
 * @author Lucas
 */
public class PlayerRenderComponent extends RenderComponent {
    
    private Timer frameTimer;
    private long frameCtrl;
    private GameContainer gc;
    private CharacterInfo characterInfo = null;
    private Image[][] animation;
    private Image[] currentAnimation;
    private int index;
    
    /**
     * @param id
     * Id da componente
     * @param gc
     * Container com informações básicas do jogo
     * @param characterInfo
     * Componente com informações do personagem para escolha da animação correta
     * @param imageFrames 
     * Matriz com as imagens do personagem (índices controlados pela classe CharsMoves)
     */
    public PlayerRenderComponent(String id, GameContainer gc, Component characterInfo, Image[][] imageFrames) {
        super(id);
        this.gc = gc;
        if (characterInfo instanceof CharacterInfo) {
            this.characterInfo = (CharacterInfo) characterInfo;
        }
        
        frameCtrl = 100;
        /*timer para controle dos frames das imagens*/
        frameTimer = new Timer(new TimerListener() {
            
            @Override
            public void update(Timer timer) {
                updateFrame();
            }
        }, frameCtrl);
        frameTimer.start();
        
        this.index = 0;
        this.animation = imageFrames;
        this.currentAnimation = this.animation[CharsMoves.getMoveIndex("STAND")];
    }
    
    /**
     * Método controlador das imagens do personagem
     */
    @Override
    public void update() {
        if (!gc.isPause()) { // controle do pause do jogo
            //ainda não perdeu
            if (!characterInfo.lose()) {
                if (characterInfo.isGuarding()) {//in guard
                    setCurrentAnimation(CharsMoves.getMoveIndex("GUARD"), 500);
                } else //getting hit
                if (characterInfo.isHit()) {
                    setCurrentAnimation(CharsMoves.getMoveIndex("GETHIT"), 500);
                } else {
                    //attacking
                    if (characterInfo.isAttacking()) {
                        setCurrentAnimation(CharsMoves.getMoveIndex("B"), 100);
                        if (index + 1 == currentAnimation.length) {
                            characterInfo.setIsAttacking(false);
                        }
                    } else //dashing
                    if (characterInfo.isDashing()) {
                        setCurrentAnimation(CharsMoves.getMoveIndex("DASH"), 150);
                        if (index + 1 == currentAnimation.length) {
                            characterInfo.setIsDashing(false);
                        }
                    } else //jumping
                    if (characterInfo.isJumping()) {
                        setCurrentAnimation(CharsMoves.getMoveIndex("JUMP"), 150);
                    } else //walking to right
                    if (characterInfo.isWalkingR()) {
                        setCurrentAnimation(CharsMoves.getMoveIndex("WALK"), 100);
                    } else //walking to left
                    if (characterInfo.isWalkingL()) {
                        setCurrentAnimation(CharsMoves.getMoveIndex("WALK"), 100);
                    } else {//standing
                        setCurrentAnimation(CharsMoves.getMoveIndex("STAND"), 100);
                    }
                }
            } else {//loose
                setCurrentAnimation(CharsMoves.getMoveIndex("LOSE"), 150);
            }
        }
    }

    /**
     * Escolha da animação a ser renderizada
     * @param index
     * Qual animação será usada (controle pela classe CharsMoves
     * @param frameCtrl 
     * Controle do timing do frame
     */
    public void setCurrentAnimation(int index, long frameCtrl) {
        if (currentAnimation != this.animation[index]) {
            this.index = 0;
            frameTimer.setTime(frameCtrl);
        }
        currentAnimation = this.animation[index];
    }
    
    /**
     * Controle da troca do frame
     */
    public void updateFrame() {
        if (!gc.isPause()) {
            if (!characterInfo.lose() || (index + 1 < animation[CharsMoves.getMoveIndex("LOSE")].length)) {
                index = (index + 1) % currentAnimation.length;
            } else {
                index = animation[CharsMoves.getMoveIndex("LOSE")].length - 1;
            }
            
            gc.getMainFrame().repaint();
        }
    }
    
    /**
     * Função de renderização
     */
    @Override
    public void render(Graphics2D gr) {
        AffineTransform af = new AffineTransform();
        Point pos = owner.getPosition();
        float scale = owner.getScale();
        
        af.translate(pos.x, pos.y);
        if (!characterInfo.toRight()) {
            af.translate(64, 0);
            af.scale(-1, 1);
        }
        af.scale(scale, scale);
        
        gr.drawImage(currentAnimation[index], af, null);
    }
}
