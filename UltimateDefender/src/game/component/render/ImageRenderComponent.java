/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class ImageRenderComponent extends RenderComponent {

    private Image image;
    String path;

    public ImageRenderComponent(String id, String imagePath) {
        super(id);
        this.path = imagePath;

        URL url = ImageRenderComponent.class.getResource(imagePath);
        image = (new ImageIcon(url)).getImage();
    }

    @Override
    public void render(Graphics gr) {
        Point position = owner.getPosition();

        gr.drawImage(image, position.x, position.y, null);
    }

    @Override
    public void control() {
    }
}
