/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import game.component.characters.CharacterInfo;
import game.gui.GamePanel;
import game.util.Timer;
import game.util.TimerListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class AnimationRenderComponent extends RenderComponent implements TimerListener {

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
        frameTimer = new Timer(this, 100);
        frameTimer.start();

        this.animation = imageFrames;
        this.currentAnimation = this.animation[0]; //FAZER CONTROLE AQUI
    }

    public void setAnimation(Image[] animation) {
        this.currentAnimation = animation;
    }

    @Override
    public void control() {
        if (characterInfo.isJumping()) {
            //acertar frame inicial, para não rodar sequencia errada da animação.
//            currentAnimation = this.animation[2];
        } else if (characterInfo.isWalkingR()) {
//            currentAnimation = this.animation[0];
        } else {
//            currentAnimation = this.animation[1];
        }
    }

    @Override
    public void update(Timer timer) {
        index = (index + 1) % currentAnimation.length;
        panel.repaint();
    }

    @Override
    public void render(Graphics gr) {
        Point pos = owner.getPosition();

        gr.drawImage(currentAnimation[index], pos.x, pos.y, null);

    }
}
