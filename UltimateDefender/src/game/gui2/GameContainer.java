/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui2;

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

        gamepanel = new GamePanel(this);
        gameframe.getContentPane().add(gamepanel);
        
        gameframe.setVisible(true);
    }

    public JFrame getGameframe() {
        return gameframe;
    }

    public GamePanel getGamepanel() {
        return gamepanel;
    }
    
    private String id;
    private JFrame gameframe;
    private GamePanel gamepanel;
}