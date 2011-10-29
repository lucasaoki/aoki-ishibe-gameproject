/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.Component;
import game.component.render.RenderComponent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class Entity {

    String id;
    Point position;
    RenderComponent renderComponent = null;
    ArrayList<Component> components = null;

    public Entity(String id) {
        this.id = id;
        components = new ArrayList<Component>();
        position = new Point(0, 0);
    }

    public void addComponent(Component component) {
        if (RenderComponent.class.isInstance(component)) {
            renderComponent = (RenderComponent) component;
        }

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

    public String getId() {
        return id;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    public Image[] readFrames(String path, int num) {
        Image tmp[] = new Image[num];
        for (int i = 1; i <= num; i++) {
            String filename = path + i + ".png";
            URL url = Entity.class.getResource(filename);
            tmp[i-1] = (new ImageIcon(url)).getImage();
        }
        return tmp;
    }

    public void update() {
        for (Component component : components) {
            component.control();
        }
    }

    public void render(Graphics gr) {
        if (renderComponent != null) {
            renderComponent.render(gr);
        }
    }
}
