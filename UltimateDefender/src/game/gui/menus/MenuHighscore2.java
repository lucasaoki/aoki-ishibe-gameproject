/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuHighscore2.java
 *
 * Created on Nov 21, 2011, 9:08:22 AM
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Seiji
 */
public class MenuHighscore2 extends StatePanel implements ActionListener, KeyListener {

    int choice = 0;
    private GameContainer gc = null;
    private String linha = null;
    private int i = 1;
    private File Arq = null;
    private BufferedReader bReader = null;
    private FileReader fReader = null;

    /** Creates new form MenuHighscore2 */
    public MenuHighscore2(GameContainer gc) {
        super(gc);

        initComponents();
        this.gc = gc;

        entities.add(new Entity("Background"));
        getEntity("Background").addComponent(new ImageRenderComponent("bGround", "/images/backgrounds/basicbackground.jpg"));

        backButton.setSelected(true);
        backButton.addActionListener(this);
        backButton.addKeyListener(this);
//        showHighScore();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        TitleScore = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextHigh = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(640, 480));

        backButton.setText("jButton1");
        backButton.setPreferredSize(new java.awt.Dimension(100, 50));

        TitleScore.setFont(new java.awt.Font("AR JULIAN", 0, 36)); // NOI18N
        TitleScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleScore.setText("Score");

        JTextHigh.setColumns(20);
        JTextHigh.setEditable(false);
        JTextHigh.setFont(new java.awt.Font("AR JULIAN", 0, 24)); // NOI18N
        JTextHigh.setLineWrap(true);
        JTextHigh.setRows(5);
        JTextHigh.setAutoscrolls(false);
        jScrollPane1.setViewportView(JTextHigh);
        JTextHigh.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(TitleScore))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleScore, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTextHigh;
    private javax.swing.JLabel TitleScore;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /*
     * Método que extrai de um arquivo o nome do personagem e o quantantidades de pontos(highscore).
     * Retornando uma String com todos s nome e valores.
     */
  
    
    
//    public void Score(int score, String character) {
//        
//        ObjectInputStream in = null;
//        ObjectOutputStream out = null;
//        int i = 0;
//        try {
//            Packhigh[] arrayPack = new Packhigh[10];
//            File arquivo = new File("Highscore.objs");
//            in = new ObjectInputStream(new FileInputStream(arquivo));
//            out = new ObjectOutputStream(new FileOutputStream(arquivo));
//            arrayPack = (Packhigh[]) in.readObject();
//            while (i < 10) {
//                if (arrayPack[i].getScore() <= score) {
//                    arrayPack[i].setScore(score, character);
//                }
//                i++;
//            }
//            out.writeObject(arrayPack);
//
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                in.close();
//                out.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    public void showHighScore() {
//        ObjectInputStream in = null;
//        int i = 0;
//        try {
//            Packhigh[] arrayPack = new Packhigh[10];
//            File arquivo = new File("Highscore.objs");
//            if (!arquivo.exists()) {
//                arquivo.createNewFile();
//            }
//            in = new ObjectInputStream(new FileInputStream(arquivo));
//
//            arrayPack = (Packhigh[]) in.readObject();
//            while (i < 10) {
//                arrayPack[i].getScore();
//                i++;
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                in.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == backButton) {
            gc.setGameState(GameContainer.State.MENUSTATE);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyTyped = e.getKeyCode();
        if (keyTyped == KeyEvent.VK_ENTER) {
            if (backButton.isSelected()) {
                backButton.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
