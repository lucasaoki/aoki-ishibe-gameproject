/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import java.awt.Graphics;

/**
 *
 * @author Lucas Aoki
 */
public abstract class RenderComponent extends Component {

    public RenderComponent(String id) {
        this.id = id;
    }

    public abstract void render(Graphics gr);
}
