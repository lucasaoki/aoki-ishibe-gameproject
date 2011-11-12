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
public class Hiei extends Chars {

    public Hiei(String id, GamePanel panel) {
        super(id);
        this.panel = panel;

        images = new Image[9][];
        images[getMoveIndex("ATTACK")] = readFrames("ATTACK", 5);
        images[getMoveIndex("DASH")] = readFrames("DASH", 3);
        images[getMoveIndex("FALL")] = readFrames("FALL", 12);
        images[getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[getMoveIndex("JUMP")] = readFrames("JUMP", 8);
        images[getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 6);
        images[getMoveIndex("WALK")] = readFrames("WALK", 8);

        setPosition(new Point(300, 200));
        this.hieiInfo = new CharacterInfo("HieiInfo");
        this.addComponent(hieiInfo);
        this.addComponent(new AnimationRenderComponent("HieiRender", panel, hieiInfo, images));
    }
    private GamePanel panel;
    Image images[][];
    private CharacterInfo hieiInfo;
}
