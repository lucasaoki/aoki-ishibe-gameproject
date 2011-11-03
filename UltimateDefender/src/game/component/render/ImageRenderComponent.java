/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
    public void render(Graphics2D gr) {
        AffineTransform af = owner.getAf();

        gr.drawImage(image, af, null);
    }

    @Override
    public void update() {
    }
}
