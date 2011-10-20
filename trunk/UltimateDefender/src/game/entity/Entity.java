/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.Component;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Entity {

    String id;
    float x;
    float y;
    ArrayList<Component> components = null;

    public Entity(String id) {
        this.id = id;
        components = new ArrayList<Component>();
        x = 0;
        y = 0;
    }

    public void addComponent(Component component) {
        //render comp

        component.setOwnerEntity(this);
        components.add(component);
    }

    public Component getComponent(String id) {
        for (Component comp : components) {
            if (comp.getID().equalsIgnoreCase(id)) {
                return comp;
            }
        }
        return null;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
}
