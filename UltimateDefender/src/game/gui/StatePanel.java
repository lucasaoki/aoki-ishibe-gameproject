/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.entity.Entity;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/*
 * Painel de Estado padrão para os outros paineis
 * Esta carrega as entidades de cada painel
 * @author Lucas Aoki
 */
public class StatePanel extends JPanel implements KeyListener {

    protected ArrayList<Entity> entities = null;
    GameContainer gc = null;

    public StatePanel(GameContainer gc) {
        entities = new ArrayList<>();
        this.gc = gc;
        addKeyListener(this);
    }

    /**
     * Retorna entidade desejada
     * @param id
     * id da entidade desejada
     * @return 
     * Retorna a identidade
     */
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyTyped = e.getKeyCode();
        if (keyTyped == KeyEvent.VK_ESCAPE) {
            gc.pauseGame();
            int op = JOptionPane.showConfirmDialog(this, "Deseja retornar ao menu inicial?", "Retornar?", JOptionPane.OK_CANCEL_OPTION);
            if (op == 0) {
                gc.unPause();
                gc.setGameState(GameContainer.State.MENUSTATE);
            } else {
                gc.unPause();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
