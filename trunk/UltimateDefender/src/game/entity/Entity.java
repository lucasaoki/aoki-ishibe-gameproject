/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.Component;
import game.component.characters.Chars;
import game.component.render.RenderComponent;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class Entity {

    String id;
    Point position;
    float scale;
    RenderComponent renderComponent = null;
    ArrayList<Component> components = null;

    public Entity(String id) {
        this.id = id;
        components = new ArrayList<Component>();
        position = new Point(0, 0);
        scale = 1;
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

    public float getScale() {
        return scale;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    public Image[] readFrames(String move, int num) {
        Image tmp[] = new Image[num];
        for (int i = 1; i <= num; i++) {
            String filename = "/images/" + this.getId() + "/" + move + " (" + i + ").png";
            URL url = Chars.class.getResource(filename);
            tmp[i - 1] = (new ImageIcon(url)).getImage();
        }
        return tmp;
    }

    public void update(JFrame myFrame) {
        for (Component component : components) {
            component.update();
        }
    }

    public void render(Graphics2D gr) {
        if (renderComponent != null) {
            renderComponent.render(gr);
        }
    }
}
