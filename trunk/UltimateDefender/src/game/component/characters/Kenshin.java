/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.controller.PlayerCtrl;
import game.component.render.AnimationRenderComponent;
import game.entity.Entity;
import game.gui.GameContainer;
import game.gui.GamePanel;
import java.awt.Image;
import java.awt.Point;

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

        setPosition(new Point(200, 200));
        gc.getGameframe().addKeyListener(playerCtrl);
        this.kenshinInfo = new CharacterInfo("KenshinInfo", playerCtrl);
        this.addComponent(playerCtrl);
        this.addComponent(kenshinInfo);
        this.addComponent(new AnimationRenderComponent("KenshinRender", gc, kenshinInfo, images));
    }
    private GamePanel panel;
    private Image images[][];
    private CharacterInfo kenshinInfo;
}
