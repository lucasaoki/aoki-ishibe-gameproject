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
public class Ichigo extends Chars {

    public Ichigo(String id, GamePanel panel) {
        super(id);
        this.panel = panel;

        images = new Image[9][];
        images[getMoveIndex("ATTACK")] = readFrames("ATTACK", 6);
        images[getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[getMoveIndex("FALL")] = readFrames("FALL", 11);
        images[getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[getMoveIndex("JUMP")] = readFrames("JUMP", 9);
        images[getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 9);
        images[getMoveIndex("WALK")] = readFrames("WALK", 8);

        setPosition(new Point(400, 200));
        this.ichigoInfo = new CharacterInfo("IchigoInfo");
        this.addComponent(ichigoInfo);
        this.addComponent(new AnimationRenderComponent("IchigoRender", panel, ichigoInfo, images));
    }
    private GamePanel panel;
    Image images[][];
    private CharacterInfo ichigoInfo;
}
