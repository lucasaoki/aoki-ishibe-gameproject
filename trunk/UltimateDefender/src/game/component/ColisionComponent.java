/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

/**
 *
 * @author Lucas Aoki
 */
public class ColisionComponent extends Component{

    public ColisionComponent(String id) {
        this.id = id;
    }
    
    public boolean colision(){
        return false;
    }
    
    @Override
    public void update() {
    }
    
}
