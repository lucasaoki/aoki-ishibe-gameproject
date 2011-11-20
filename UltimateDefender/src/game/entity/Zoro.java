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
public class Zoro extends Entity {

    public Zoro(GameContainer gc, PlayerCtrl playerCtrl) {
        super("Zoro");

        images = new Image[10][];
        images[CharsMoves.getMoveIndex("ATTACK")] = readFrames("ATTACK", 6);
        images[CharsMoves.getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[CharsMoves.getMoveIndex("FALL")] = readFrames("FALL", 11);
        images[CharsMoves.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[CharsMoves.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[CharsMoves.getMoveIndex("JUMP")] = readFrames("JUMP", 6);
        images[CharsMoves.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[CharsMoves.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 7);
        images[CharsMoves.getMoveIndex("WALK")] = readFrames("WALK", 8);
        images[CharsMoves.getMoveIndex("LOSE")] = readFrames("LOSE", 5);       

        setPosition(new Point(500, 335));
        setColisionBox(new Rectangle(new Point(getPosition().x + 20, getPosition().y), new Dimension(64, 64)));
        gc.getMainPanel().addKeyListener(playerCtrl);
        gc.getStageSelected().addEntity(this);
        this.zoroInfo = new CharacterInfo("ZoroInfo", playerCtrl, gc.getStageSelected());
        this.addComponent(playerCtrl);
        this.addComponent(zoroInfo);
        this.addComponent(new AnimationRenderComponent("ZoroRender", gc, zoroInfo, images));
    }
    Image images[][];
    private CharacterInfo zoroInfo;
}
