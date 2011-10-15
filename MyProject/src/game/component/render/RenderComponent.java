/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lucas Aoki
 */
public abstract class RenderComponent extends Component{

    public RenderComponent(String id) {
        this.id = id;
    }
    
    public abstract void render(GameContainer gc, StateBasedGame sb, Graphics gr);
}
