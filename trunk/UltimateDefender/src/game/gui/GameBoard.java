/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Seiji
 */
public class GameBoard extends StatePanel {

    private StatePanel PanelWest = new StatePanel(130, 50);
    private StatePanel PanelCenter = new StatePanel(100, 100);
    private StatePanel PanelEast = new StatePanel(225, 100);
    
    private StatePanel PanelScoreWest = new StatePanel(75, 20);// Usado para posicionar o JtextArea Score.
    private StatePanel PanelScoreNorth = new StatePanel(10, 48);
    
    private StatePanel PanelHPWest = new StatePanel(0, 20);
    private StatePanel PanelHPNorth = new StatePanel(10, 29);
    private StatePanel PanelHPCenter = new StatePanel(10, 48);
    
    JTextArea Score = null;
    JTextArea HP = null;

    public GameBoard(GameContainer gc) {
        super(640, 100);

        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/Score3.jpg"));

        PanelWest.entities.add(new Entity("Background"));
        PanelWest.getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/Kenshin.jpg"));

        this.setLayout(new BorderLayout());
        this.add(PanelWest, BorderLayout.WEST);
        this.add(PanelCenter, BorderLayout.CENTER);
        this.add(PanelEast, BorderLayout.EAST);

        Score = confArea();
        HP = confArea();

        PanelCenter.setLayout(new BorderLayout());
        
        PanelCenter.add(PanelHPNorth, BorderLayout.NORTH);
        PanelCenter.add(PanelHPWest, BorderLayout.WEST);
        PanelCenter.add(HP, BorderLayout.CENTER);

        PanelEast.setLayout(new BorderLayout());
        PanelEast.add(PanelScoreNorth, BorderLayout.NORTH);
        PanelEast.add(PanelScoreWest, BorderLayout.WEST);
        PanelEast.add(Score, BorderLayout.CENTER);



    }

    public JTextArea confArea() {
        JTextArea ta = new JTextArea("wsfsfsdf");
        ta.setBackground(new Color(255, 255, 255, 0));
        ta.setForeground(Color.BLACK);
        ta.setFont(new Font("Arial", Font.BOLD, 20));
        ta.setEditable(false);
        return ta;
    }

    public JPanel Panel(int width, int height) {
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(width, height));
        return jp;
    }
}
