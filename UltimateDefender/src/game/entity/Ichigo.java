/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.characters.CharacterInfo;
import game.component.characters.Chars;
import game.component.controller.PlayerCtrl;
import game.component.render.AnimationRenderComponent;
import game.gui.GameContainer;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Lucas
 */
public class Ichigo extends Entity {

    public Ichigo(String id, GameContainer gc, PlayerCtrl playerCtrl) {
        super(id);

        images = new Image[9][];
        images[Chars.getMoveIndex("ATTACK")] = readFrames("ATTACK", 6);
        images[Chars.getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[Chars.getMoveIndex("FALL")] = readFrames("FALL", 11);
        images[Chars.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[Chars.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[Chars.getMoveIndex("JUMP")] = readFrames("JUMP", 9);
        images[Chars.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[Chars.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 9);
        images[Chars.getMoveIndex("WALK")] = readFrames("WALK", 8);

        setPosition(new Point(400, 335));
        gc.getMainFrame().addKeyListener(playerCtrl);
        this.ichigoInfo = new CharacterInfo("IchigoInfo", playerCtrl);
        this.addComponent(playerCtrl);
        this.addComponent(ichigoInfo);
        this.addComponent(new AnimationRenderComponent("IchigoRender", gc, ichigoInfo, images));
    }
    Image images[][];
    private CharacterInfo ichigoInfo;
}
