/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.entity.Entity;
import java.awt.Image;

/**
 *
 * @author Lucas
 */
public class Kenshin extends Entity{

    Image images[][];
    
    public Kenshin(String id) {
        super(id);
        this.addComponent(new CharacterInfo(id));
        
        images = new Image[10][];
        images[0] = new Image[5];
    }
    
//    public Image[] read(String path, int num){
//        Image tmp[] = new Image[num];
//        for (int i = 0; i < imagens.length; i++) {
//            String filename = "/images/pac" + i + ".png";
//            URL url = GuiPacman.class.getResource(filename);
//            imagens[i] = (new ImageIcon(url)).getImage();
//        }        
//    }
}
