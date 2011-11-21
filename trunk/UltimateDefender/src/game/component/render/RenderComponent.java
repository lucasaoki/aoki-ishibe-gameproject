/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import game.component.Component;
import java.awt.Graphics2D;

/**
 * Componente base para a renderização
 * @author Lucas Aoki
 */
public abstract class RenderComponent extends Component {

    public RenderComponent(String id) {
        this.id = id;
    }

    public abstract void render(Graphics2D gr);
}
