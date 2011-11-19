/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panel;

import game.entity.Entity;
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
public class HighScorePanel extends BasicPanel {

    private JTextArea HighScore = new JTextArea(10, 20);
    private ArrayList<Entity> entities = null;
    private File Arq = new File("NaoSei.txt");
    private BufferedReader bReader = null;
    private String linha = null;
    private int i = 1;

    public HighScorePanel(int width, int height) throws FileNotFoundException, IOException {
        super(width, height);


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
            fReader.close();
        }
    }


    public void confArea(JTextArea Area, String texto) {
        Area.setLineWrap(true);
        Area.setEditable(false);
        Area.setBackground(new Color(255, 255, 255, 0));
        Area.getSelectedTextColor();
        Area.setFont(new Font("TimesRoman", Font.BOLD , 24));

        HighScore.setText(texto);
    }
}
