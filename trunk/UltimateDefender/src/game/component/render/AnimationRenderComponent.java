/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import game.component.characters.CharacterInfo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class AnimationRenderComponent extends RenderComponent{
    private CharacterInfo characterInfo = null;
    private Image[] animation;
    private Image[] currentAnimation;

    public AnimationRenderComponent(String id, Component characterInfo, Image[] imageFrames) {
        super(id);
        if(characterInfo instanceof CharacterInfo)
            this.characterInfo = (CharacterInfo)characterInfo;
        
    }
    
    public void setAnimation(Image[] animation){
        this.currentAnimation = animation;
    }
    
    @Override
    public void render(Graphics gr) {
        Point pos = owner.getPosition();
        /*gr.drawImage(null, pos.x, pos.y, null);*/
    }

    @Override
    public void update() {
        if (characterInfo.isJumping()) {
            //acertar frame inicial, para não rodar sequencia errada da animação.
//            currentAnimation = this.animation[2];
        } else if (characterInfo.isWalkingR()) {
//            currentAnimation = this.animation[0];
        } else {
//            currentAnimation = this.animation[1];
        }
    }
    
}
