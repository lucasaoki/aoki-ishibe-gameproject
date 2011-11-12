/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.render.AnimationRenderComponent;
import game.gui.GamePanel;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class Zoro extends Chars {

    public Zoro(String id, GamePanel panel) {
        super(id);
        this.panel = panel;

        images = new Image[9][];
        images[getMoveIndex("ATTACK")] = readFrames("ATTACK", 6);
        images[getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[getMoveIndex("FALL")] = readFrames("FALL", 11);
        images[getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[getMoveIndex("JUMP")] = readFrames("JUMP", 6);
        images[getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 7);
        images[getMoveIndex("WALK")] = readFrames("WALK", 8);

        setPosition(new Point(500, 200));
        this.zoroInfo = new CharacterInfo("ZoroInfo");
        this.addComponent(zoroInfo);
        this.addComponent(new AnimationRenderComponent("ZoroRender", panel, zoroInfo, images));
    }
    private GamePanel panel;
    Image images[][];
    private CharacterInfo zoroInfo;
}
