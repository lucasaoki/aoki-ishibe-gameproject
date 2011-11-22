/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import java.awt.BorderLayout;

/**
 *
 * @author Seiji
 */
/*
 * Classe 
 */
public class GamePlay extends StatePanel {

    public GamePlay(GameContainer gc) {
        super(gc);
        this.setLayout(new BorderLayout());
        this.add(new GamePanel(gc), BorderLayout.CENTER);
        this.add(new MenuBorder(gc), BorderLayout.SOUTH);
    }
}
