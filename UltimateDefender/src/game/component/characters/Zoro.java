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
public class Zoro extends Entity {

    public Zoro(String id, GamePlay gameframe, PlayerCtrl playerCtrl) {
        super(id);
        this.panel = panel;

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
        gameframe.addKeyListener(playerCtrl);
        this.zoroInfo = new CharacterInfo("ZoroInfo", playerCtrl);
        this.addComponent(playerCtrl);
        this.addComponent(zoroInfo);
        this.addComponent(new AnimationRenderComponent("ZoroRender", gameframe, zoroInfo, images));
    }
    private GamePanel panel;
    Image images[][];
    private CharacterInfo zoroInfo;
}
