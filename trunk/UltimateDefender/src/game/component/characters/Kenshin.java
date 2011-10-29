/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.render.AnimationRenderComponent;
import game.entity.Entity;
import game.gui.GamePanel;
import java.awt.Image;

/**
 *
 * @author Lucas
 */
public class Kenshin extends Entity {

    private enum MovesInfo{
        B(0, "/images/kenshin/b/", 5),
        DASH(1, "/images/kenshin/dash/", 2),
        FALL(2, "/images/kenshin/fall/", 9),
        GETHIT(3, "/images/kenshin/gethit/", 4),
        GUARD(4, "/images/kenshin/guard/", 3),
        JUMP(5, "/images/kenshin/jump/", 8),
        STAND(6, "/images/kenshin/stand/", 4),
        ULTACTION(7, "/images/kenshin/ultaction/", 6),
        WALK(8, "/images/kenshin/walk/", 8);
        
        MovesInfo(int index, String path, int num){
            this.index = index;
            this.path = path;
            this.nFrames = num;
        }
        
        private int index;
        private String path;
        private int nFrames;

        public int getnFrames() {
            return nFrames;
        }

        public String getPath() {
            return path;
        }

        public int getIndex() {
            return index;
        }
    }
    
    private GamePanel panel;
    Image images[][];
    private CharacterInfo kenshinInfo;

    public Kenshin(String id, GamePanel panel) {
        super(id);
        this.panel = panel;

        images = new Image[9][];
        images[MovesInfo.B.getIndex()] = this.readFrames(MovesInfo.B.getPath(), MovesInfo.B.getnFrames());
        images[MovesInfo.DASH.getIndex()] = this.readFrames(MovesInfo.DASH.getPath(), MovesInfo.DASH.getnFrames());
        images[MovesInfo.FALL.getIndex()] = this.readFrames(MovesInfo.FALL.getPath(), MovesInfo.FALL.getnFrames());
        images[MovesInfo.GETHIT.getIndex()] = this.readFrames(MovesInfo.GETHIT.getPath(), MovesInfo.GETHIT.getnFrames());
        images[MovesInfo.GUARD.getIndex()] = this.readFrames(MovesInfo.GUARD.getPath(), MovesInfo.GUARD.getnFrames());
        images[MovesInfo.JUMP.getIndex()] = this.readFrames(MovesInfo.JUMP.getPath(), MovesInfo.JUMP.getnFrames());
        images[MovesInfo.STAND.getIndex()] = this.readFrames(MovesInfo.STAND.getPath(), MovesInfo.STAND.getnFrames());
        images[MovesInfo.ULTACTION.getIndex()] = this.readFrames(MovesInfo.ULTACTION.getPath(), MovesInfo.ULTACTION.getnFrames());
        images[MovesInfo.WALK.getIndex()] = this.readFrames(MovesInfo.WALK.getPath(), MovesInfo.WALK.getnFrames());

        kenshinInfo = new CharacterInfo("KenshinInfo");
        this.addComponent(kenshinInfo);
        this.addComponent(new AnimationRenderComponent("KenshinRender", panel, kenshinInfo, images));
    }

}
