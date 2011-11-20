/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.entity.Entity;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
/*
 *
 * @author Lucas Aoki
 */

public class StatePanel extends JPanel {

    protected ArrayList<Entity> entities = null;

    public StatePanel(int width, int height) {
        entities = new ArrayList<>();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(255, 255, 255, 0));
    }

    protected Entity getEntity(String id) {
        for (Entity entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gr2d = (Graphics2D) g;

        for (Entity entity : entities) {
            entity.render(gr2d);
        }
        repaint();
    }

    public JToggleButton ButtonConf(String string, int width, int heigth) {
        JToggleButton button = new JToggleButton(string);
        button.setPreferredSize(new Dimension(width, heigth));
        return button;
    }
}
