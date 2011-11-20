/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

/**
 *
 * @author Lucas
 */
public class CharsMoves {

    public static int getMoveIndex(String move) {
        int index = 0;
        switch (move) {
            case "ATTACK":
                index = 0;
                break;
            case "DASH":
                index = 1;
                break;
            case "FALL":
                index = 2;
                break;
            case "GETHIT":
                index = 3;
                break;
            case "GUARD":
                index = 4;
                break;
            case "JUMP":
                index = 5;
                break;
            case "STAND":
                index = 6;
                break;
            case "ULTACTION":
                index = 7;
                break;
            case "WALK":
                index = 8;
                break;
            case "LOSE":
                index = 9;
                break;
        }
        return index;
    }
}
