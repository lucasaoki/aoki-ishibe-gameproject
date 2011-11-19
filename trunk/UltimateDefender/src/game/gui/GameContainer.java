/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.stages.Stage;
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
        try {
            mainFrame = new JFrame(id);
            mainFrame.setSize(640, 480);
            mainFrame.setLocation(200, 200);
            mainFrame.setResizable(false);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            cp = mainFrame.getContentPane();
            setGameState(GameContainer.State.GAMESTATE);

            mainFrame.setVisible(true);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public StatePanel getMainPanel() {
        return mainPanel;
    }

    public Stage getStageSelected() {
        return stageSelected;
    }

    public void setStageSelected(Stage stageSelected) {
        this.stageSelected = stageSelected;
    }

    public void setMainPanel(StatePanel mainPanel) {
        this.mainPanel = mainPanel;
        this.mainPanel.setFocusable(true);
    }

    public void setGameState(State state) throws FileNotFoundException, IOException {
        cp.removeAll();
        switch (state) {
            case MENUSTATE:
                cp.add(new MenuPanel(this));
                break;
            case PLAYERSELECT:
                cp.add(new PlayerSelectPanel(this));
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

        cp.validate();
    }

    public enum State {

        MENUSTATE, PLAYERSELECT, GAMESTATE, HIGHSTATE, CREDITS;
    }
    private String id;
    private JFrame mainFrame = null;
    private StatePanel mainPanel = null;
    private Container cp = null;
    private Stage stageSelected = null;
}