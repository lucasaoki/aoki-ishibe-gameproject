/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author ishibers
 */
public class ImageReader {

    public static Image read(String filename) {
        URL url = ImageReader.class.getResource(filename);
        return (new ImageIcon(url)).getImage();
    }
}

