/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui.menus;

import game.entity.Entity;
import game.gui.StatePanel;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Seiji
 */
public class HighScorePanel extends StatePanel {

    private JTextArea HighScore = null;
    private File Arq = null;
    private BufferedReader bReader = null;
    private String linha = null;
    private int i = 1;

    public HighScorePanel(int width, int height) throws FileNotFoundException, IOException {
        super(width, height);

        Arq = new File("Highscore.txt");
        HighScore = new JTextArea(10, 20);
        add(HighScore);
        
        try (FileReader fReader = new FileReader(Arq)) {
            bReader = new BufferedReader(fReader);
            String texto = "";

            while ((linha = bReader.readLine()) != null) {
                texto += i + "A--";
                i++;
                texto += linha;
                texto += "\r\n";
            }
            confArea(HighScore, texto);
            bReader.close();
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
