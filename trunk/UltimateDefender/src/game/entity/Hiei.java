/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.characters.CharacterInfo;
import game.component.characters.Chars;
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
public class Hiei extends Entity {

    public Hiei(String id, GameContainer gc, PlayerCtrl playerCtrl) {
        super(id);

        images = new Image[9][];
        images[Chars.getMoveIndex("ATTACK")] = readFrames("ATTACK", 5);
        images[Chars.getMoveIndex("DASH")] = readFrames("DASH", 3);
        images[Chars.getMoveIndex("FALL")] = readFrames("FALL", 12);
        images[Chars.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[Chars.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[Chars.getMoveIndex("JUMP")] = readFrames("JUMP", 8);
        images[Chars.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[Chars.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 6);
        images[Chars.getMoveIndex("WALK")] = readFrames("WALK", 8);

        setPosition(new Point(300, 335));
        gc.getMainFrame().addKeyListener(playerCtrl);
        this.hieiInfo = new CharacterInfo("HieiInfo", playerCtrl);
        this.addComponent(playerCtrl);
        this.addComponent(hieiInfo);
        this.addComponent(new AnimationRenderComponent("HieiRender", gc, hieiInfo, images));
    }
    private Image images[][];
    private CharacterInfo hieiInfo;
}
