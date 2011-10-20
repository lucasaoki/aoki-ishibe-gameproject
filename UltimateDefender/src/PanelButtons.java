/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author ishibers
 */
public class PanelButtons extends JPanel implements TimerListener {

    public PanelButtons() {

        this.add(start);
        this.add(options);
        this.add(credit);
        this.add(exit);


        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.BLACK);
        Timer t = new Timer(this, 50);
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        Image image1 = ImageReader.read("/BG.jpg");
        g.drawImage(image1, 0, 0, this);

        Image image2 = ImageReader.read("/Zoros.gif");
        g.drawImage(image2, 300, 300, this);

        Image image3 = ImageReader.read("/Ichigo.gif");
        g.drawImage(image3, 400, 400, this);

        Image image4 = ImageReader.read("/Kenshin.gif");
        g.drawImage(image4, 400, 0, this);


    }
    private JButton start = new JButton("start");
    private JButton options = new JButton("options");
    private JButton credit = new JButton("credit");
    private JButton exit = new JButton("exit");

    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
