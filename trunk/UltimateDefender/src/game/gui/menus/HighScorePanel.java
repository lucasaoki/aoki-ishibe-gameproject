/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui.menus;

import game.gui.StatePanel;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author Seiji
 */
public class HighScorePanel extends StatePanel {

    private JTextArea HighScore = null;
    private String linha = null;
    private int i = 1;
    private File Arq = null;
    private BufferedReader bReader = null;
    private FileReader fReader = null;

    public HighScorePanel(int width, int height) {
        super(width, height);
        try {

            Arq = new File("Highscore.txt");
            HighScore = new JTextArea(10, 20);

            add(HighScore);
            fReader = new FileReader(Arq);
            bReader = new BufferedReader(fReader);
            String texto = "";

            while ((linha = bReader.readLine()) != null) {
                texto += i + "A--";
                i++;
                texto += linha;
                texto += "\r\n";
            }
            confArea(HighScore, texto);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bReader.close();
                fReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void confArea(JTextArea Area, String texto) {

        Area.setLineWrap(true);
        Area.setEditable(false);
        Area.setBackground(new Color(255, 255, 255, 0));
        Area.getSelectedTextColor();
        Area.setFont(new Font("TimesRoman", Font.BOLD, 24));

        HighScore.setText(texto);
    }
}
