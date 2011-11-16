/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import javax.swing.JFrame;

/**
 *
 * @author Lucas Aoki
 */
public class GamePlay extends JFrame {

    public GamePlay() {
        super("Ultimate Defender");
        setSize(640, 480);
        setLocation(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        getContentPane().add(new GamePanel(this));

        this.setVisible(true);
    }
}
