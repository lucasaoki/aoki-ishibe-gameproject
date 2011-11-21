/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.render;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Classe do componente de renderização de imagem estática
 * @author Lucas
 */
public class ImageRenderComponent extends RenderComponent {

    private Image image;
    String path;
    
    /**
     * @param id
     * Id para a componente
     * @param imagePath 
     * Path para a imagem a ser renderizada
     */
    public ImageRenderComponent(String id, String imagePath) {
        super(id);
        this.path = imagePath;

        URL url = ImageRenderComponent.class.getResource(imagePath);
        image = (new ImageIcon(url)).getImage();
    }

    /**
     * Função de render da componente
     */
    @Override
    public void render(Graphics2D gr) {
        AffineTransform af = new AffineTransform();
        Point pos = owner.getPosition();
        af.translate(pos.getX(), pos.getY());
        gr.drawImage(image, af, null);
    }

    @Override
    public void update() {
    }
}
