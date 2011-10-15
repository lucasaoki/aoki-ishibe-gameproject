package game;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import game.states.Constants;
import game.states.GamePlayState;
import game.states.MainMenuState;

/**
 *
 * @author Lucas Aoki
 */
public class Game extends StateBasedGame implements Constants {
    
    public Game() throws SlickException {
        super("Wooooooooooooooooooooooooo");

        this.addState(new MainMenuState(MAINMENUSTATE));
        this.addState(new GamePlayState(GAMEPLAYSTATE));
        this.enterState(GAMEPLAYSTATE); ///////////////////////////////////////////
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(MAINMENUSTATE).init(gc, this);
        this.getState(GAMEPLAYSTATE).init(gc, this);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appgc = new AppGameContainer(new Game());
        appgc.setVSync(true);
        appgc.setDisplayMode(800, 600, false);
        appgc.start();
    }
}
