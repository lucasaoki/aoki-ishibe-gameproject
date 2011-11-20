/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

/**
 *
 * @author Seiji
 */
public class GameBoard extends StatePanel {
    
   private  StatePanel PanelWest = new StatePanel(100, 100);
   private  StatePanel PanelNorth = new StatePanel(10,40);
   private StatePanel PanelCenter = new StatePanel(100,100);
   JTextArea Score = new JTextArea("  asdasdads");
   JTextArea HP = new JTextArea();
   
         
   
    public GameBoard(GameContainer cp) {
        super(640,100);
         entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("BGImage", "/Score2.jpg"));
        this.setLayout(new BorderLayout());
        this.add(PanelNorth,BorderLayout.NORTH);
        this.add(PanelCenter,BorderLayout.CENTER);
        Score.grabFocus();
        Score.setEditable(false);
//        Score.setText("   ");
        PanelCenter.add(Score);
        
        
    }
    
}
