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
 * Classe do personagem do jogo.
 * @author Lucas
 */
public class Hiei extends Entity {

    public Hiei(GameContainer gc, PlayerCtrl playerCtrl) {
        super("Hiei");
        //Captura dos movimentos
        images = new Image[10][];
        images[CharsMoves.getMoveIndex("ATTACK")] = readFrames("ATTACK", 5);
        images[CharsMoves.getMoveIndex("DASH")] = readFrames("DASH", 3);
        images[CharsMoves.getMoveIndex("FALL")] = readFrames("FALL", 12);
        images[CharsMoves.getMoveIndex("GETHIT")] = readFrames("GETHIT", 4);
        images[CharsMoves.getMoveIndex("GUARD")] = readFrames("GUARD", 3);
        images[CharsMoves.getMoveIndex("JUMP")] = readFrames("JUMP", 8);
        images[CharsMoves.getMoveIndex("STAND")] = readFrames("STAND", 4);
        images[CharsMoves.getMoveIndex("ULTACTION")] = readFrames("ULTACTION", 6);
        images[CharsMoves.getMoveIndex("WALK")] = readFrames("WALK", 8);
        images[CharsMoves.getMoveIndex("LOSE")] = readFrames("LOSE", 4);
        //Inicialização e captura de componentes
        setPosition(new Point(300, 325));
        setColisionBox(new Rectangle(new Point(getPosition().x, getPosition().y+26), new Dimension(64, 80)));
        gc.getMainPanel().addKeyListener(playerCtrl);
        gc.getStageSelected().addEntity(this);
        this.hieiInfo = new CharacterInfo("HieiInfo", playerCtrl, gc.getStageSelected());
        this.addComponent(playerCtrl);
        this.addComponent(hieiInfo);
        this.addComponent(new PlayerRenderComponent("HieiRender", gc, hieiInfo, images));
    }
    private Image images[][];
    private CharacterInfo hieiInfo;
}
