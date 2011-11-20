/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.entity;

import game.component.characters.CharacterInfo;
import game.component.characters.CharsMoves;
import game.component.controller.PlayerCtrl;
import game.component.render.PlayerRenderComponent;
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

    public Kenshin(GameContainer gc, PlayerCtrl playerCtrl) {
        super("Kenshin");

        images = new Image[10][];
        images[CharsMoves.getMoveIndex("ATTACK")] = readFrames("ATTACK", 5);
        images[CharsMoves.getMoveIndex("DASH")] = readFrames("DASH", 2);
        images[CharsMoves.getMoveIndex("FALL")] = readFrames("FALL", 10);
        images[CharsMoves.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[CharsMoves.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[CharsMoves.getMoveIndex("JUMP")] = readFrames("JUMP", 8);
        images[CharsMoves.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[CharsMoves.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 6);
        images[CharsMoves.getMoveIndex("WALK")] = readFrames("WALK", 8);
        images[CharsMoves.getMoveIndex("LOSE")] = readFrames("LOSE", 5);
        
        setPosition(new Point(200, 325));
        setColisionBox(new Rectangle(new Point(getPosition().x, getPosition().y+26), new Dimension(64, 80)));
        gc.getMainPanel().addKeyListener(playerCtrl);
        gc.getStageSelected().addEntity(this);
        this.kenshinInfo = new CharacterInfo("KenshinInfo", playerCtrl, gc.getStageSelected());
        this.addComponent(playerCtrl);
        this.addComponent(kenshinInfo);
        this.addComponent(new PlayerRenderComponent("KenshinRender", gc, kenshinInfo, images));
    }
    private Image images[][];
    private CharacterInfo kenshinInfo;
}
