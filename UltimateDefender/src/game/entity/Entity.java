/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.Component;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Entity {

    String id;
    Point position;
    ArrayList<Component> components = null;

    public Entity(String id) {
        this.id = id;
        components = new ArrayList<Component>();
        position = new Point(0, 0);
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

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void update() {
        for (Component component : components) {
            component.update();
        }
    }

    public void render() {
    }
}
