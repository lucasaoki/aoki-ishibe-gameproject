/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stages;

import game.component.Colision;
import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Lucas
 */
public class Stage extends Entity implements Colision{

    private Rectangle box = null;
    private ArrayList<Entity> entities = null;

    public Stage(String id, GameContainer gc) {
        super(id);
        this.entities = new ArrayList<>();
        gc.setStageSelected(this);
        box = new Rectangle(0, 0, 640, 480);
        
        this.addComponent(new ImageRenderComponent("BGImage", "/images/backgrounds/bg_bleach.png"));
        this.setPosition(new Point(0, 0));
        this.setColisionBox(box);
        this.setScale(1); //arrumar para as imagens ficarem em scale 1
        
        this.addEntity(this);
    }

    /*insercao de entidades que implementam colisao no mapa*/
    public void addEntity(Entity entidade) {
        entities.add(entidade);
    }

    public Iterator<Entity> getEntityIterator() {
        return entities.iterator();
    }

    public boolean colision() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public void colisionAction(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
