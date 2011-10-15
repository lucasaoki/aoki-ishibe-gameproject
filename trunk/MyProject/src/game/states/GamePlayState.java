/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.states;

import game.component.movement.PlayerMovement;
import game.component.render.AnimationRenderComponent;
import game.entity.Entity;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.PackedSpriteSheet;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Aoki
 */
public class GamePlayState extends BasicGameState {

    int stateID = -1;
    Entity player = null;
    Animation[] pAnimation = null;
    
    public GamePlayState(int stateID) throws SlickException {
        this.stateID = stateID;
        pAnimation = new Animation[3];
    }

    @Override
    public int getID() {
        return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        player = new Entity("player");

        pAnimation[0] = new Animation(new PackedSpriteSheet("images/walk.def").getSpriteSheet("walk"), 100);
        pAnimation[1] = new Animation(new PackedSpriteSheet("images/stand.def").getSpriteSheet("stand"), 100);
        pAnimation[2] = new Animation(new PackedSpriteSheet("images/jump.def").getSpriteSheet("jump"), 100);
        player.addComponent(new PlayerMovement("PlayerWalk"));
        player.addComponent(new AnimationRenderComponent("PlayerRender", player.getComponent("PlayerWalk"), pAnimation));
        player.setPosition(new Vector2f(300, 300));
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        player.update(gc, sbg, delta);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        player.render(gc, sbg, grphcs);
    }
}
