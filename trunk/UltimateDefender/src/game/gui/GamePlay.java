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
public class GamePlay extends StatePanel {

    public GamePlay(GameContainer gc, int playerChoice) {
        super(640, 480);
        this.setLayout(new BorderLayout());
        this.add(new GamePanel(gc, playerChoice), BorderLayout.CENTER);
        this.add(new GameBoard(gc), BorderLayout.SOUTH);
    }
}
