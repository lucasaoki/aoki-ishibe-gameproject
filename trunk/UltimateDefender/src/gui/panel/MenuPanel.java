/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import game.component.render.ImageRenderComponent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import game.entity.Entity;
import game.gui.GameContainer;
import game.gui.StatePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;

public class MenuPanel extends StatePanel implements KeyListener , ActionListener {
    private JButton startButton = null;
    private JButton creditsButton = null;
    private JButton exitButton = null;
    private JButton highscoreButton = null;
    private JButton button = null;
    private GameContainer gc = null;
    
    public MenuPanel(GameContainer gc) {
        this.gc = gc;
        gc.setMainPanel(this);
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/BG3.jpg"));
        
        BasicPanel PanelNorth = new BasicPanel(640, 100);
        BasicPanel PanelSouth = new BasicPanel(640, 0);
        BasicPanel PanelWest = new BasicPanel(225, 400);
        BasicPanel PanelEast = new BasicPanel(225, 400);
        BasicPanel PanelCenter = new BasicPanel(50, 100);
        
        startButton = ButtonConf("Start", 100, 25);
        creditsButton = ButtonConf("Credits", 100, 25);;
        highscoreButton = ButtonConf("Highscore", 100, 25);
        exitButton = ButtonConf("Exit", 100, 25);
        
        startButton.addActionListener(this);
        creditsButton.addActionListener(this);
        highscoreButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        startButton.addKeyListener(this);
        creditsButton.addKeyListener(this);
        highscoreButton.addKeyListener(this);
        exitButton.addKeyListener(this);
        
        PanelCenter.add(startButton);
        PanelCenter.add(creditsButton);
        PanelCenter.add(highscoreButton);
        PanelCenter.add(exitButton);
        
       this.setLayout(new BorderLayout());

        this.add(PanelEast, BorderLayout.EAST);
        this.add(PanelWest, BorderLayout.WEST);
        this.add(PanelSouth, BorderLayout.SOUTH);
        this.add(PanelNorth, BorderLayout.NORTH);
        this.add(PanelCenter, BorderLayout.CENTER);
    }

    public JButton ButtonConf(String string, int width, int heigth) {
        button = new JButton(string);
        button.setPreferredSize(new Dimension(width, heigth));
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == startButton) {
            try {
                gc.setGameState(GameContainer.State.GAMESTATE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (obj == creditsButton) {
            try {
                gc.setGameState(GameContainer.State.CREDITS);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (obj == highscoreButton) {
            try {
                gc.setGameState(GameContainer.State.HIGHSTATE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (obj == exitButton) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
           int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_DOWN) {
                if(startButton.isFocusOwner()){
                   
                    creditsButton.grabFocus();
                }else if(creditsButton.isFocusOwner()){
                    highscoreButton.grabFocus();
                }else if(highscoreButton.isFocusOwner()){
                    exitButton.grabFocus();
                }else if(exitButton.isFocusOwner()){
                    startButton.grabFocus();
                }
            }else if (keycode == KeyEvent.VK_UP) {
                if(startButton.isFocusOwner()){
                    exitButton.grabFocus();
                }else if(exitButton.isFocusOwner()){
                    highscoreButton.grabFocus();
                }else if(highscoreButton.isFocusOwner()){
                    creditsButton.grabFocus();
                }else if(creditsButton.isFocusOwner()){
                    startButton.grabFocus();
                }
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

  
}
