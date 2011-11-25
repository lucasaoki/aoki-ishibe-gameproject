package game.gui.menus;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Seiji
 */
public class Packhigh implements Serializable {

    private int score = 0;
    private String character = "----------";

    public Packhigh() {
    }

    public int getScore() {
        return score;
    }

        public String getChar() {
        return character;
    }

    public void setScore(int score, String character) {
        this.score = score;
        this.character = character;
    }

    public void setScore(Packhigh pack) {
        this.score = pack.getScore();
        this.character = pack.getChar();
    }
}
