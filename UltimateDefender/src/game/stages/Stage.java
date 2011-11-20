/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.stages;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Lucas
 */
public final class Stage extends Entity {

    private Rectangle box = null;
    private ArrayList<Entity> entities = null;

    public Stage(String id, GameContainer gc) {
        super(id);
        this.entities = new ArrayList<>();
        gc.setStageSelected(this);
        
        this.createStage();

        this.addEntity(this);
    }

    /*insercao de entidades que implementam colisao no mapa*/
    public void addEntity(Entity entidade) {
        entities.add(entidade);
    }

    public Iterator<Entity> getEntityIterator() {
        return entities.iterator();
    }
    
    public final void createStage(){
        box = new Rectangle(0, 0, 640, 480);
        this.addComponent(new ImageRenderComponent("BGImage", "/images/backgrounds/bg_bleach.png"));
        this.setPosition(new Point(0, 0));
        this.setColisionBox(box);
        this.setScale(1);
    }
}
