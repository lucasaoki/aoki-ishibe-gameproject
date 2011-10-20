/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author ishibers
 */
public class Menu extends JFrame {

    public Menu() {
        setTitle("Ultimate defender");
        setSize(1024, 768);
        setLocation(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentpanel = getContentPane();
        contentpanel.add(new PanelButtons());



    }

    public static void main(String[] args) {
        JFrame menu = new Menu();
        menu.setVisible(true);
    }
}
