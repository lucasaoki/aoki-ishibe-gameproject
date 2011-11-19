/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import gui.panel.MenuCredits;
import gui.panel.MenuHighscore;
import gui.panel.MenuPanel;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class GameContainer extends Thread {

    public GameContainer(String name) {
        super(name);
        this.id = name;
    }

    @Override
    public void run() {
        gameframe = new JFrame(id);
        gameframe.setSize(640, 480);
        gameframe.setLocation(200, 200);
        gameframe.setResizable(false);
        gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cp = gameframe.getContentPane();
        try {
            setGameState(GameContainer.State.MENUSTATE);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        gameframe.setVisible(true);
    }

    public JFrame getGameframe() {
        return gameframe;
    }

    public GamePanel getGamepanel() {
        return gamepanel;
    }

    public void setGameState(State state) throws FileNotFoundException, IOException {
        cp.removeAll();
        switch (state) {
            case MENUSTATE:
                cp.add(new MenuPanel(this));
                break;
            case GAMESTATE:
                cp.add(new GamePanel(this));
                break;
            case HIGHSTATE:
                cp.add(new MenuHighscore(this));
                break;
            case CREDITS:
                cp.add(new MenuCredits(this));
                break;
        }
        gameframe.validate();
    }

    public enum State {

        MENUSTATE, GAMESTATE, HIGHSTATE, CREDITS;
    }
    private String id;
    private JFrame gameframe;
    private GamePanel gamepanel;
    private Container cp;
}
