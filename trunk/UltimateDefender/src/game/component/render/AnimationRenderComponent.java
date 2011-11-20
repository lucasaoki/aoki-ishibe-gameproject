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
 *
 * @author Lucas
 */
public class AnimationRenderComponent extends RenderComponent {

    private Timer frameTimer;
    private GameContainer gc;
    private CharacterInfo characterInfo = null;
    private Image[][] animation;
    private Image[] currentAnimation;
    private int index;

    public AnimationRenderComponent(String id, GameContainer gc, Component characterInfo, Image[][] imageFrames) {
        super(id);
        this.gc = gc;
        if (characterInfo instanceof CharacterInfo) {
            this.characterInfo = (CharacterInfo) characterInfo;
        }

        frameTimer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                updateFrame();
            }
        }, 130);
        frameTimer.start();

        this.index = 0;
        this.animation = imageFrames;
        this.currentAnimation = this.animation[CharsMoves.getMoveIndex("STAND")]; //FAZER CONTROLE AQUI
    }

    public void setAnimation(Image[] animation) {
        this.currentAnimation = animation;
    }

    @Override
    public void update() {
        //ainda não perdeu
        if (!characterInfo.lose()) {
            //getting hit
            if (characterInfo.isGetHit()) {
                if (currentAnimation != this.animation[CharsMoves.getMoveIndex("GETHIT")]) {
                    index = 0;
                }
                currentAnimation = this.animation[CharsMoves.getMoveIndex("GETHIT")];
            } else {
                //attacking
                if (characterInfo.isAttacking()) {
                    if (currentAnimation != this.animation[CharsMoves.getMoveIndex("B")]) {
                        index = 0;
                    }
                    currentAnimation = this.animation[CharsMoves.getMoveIndex("B")];
                    if (index + 1 == currentAnimation.length) {
                        characterInfo.setIsAttacking(false);
                    }
                } else //dashing
                if (characterInfo.isDashing()) {
                    if (currentAnimation != this.animation[CharsMoves.getMoveIndex("DASH")]) {
                        index = 0;
                    }
                    currentAnimation = this.animation[CharsMoves.getMoveIndex("DASH")];
                    if (index + 1 == currentAnimation.length) {
                        characterInfo.setIsDashing(false);
                    }
                } else //jumping
                if (characterInfo.isJumping()) {
                    if (currentAnimation != this.animation[CharsMoves.getMoveIndex("JUMP")]) {
                        index = 0;
                    }
                    currentAnimation = this.animation[CharsMoves.getMoveIndex("JUMP")];
                } else //walking to right
                if (characterInfo.isWalkingR()) {
                    if (currentAnimation != this.animation[CharsMoves.getMoveIndex("WALK")]) {
                        index = 0;
                    }
                    currentAnimation = this.animation[CharsMoves.getMoveIndex("WALK")];
                } else //walking to left
                if (characterInfo.isWalkingL()) {
                    if (currentAnimation != this.animation[CharsMoves.getMoveIndex("WALK")]) {
                        index = 0;
                    }
                    currentAnimation = this.animation[CharsMoves.getMoveIndex("WALK")];
                } else //standing
                {
                    if (currentAnimation != this.animation[CharsMoves.getMoveIndex("STAND")]) {
                        index = 0;
                    }
                    currentAnimation = this.animation[CharsMoves.getMoveIndex("STAND")];
                }
            }
        } else//loose
        {
            if (currentAnimation != this.animation[CharsMoves.getMoveIndex("LOSE")]) {
                index = 0;
            }
            currentAnimation = this.animation[CharsMoves.getMoveIndex("LOSE")];
        }
    }

    public void updateFrame() {
//        if (!characterInfo.lose()) {
            index = (index + 1) % currentAnimation.length;
//        } else {
//            if (index - 1 < currentAnimation.length) {
//                index++;
//            }
//            else index = currentAnimation.length-1;
//        }

        gc.getMainFrame().repaint();
    }

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
