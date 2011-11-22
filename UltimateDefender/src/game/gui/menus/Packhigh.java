package game.gui.menus;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seiji
 */
public class Packhigh {
    private int score = 0;
    private String character = null;

    public Packhigh() {
    
    }
    public int getScore(){
        return score;
    }
    
    public String getChar(){
        return character;
    }
    
    public void setScore(int score, String character){
        this.score = score;
        this.character = character;
    }
    
}
