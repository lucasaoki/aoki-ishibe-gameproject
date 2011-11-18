/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import java.awt.Container;
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
        setGameState(GameContainer.State.GAMESTATE);

        gameframe.setVisible(true);
    }

    public JFrame getGameframe() {
        return gameframe;
    }

    public GamePanel getGamepanel() {
        return gamepanel;
    }
    
    public void setGameState(State state){
        cp.removeAll();
        switch(state){
            case MENUSTATE:
//                cp.add(new GameMenu());
                break;
            case GAMESTATE:
                cp.add(new GamePanel(this));
                break;
        }
        gameframe.validate();
    }

    public enum State {

        MENUSTATE, GAMESTATE;
    }
    
    private String id;
    private JFrame gameframe;
    private GamePanel gamepanel;
    private Container cp;
}
