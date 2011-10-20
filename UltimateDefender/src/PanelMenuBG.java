/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author ishibers
 */
public class PanelMenuBG extends JPanel {

    public PanelMenuBG() {


        setBackground(Color.BLACK);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        Image image1 = ImageReader.read("/BG.jpg");
        g.drawImage(image1, 0, 0, this);

    }
    /**
     *
     * @author fernando
     */
}
