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
 * Container do jogo
 * Carrega as principais informações do jogo
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
 
    /**
     * Retorna o frame principal
     * @return 
     */
    public JFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * Retorna o painel principal do jogo
     * @return 
     */
    public StatePanel getMainPanel() {
        return gamePanel;
    }

    /**
     * Retorna o estágio principal
     * @return 
     */
    public Stage getStageSelected() {
        return stageSelected;
    }

    /**
     * Seta o estágio principal
     * @param stageSelected 
     */
    public void setStageSelected(Stage stageSelected) {
        this.stageSelected = stageSelected;
    }

    /**
     * Seta o painel principal
     * @param mainPanel 
     */
    public void setMainPanel(GamePanel mainPanel) {
        this.gamePanel = mainPanel;
        this.gamePanel.setFocusable(true);
    }

    /**
     * Retorna a escolha do personagem do jogador
     * @return 
     */
    public int getChoice() {
        return choice;
    }

    /**
     * Seta a escolha do jogador
     * @param choice 
     */
    public void setChoice(int choice) {
        this.choice = choice;
    }

    /**
     * Retorna a entidade escolhida pelo jogador
     * @return 
     */
    public Entity getPlayerChoice() {
        return playerChoice;
    }

    /**
     * Seta a entidade escolhida pelo jogador
     * @param playerChoice 
     */
    public void setPlayerChoice(Entity playerChoice) {
        this.playerChoice = playerChoice;
    }

    /**
     * Pausa o jogo
     */
    public void pauseGame() {
        pause = true;
    }

    /**
     * Despausa o jogo
     */
    public void unPause() {
        pause = false;
    }

    /**
     * Checa o estado do pause
     * @return 
     * Retorna se true se pausado ou false c.c.
     */
    public boolean isPause(){
        return pause;
    }

    public int getAtualScore() {
        return atualScore;
    }

    public void setAtualScore(int atualScore) {
        this.atualScore = atualScore;
    }

    public void resetScore(){
        setAtualScore(0);
    }
    /**
     * Cria o novo frame
     */
    public void createNewFrame() {
        mainFrame = new JFrame(id);
        mainFrame.setSize(640, 480);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width / 2 - mainFrame.getWidth() / 2, dim.height / 2 - mainFrame.getHeight() / 2);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp = mainFrame.getContentPane();
        mainFrame.setVisible(true);
        atualScore = 0;
    }

    /**
     * Seta o estágio
     * @param state 
     * estagio selecionado
     */
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

    /**
     * Estados do jogo
     */
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
    private int atualScore = 0;
    private boolean pause = false;
}
