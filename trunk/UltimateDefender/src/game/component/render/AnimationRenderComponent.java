/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import game.component.characters.CharacterInfo;
import game.component.characters.Chars;
import game.gui.GamePlay;
import game.util.Timer;
import game.util.TimerListener;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Lucas
 */
public class AnimationRenderComponent extends RenderComponent {

    private Timer frameTimer;
    private GamePlay gameframe;
    private CharacterInfo characterInfo = null;
    private Image[][] animation;
    private Image[] currentAnimation;
    private int index;

    public AnimationRenderComponent(String id, GamePlay gameframe, Component characterInfo, Image[][] imageFrames) {
        super(id);
        this.gameframe = gameframe;
        if (characterInfo instanceof CharacterInfo) {
            this.characterInfo = (CharacterInfo) characterInfo;
        }

        frameTimer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                updateFrame();
            }
        }, 80);
        frameTimer.start();
        
        this.index = 0;
        this.animation = imageFrames;
        this.currentAnimation = this.animation[Chars.getMoveIndex("STAND")]; //FAZER CONTROLE AQUI
    }

    public void setAnimation(Image[] animation) {
        this.currentAnimation = animation;
    }

    @Override
    public void update() {
        AffineTransform af = owner.getAf();

        if (characterInfo.isAttacking()) {
            if (currentAnimation != this.animation[Chars.getMoveIndex("B")]) {
                index = 0;
            }
            currentAnimation = this.animation[Chars.getMoveIndex("B")];
            if (index + 1 == currentAnimation.length) {
                characterInfo.setIsAttacking(false);
            }
        } else if (characterInfo.isJumping()) {
            if (currentAnimation != this.animation[Chars.getMoveIndex("JUMP")]) {
                index = 0;
            }
            currentAnimation = this.animation[Chars.getMoveIndex("JUMP")];
        } else if (characterInfo.isWalkingR()) {
            currentAnimation = this.animation[Chars.getMoveIndex("WALK")];
        } else if (characterInfo.isWalkingL()) {
            currentAnimation = this.animation[Chars.getMoveIndex("WALK")];
        } else {
            currentAnimation = this.animation[Chars.getMoveIndex("STAND")];
        }

        if (index >= currentAnimation.length) { /*correção de erro array index out of bounds*/
            index = 0;
        }

    }

    public void updateFrame() {
        index = (index + 1) % currentAnimation.length;
        gameframe.repaint();
    }

    @Override
    public void render(Graphics2D gr) {
        gr.drawImage(currentAnimation[index], owner.getAf(), null);
    }
}
