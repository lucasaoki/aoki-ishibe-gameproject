/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.windows;

import game.gui.GameContainer;
import gui.panel.MenuPanel;
import java.awt.Container;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author gilvolpe
 */
public class MainWindow extends Window{

    public MainWindow(GameContainer gc) throws HeadlessException, IOException, UnsupportedLookAndFeelException {
        super();
        Container cp = this.getContentPane();
        pPrincipal = new MenuPanel(gc);
        cp.add(pPrincipal);
        
        this.pack();
        this.setVisible(true);
        
    }



//    public static void main(String[] args) throws HeadlessException, IOException, UnsupportedLookAndFeelException {
//        MainWindow MW = new MainWindow(gc);
//        MW.setVisible(true);
//        
//        
//    }

    private MenuPanel pPrincipal = null;
}
