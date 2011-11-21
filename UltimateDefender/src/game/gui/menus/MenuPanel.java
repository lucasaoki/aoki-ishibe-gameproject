/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuPanel2.java
 *
 * Created on Nov 20, 2011, 11:57:52 AM
 */
package game.gui.menus;

import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import game.gui.StatePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Seiji
 */
public class MenuPanel extends StatePanel implements ActionListener, KeyListener {

    int choice = 0;
    GameContainer gc = null;

    /** Creates new form MenuPanel2 */
    public MenuPanel(GameContainer gc) {
        super(640, 480);
        initComponents();
        this.gc = gc;

        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("bGround", "/BG5.jpg"));

        gc.getMainFrame().addKeyListener(this);
        Start.setSelected(true);
        Start.addActionListener(this);
        Highscore.addActionListener(this);
        Credits.addActionListener(this);
        Exit.addActionListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Start = new javax.swing.JToggleButton();
        Highscore = new javax.swing.JToggleButton();
        Credits = new javax.swing.JToggleButton();
        Exit = new javax.swing.JToggleButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(640, 480));

        Start.setText("Start");
        Start.setFocusable(false);
        Start.setPreferredSize(new java.awt.Dimension(125, 50));

        Highscore.setText("Highscore");
        Highscore.setFocusable(false);
        Highscore.setPreferredSize(new java.awt.Dimension(100, 25));

        Credits.setText("Credits");
        Credits.setFocusable(false);
        Credits.setPreferredSize(new java.awt.Dimension(100, 25));

        Exit.setText("Exit");
        Exit.setToolTipText("");
        Exit.setFocusable(false);
        Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Exit.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Highscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(Start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(245, 245, 245))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Highscore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Credits;
    private javax.swing.JToggleButton Exit;
    private javax.swing.JToggleButton Highscore;
    private javax.swing.JToggleButton Start;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void setChoice() {
        switch (choice) {
            case 0:
                Start.setSelected(true);
                Highscore.setSelected(false);
                Credits.setSelected(false);
                Exit.setSelected(false);
                break;
            case 1:
                Start.setSelected(false);
                Highscore.setSelected(true);
                Credits.setSelected(false);
                Exit.setSelected(false);
                break;
            case 2:
                Start.setSelected(false);
                Highscore.setSelected(false);
                Credits.setSelected(true);
                Exit.setSelected(false);
                break;
            case 3:
                Start.setSelected(false);
                Highscore.setSelected(false);
                Credits.setSelected(false);
                Exit.setSelected(true);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == Start) {
            gc.setGameState(GameContainer.State.PLAYERSELECT);
        } else if (obj == Credits) {
            gc.setGameState(GameContainer.State.CREDITS);
        } else if (obj == Highscore) {
            gc.setGameState(GameContainer.State.HIGHSTATE);
        } else if (obj == Exit) {
            System.exit(0);
        }
        setChoice();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyTyped = e.getKeyCode();
        if (keyTyped == KeyEvent.VK_S) {
            if (choice < 4) {
                choice++;
            }
        }
        if (keyTyped == KeyEvent.VK_W) {
            if (choice > 0) {
                choice--;
            }
        }
        if (keyTyped == KeyEvent.VK_ENTER) {
            if (Start.isSelected()) {
                Start.doClick();
            } else if (Exit.isSelected()) {
                Exit.doClick();
            } else if (Credits.isSelected()) {
                Credits.doClick();
            } else if (Highscore.isSelected()) {
                Highscore.doClick();
            }
        }
        setChoice();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}