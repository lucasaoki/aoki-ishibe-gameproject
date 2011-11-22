/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuBorder.java
 *
 * Created on Nov 20, 2011, 3:49:00 PM
 */
package game.gui;

import game.component.characters.CharacterInfo;
import game.component.render.ImageRenderComponent;
import game.entity.Entity;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Seiji
 */

/**
 * Classe que cria um JPanel com o life, o score e a foto do personagem escolhido.
 */
public class MenuBorder extends StatePanel {

    Entity mainPlayer;
    CharacterInfo charInfo;

    /** Creates new form MenuBorder */
    public MenuBorder(GameContainer gc) {
        super(gc);

        entities = new ArrayList<>();
        initComponents();
        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("bGround", "/Score3.jpg"));
        mainPlayer = gc.getPlayerChoice();
        charInfo = mainPlayer.getCharInfo();
        
        icon.setIcon(readIcon("/images/backgrounds/" + mainPlayer.getId().toLowerCase() + "select.jpg"));
    }
    
    /**
     * Método que retorna um ícone. 
     * 
     */
    
    private Icon readIcon(String path){
        URL url = ImageRenderComponent.class.getResource(path);
        return new ImageIcon(url);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        String score = ;
        score.setText(gc.getAtualScore()+"");
        charName.setText(mainPlayer.getId());
        lifeBar.setValue(charInfo.getLife()/10);
        Graphics2D gr2d = (Graphics2D) g;

        for (Entity entity : entities) {
            entity.render(gr2d);
        }
        repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lifeBar = new javax.swing.JProgressBar();
        iconPanel = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        score = new javax.swing.JTextArea();
        charName = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(640, 100));

        lifeBar.setForeground(new java.awt.Color(255, 0, 0));
        lifeBar.setToolTipText("");

        iconPanel.setPreferredSize(new java.awt.Dimension(64, 61));

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanelLayout.createSequentialGroup()
                .addComponent(icon)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanelLayout.createSequentialGroup()
                .addComponent(icon)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jScrollPane3.setHorizontalScrollBar(null);
        jScrollPane3.setWheelScrollingEnabled(false);

        score.setColumns(20);
        score.setEditable(false);
        score.setFont(new java.awt.Font("AR JULIAN", 0, 20)); // NOI18N
        score.setLineWrap(true);
        score.setRows(1);
        score.setText("0");
        score.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        score.setName(""); // NOI18N
        score.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(score);

        charName.setFont(new java.awt.Font("Lithos Pro Regular", 1, 14));
        charName.setForeground(new java.awt.Color(255, 0, 0));
        charName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(charName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lifeBar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addGap(287, 287, 287)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(charName, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lifeBar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(181, 181, 181))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel charName;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JProgressBar lifeBar;
    private javax.swing.JTextArea score;
    // End of variables declaration//GEN-END:variables
}
