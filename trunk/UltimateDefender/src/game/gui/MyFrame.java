/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        super("Ultimate Defender");
        setSize(800, 600);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container cpanel = getContentPane();
        cpanel.add(new MyPanel());
    }
}
