/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.entity.Entity;
import game.gui.menus.MenuCredits;
import game.gui.menus.MenuHighscore2;
import game.gui.menus.MenuPanel;
import game.gui.menus.PlayerSelectionPanel;
import game.stage.Stage;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public  class GameContainer extends Thread {

    public GameContainer(String name) {
        super(name);
        this.id = name;
    }

    @Override
    public void run() {
        setGameState(GameContainer.State.MENUSTATE);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public StatePanel getMainPanel() {
        return gamePanel;
    }

    public Stage getStageSelected() {
        return stageSelected;
    }

    public void setStageSelected(Stage stageSelected) {
        this.stageSelected = stageSelected;
    }

    public void setMainPanel(GamePanel mainPanel) {
        this.gamePanel = mainPanel;
        this.gamePanel.setFocusable(true);
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Entity getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Entity playerChoice) {
        this.playerChoice = playerChoice;
    }

    public void pauseGame() {
        pause = true;
    }

    public void unPause() {
        pause = false;
    }

    public boolean isPause(){
        return pause;
    }

    public void createNewFrame() {
        mainFrame = new JFrame(id);
        mainFrame.setSize(640, 480);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width / 2 - mainFrame.getWidth() / 2, dim.height / 2 - mainFrame.getHeight() / 2);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = mainFrame.getContentPane();
        mainFrame.setVisible(true);
    }

    public void setGameState(State state) {
        if (mainFrame != null) {
            mainFrame.dispose();
        }
        createNewFrame();
        switch (state) {
            case MENUSTATE:
                cp.add(new MenuPanel(this));
                break;
            case PLAYERSELECT:
                cp.add(new PlayerSelectionPanel(this));
                break;
            case GAMESTATE:
                cp.add(new GamePlay(this));
                break;
            case HIGHSTATE:
                cp.add(new MenuHighscore2(this));
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
    private GamePanel gamePanel = null;
    private Container cp = null;
    private Stage stageSelected = null;
    private Entity playerChoice = null;
    private int choice = 0;
    private boolean pause = false;
}
