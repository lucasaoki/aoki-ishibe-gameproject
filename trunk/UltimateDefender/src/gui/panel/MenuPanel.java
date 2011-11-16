/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import game.component.render.ImageRenderComponent;
import java.awt.Graphics;
import java.util.ArrayList;
import game.entity.Entity;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    private ArrayList<Entity> entities = null;

    public MenuPanel() {
        super();
        entities = new ArrayList<>();

        entities.add(new Entity("Background"));
        getEntity("Background", entities).addComponent(new ImageRenderComponent("BGImage", "/BG.jpg"));

        this.setLayout(new BorderLayout());

        StartButtonsPanel StartButtons = new StartButtonsPanel();
        ButtonsPanel PanelButtons = new ButtonsPanel();
        
        this.add(new BasicPanel(640,150), BorderLayout.NORTH);
        this.add(StartButtons, BorderLayout.CENTER);
        this.add(PanelButtons, BorderLayout.SOUTH);
        
        
    }

    private Entity getEntity(String id, ArrayList<Entity> entities) {
        for (Entity entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    protected void paintComponent(Graphics g, ArrayList<Entity> entities) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Graphics2D gr2d = (Graphics2D) g;

        for (Entity entity : entities) {
            entity.render(gr2d);
        }
        repaint();
    }
    
    
}
