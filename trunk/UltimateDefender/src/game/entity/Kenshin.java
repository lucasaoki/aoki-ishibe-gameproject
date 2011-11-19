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
public class Kenshin extends Entity {

    public Kenshin(String id, GameContainer gc, PlayerCtrl playerCtrl) {
        super(id);

        images = new Image[9][];
        images[Chars.getMoveIndex("ATTACK")] = readFrames("ATTACK", 5);
        images[Chars.getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[Chars.getMoveIndex("FALL")] = readFrames("FALL", 10);
        images[Chars.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[Chars.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[Chars.getMoveIndex("JUMP")] = readFrames("JUMP", 8);
        images[Chars.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[Chars.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 6);
        images[Chars.getMoveIndex("WALK")] = readFrames("WALK", 8);
        
        setPosition(new Point(200, 335));
        setColisionBox(new Rectangle(getPosition(), new Dimension(64, 64)));
        gc.getMainPanel().addKeyListener(playerCtrl);
        gc.getStageSelected().addEntity(this);
        this.kenshinInfo = new CharacterInfo("KenshinInfo", playerCtrl, gc.getStageSelected());
        this.addComponent(playerCtrl);
        this.addComponent(kenshinInfo);
        this.addComponent(new AnimationRenderComponent("KenshinRender", gc, kenshinInfo, images));
    }
    private Image images[][];
    private CharacterInfo kenshinInfo;
}
