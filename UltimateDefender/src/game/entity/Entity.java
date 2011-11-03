/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.Component;
import game.component.render.RenderComponent;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class Entity {

    String id;
    Point position;
    float scale;
    AffineTransform af;
    RenderComponent renderComponent = null;
    ArrayList<Component> components = null;

    public Entity(String id) {
        this.id = id;
        components = new ArrayList<Component>();
        position = new Point(0, 0);
        scale = 1;
        af = new AffineTransform();
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

    public AffineTransform getAf() {
        return af;
    }

    public float getScale() {
        return scale;
    }

    public void setPosition(Point position) {
        this.position = position;
        af.translate(-af.getTranslateX() + position.x, -af.getTranslateY()+ position.y);
    }

    public void setAf(AffineTransform af) {
        this.af = af;
    }

//
//    public Image[] readFrames(String path, int num) {
//        Image tmp[] = new Image[num];
//        for (int i = 1; i <= num; i++) {
//            String filename = path + i + ".png";
//            URL url = Entity.class.getResource(filename);
//            tmp[i - 1] = (new ImageIcon(url)).getImage();
//        }
//        return tmp;
//    }
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
