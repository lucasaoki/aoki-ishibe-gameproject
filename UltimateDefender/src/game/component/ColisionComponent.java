/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import java.awt.Rectangle;

/**
 *
 * @author Lucas Aoki
 */
public class ColisionComponent extends Component{

    Rectangle box = null;
    
    public ColisionComponent(String id, Rectangle box) {
        this.id = id;
        this.box = box;
    }
    
    @Override
    public void update() {
    }
    
}
