/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.entity.Entity;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class Chars extends Entity {

    public Chars(String id) {
        super(id);
    }

    public Image[] readFrames(String move, int num) {
        Image tmp[] = new Image[num];
        for (int i = 1; i <= num; i++) {
            String filename = "/images/" + this.getId() + "/" + move + " (" + i + ").png";
            URL url = Chars.class.getResource(filename);
            tmp[i - 1] = (new ImageIcon(url)).getImage();
        }
        return tmp;
    }

    public int getMoveIndex(String move) {
        int index = 0;

        if ("ATTACK".equals(move)) {
            index = 0;
        } else if ("DASH".equals(move)) {
            index = 1;
        } else if ("FALL".equals(move)) {
            index = 2;
        } else if ("GETHIT".equals(move)) {
            index = 3;
        } else if ("GUARD".equals(move)) {
            index = 4;
        } else if ("JUMP".equals(move)) {
            index = 5;
        } else if ("STAND".equals(move)) {
            index = 6;
        } else if ("ULTACTION".equals(move)) {
            index = 7;
        } else if ("WALK".equals(move)) {
            index = 8;
        }
        return index;
    }
}
