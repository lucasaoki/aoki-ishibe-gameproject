
import game.gui.menus.Packhigh;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Seiji
 */
public class Score {

    public Score(int score, String character) {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        int i = 0;

        try {
            Packhigh[] arrayPack = new Packhigh[10];
            File arquivo = new File("Highscore.objs");
            in = new ObjectInputStream(new FileInputStream(arquivo));
            out = new ObjectOutputStream(new FileOutputStream(arquivo));
            arrayPack = (Packhigh[]) in.readObject();
            while (i < 10) {
                if (arrayPack[i].getScore() <= score) {
                    arrayPack[i].setScore(score, character);
                }
            }
             out.writeObject(arrayPack);
             
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }




    }
}
