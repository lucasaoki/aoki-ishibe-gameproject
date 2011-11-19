/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import gui.panel.MenuCredits;
import gui.panel.MenuHighscore;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class GameContainer extends Thread {
    private GamePanel gp;
    private PlayerSelectPanel ps;

    public GameContainer(String name) {
        super(name);
        this.id = name;
    }

    @Override
    public void run() {
        mainFrame = new JFrame(id);
        mainFrame.setSize(640, 480);
        mainFrame.setLocation(200, 200);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cp = mainFrame.getContentPane();
        try {
            setGameState(GameContainer.State.MENUSTATE);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public StatePanel getMainPanel() {
        return mainPanel;
    }

    public void setGameState(State state) throws FileNotFoundException, IOException {
        cp.removeAll();
        switch (state) {
            case MENUSTATE:
//                gamepanel = new MenuPanel(this);
                break;
            case PLAYERSELECT:
                ps = new PlayerSelectPanel(this);
//                cp.add(new PlayerSelectPanel(this));
                cp.add(ps);
                break;
            case GAMESTATE:
                gp = new GamePanel(this);
//                cp.add(new GamePanel(this));
                cp.add(gp);
                break;
            case HIGHSTATE:
                cp.add(new MenuHighscore(this));
                break;
            case CREDITS:
                cp.add(new MenuCredits(this));
                break;
        }
//        cp.add();
        cp.validate();
    }

    public enum State {

        MENUSTATE, PLAYERSELECT, GAMESTATE, HIGHSTATE, CREDITS;
    }
    private String id;
    private JFrame mainFrame = null;
    private StatePanel mainPanel = null;
    private Container cp = null;
}
