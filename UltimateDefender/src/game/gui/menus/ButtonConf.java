/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.gui.menus;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Seiji
 */
public class ButtonConf extends JButton {
    
    JButton Button = null;

    public JButton ButtonConf(String string, int width, int heigth) {
        Button = new JButton(string);
        Button.setPreferredSize(new Dimension(width, heigth));
        return Button;
    }

    public JButton ButtonConf(String string) {

        Button.setRequestFocusEnabled(false);
        Button = new JButton(string);
        return Button;
    }
}
