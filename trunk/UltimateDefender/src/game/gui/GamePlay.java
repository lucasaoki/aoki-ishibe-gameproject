/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.gui.menus.BasicPanel;
import java.awt.BorderLayout;

/**
 *
 * @author Seiji
 */
public class GamePlay extends StatePanel{

    public GamePlay(GameContainer cp) {
        super(640,480);
        this.setLayout(new BorderLayout());
        this.add(new GamePanel(cp),BorderLayout.CENTER);
        this.add(new GameBoard(cp),BorderLayout.SOUTH);
    }
    
}
