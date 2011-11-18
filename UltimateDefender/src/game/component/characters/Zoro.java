/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.controller.PlayerCtrl;
import game.component.render.AnimationRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class Zoro extends Entity {

    public Zoro(String id, GameContainer gc, PlayerCtrl playerCtrl) {
        super(id);

        images = new Image[9][];
        images[Chars.getMoveIndex("ATTACK")] = readFrames("ATTACK", 6);
        images[Chars.getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[Chars.getMoveIndex("FALL")] = readFrames("FALL", 11);
        images[Chars.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[Chars.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[Chars.getMoveIndex("JUMP")] = readFrames("JUMP", 6);
        images[Chars.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[Chars.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 7);
        images[Chars.getMoveIndex("WALK")] = readFrames("WALK", 8);

        setPosition(new Point(500, 200));
        gc.getGameframe().addKeyListener(playerCtrl);
        this.zoroInfo = new CharacterInfo("ZoroInfo", playerCtrl);
        this.addComponent(playerCtrl);
        this.addComponent(zoroInfo);
        this.addComponent(new AnimationRenderComponent("ZoroRender", gc, zoroInfo, images));
    }
    Image images[][];
    private CharacterInfo zoroInfo;
}
