/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.windows;

import gui.panel.MenuPanel;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author gilvolpe
 */
public class MainWindow extends Window implements ActionListener {

    public MainWindow() throws HeadlessException, IOException, UnsupportedLookAndFeelException {
        super();
        Container cp = this.getContentPane();
        pPrincipal = new MenuPanel();
        cp.add(pPrincipal);
       
        this.pack();
        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
    
    }


    public static void main(String[] args) throws HeadlessException, IOException, UnsupportedLookAndFeelException {
        MainWindow MW = new MainWindow();
//        MW.setVisible(true);
        
        
    }

    private MenuPanel pPrincipal = null;
}
