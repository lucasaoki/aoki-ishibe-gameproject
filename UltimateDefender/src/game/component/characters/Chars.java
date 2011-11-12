/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

/**
 *
 * @author Lucas
 */
public class Chars {

    public static int getMoveIndex(String move) {
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
