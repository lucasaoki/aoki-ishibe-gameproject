/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui.menus;

import game.gui.GameContainer;
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
public class HighScorePanel extends StatePanel{

    private JTextArea HighScore = null;
    private String linha = null;
    private int i = 1;
    private File Arq = null;
    private BufferedReader bReader = null;
    private FileReader fReader = null;

    public HighScorePanel(GameContainer gc) {
        super(gc);
        
        Arq = new File("Highscore.txt");
        HighScore = new JTextArea(345, 365);
        try {
            fReader = new FileReader(Arq);
        } catch (FileNotFoundException ex) {
        }
        bReader = new BufferedReader(fReader);
        String texto = "";
        try {
            while ((linha = bReader.readLine()) != null) {
                texto += i + " -----";
                i++;
                texto += linha;
                texto += "\r\n";
            }
            HighScore.setLineWrap(true);
            HighScore.setEditable(false);
            HighScore.setBackground(new Color(255, 255, 255, 0));
            HighScore.setFont(new Font("TimesRoman", Font.BOLD, 24));

            HighScore.setText(texto);
            add(HighScore);
        } catch (IOException ex) {
            ex.printStackTrace();
        }




        System.out.println(texto);
        add(HighScore);
        try {
            bReader.close();
            fReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public JTextArea confArea(JTextArea Area, String texto) {

        Area.setLineWrap(true);
        Area.setEditable(false);
        Area.setBackground(new Color(255, 255, 255, 0));
        Area.setFont(new Font("TimesRoman", Font.BOLD, 24));
        Area.setText(texto);
        return Area;
    }
}
