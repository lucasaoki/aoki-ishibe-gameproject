/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import game.component.render.ImageRenderComponent;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import game.entity.Entity;
import game.gui.GameContainer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements KeyListener , ActionListener {
    
    private ArrayList<Entity> entities = null;
    
    private JButton startButton = null;
    private JButton creditsButton = null;
    private JButton exitButton = null;
    private JButton highscoreButton = null;
    private JButton button = null;
    
    private GameContainer gc = null;
    
    public MenuPanel(GameContainer gc) {
        
        this.gc = gc;
        
        entities = new ArrayList<>();
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
    
    private Entity getEntity(String id) {
        for (Entity entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        Graphics2D gr2d = (Graphics2D) g;
        
        for (Entity entity : entities) {
            entity.render(gr2d);
        }
        repaint();
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
}
