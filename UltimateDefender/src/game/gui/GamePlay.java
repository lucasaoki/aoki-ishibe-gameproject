/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui;

import game.component.characters.CharacterInfo;
import game.entity.Entity;
import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author Lucas Aoki
 */
public class GamePlay extends JFrame {

    private Entity player;
    
    public GamePlay() {
        super("Ultimate Defender");
        setSize(640, 480);
        setLocation(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(new MyPanel());

        player = new Entity("player");
        player.addComponent(new CharacterInfo("player movement"));
        player.setPosition(new Point(100, 100));
        
        this.setVisible(true);
    }
}
