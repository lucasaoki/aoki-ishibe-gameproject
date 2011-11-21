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
    private ArrayList<Rectangle> boxes = null;
    private ArrayList<Entity> entities = null;

    public Stage(String id, GameContainer gc) {
        super(id);
        this.entities = new ArrayList<>();
        this.boxes = new ArrayList<>();
        gc.setStageSelected(this);
        
        this.createStage();

//        this.addEntity(this);
    }

    /*insercao de entidades que implementam colisao no mapa*/
    public void addEntity(Entity entidade) {
        entities.add(entidade);
    }

    public Iterator<Entity> getEntityIterator() {
        return entities.iterator();
    }
    
    public Iterator<Rectangle> getBoxesIterator(){
        return boxes.iterator();
    }
    
    public final void createStage(){
//        box = new Rectangle(0, 0, 640, 480);
        this.boxes.add(new Rectangle(0, 240, 105-36, 25));
        this.boxes.add(new Rectangle(105+36, 105, 105-72, 25));
        this.boxes.add(new Rectangle(210+36, 290, 220-72, 25));
        this.boxes.add(new Rectangle(425+36, 105, 105-72, 25));
        this.boxes.add(new Rectangle(535+36, 240, 105-36, 25));
        this.boxes.add(new Rectangle(0, 425, 640, 300));
        this.addComponent(new ImageRenderComponent("BGImage", "/images/backgrounds/bg_bleach.png"));
        this.setPosition(new Point(0, 0));
//        this.setColisionBox(box);
//        this.setScale(1);
    }
}
