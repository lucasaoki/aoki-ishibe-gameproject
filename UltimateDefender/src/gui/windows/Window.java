/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.windows;

import gui.panel.MenuPanel;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author gilvolpe
 */
public class Window extends JFrame {

    public Window() throws HeadlessException {
        super("Ultimate Defender");
        
        setPreferredSize(new Dimension(640, 480));
        setLocation(300, 200);
        
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
}
