/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.controller.PlayerCtrl;
import game.component.render.AnimationRenderComponent;
import game.entity.Entity;
import game.gui.GamePanel;
import game.gui.GamePlay;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Lucas
 */
public class Ichigo extends Entity {

    public Ichigo(String id, GamePlay gameframe, PlayerCtrl playerCtrl) {
        super(id);
        this.panel = panel;

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

        setPosition(new Point(400, 200));
        gameframe.addKeyListener(playerCtrl);
        this.ichigoInfo = new CharacterInfo("IchigoInfo", playerCtrl);
        this.addComponent(playerCtrl);
        this.addComponent(ichigoInfo);
        this.addComponent(new AnimationRenderComponent("IchigoRender", gameframe, ichigoInfo, images));
    }
    private GamePanel panel;
    Image images[][];
    private CharacterInfo ichigoInfo;
}
