/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import game.component.characters.CharacterInfo;
import game.component.characters.Chars;
import game.gui.GamePanel;
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
    private GamePanel panel;
    private CharacterInfo characterInfo = null;
    private Image[][] animation;
    private Image[] currentAnimation;
    private int index;

    public AnimationRenderComponent(String id, GamePanel panel, Component characterInfo, Image[][] imageFrames) {
        super(id);
        this.panel = panel;
        if (characterInfo instanceof CharacterInfo) {
            this.characterInfo = (CharacterInfo) characterInfo;
        }

        frameTimer = new Timer(new TimerListener() {

            @Override
            public void update(Timer timer) {
                updateFrame();
            }
        }, 100);
        frameTimer.start();

        Chars a = new Chars("Helper");
        this.animation = imageFrames;
        this.currentAnimation = this.animation[a.getMoveIndex("STAND")]; //FAZER CONTROLE AQUI
    }

    public void setAnimation(Image[] animation) {
        this.currentAnimation = animation;
    }

    @Override
    public void update() {
//        if (characterInfo.isJumping()) {
//            //acertar frame inicial, para não rodar sequencia errada da animação.
////            currentAnimation = this.animation[2];
//        } else if (characterInfo.isWalkingR()) {
////            currentAnimation = this.animation[0];
//        } else {
////            currentAnimation = this.animation[1];
//        }
    }

    public void updateFrame() {
        index = (index + 1) % currentAnimation.length;
        panel.repaint();
    }

    @Override
    public void render(Graphics2D gr) {
        Point pos = owner.getPosition();

        AffineTransform af = owner.getAf();
//        af.translate(pos.x, pos.y);
        if (currentAnimation != null) {
//            af.translate(pos.x + currentAnimation[index].getWidth(panel), pos.y);
//            af.scale(-1, 1);
        }

        gr.drawImage(currentAnimation[index], af, null);
    }
}
