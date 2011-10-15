/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import game.component.movement.PlayerMovement;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Aoki
 */
public class AnimationRenderComponent extends RenderComponent {

    private Animation animation[] = null;
    private Animation currentAni = null;
    PlayerMovement playerMovement = null;

    public AnimationRenderComponent(String id, Component playerMovement, Animation[] animation) {
        super(id);
        this.animation = animation;
        currentAni = this.animation[0];
        this.playerMovement = (PlayerMovement) playerMovement;//fazer o tratamento do casting.
    }

    public void setAnimation(Animation animation) {
        this.currentAni = animation;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
        Vector2f pos = owner.getPosition();

        currentAni.draw(pos.x, pos.y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        if (playerMovement.isJumping()) {
            //acertar frame inicial, para não rodar sequencia errada da animação.
            currentAni = this.animation[2];
        } else if (playerMovement.isWalkingR()) {
            currentAni = this.animation[0];
        } else {
            currentAni = this.animation[1];
        }
    }
}
