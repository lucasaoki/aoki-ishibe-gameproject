/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.characters.CharacterInfo;
import game.component.characters.CharsMoves;
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

    public Ichigo(GameContainer gc, PlayerCtrl playerCtrl) {
        super("Ichigo");

        images = new Image[10][];
        images[CharsMoves.getMoveIndex("ATTACK")] = readFrames("ATTACK", 6);
        images[CharsMoves.getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[CharsMoves.getMoveIndex("FALL")] = readFrames("FALL", 11);
        images[CharsMoves.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[CharsMoves.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[CharsMoves.getMoveIndex("JUMP")] = readFrames("JUMP", 9);
        images[CharsMoves.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[CharsMoves.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 9);
        images[CharsMoves.getMoveIndex("WALK")] = readFrames("WALK", 8);
        images[CharsMoves.getMoveIndex("LOSE")] = readFrames("LOSE", 6);

        setPosition(new Point(400, 335));
        setColisionBox(new Rectangle(getPosition(), new Dimension(64, 64)));
        gc.getMainPanel().addKeyListener(playerCtrl);
        gc.getStageSelected().addEntity(this);
        this.ichigoInfo = new CharacterInfo("IchigoInfo", playerCtrl, gc.getStageSelected());
        this.addComponent(playerCtrl);
        this.addComponent(ichigoInfo);
        this.addComponent(new AnimationRenderComponent("IchigoRender", gc, ichigoInfo, images));
    }
    Image images[][];
    private CharacterInfo ichigoInfo;
}
