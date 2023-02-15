package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Screens.*;


public class MyGdxGame extends Game implements ScreenManager {
	private AbstractScreen currentScreen;

	@Override
	public void setScreen(AbstractScreen screen) {
		currentScreen = screen;
	}

	@Override
	public void create() {
		currentScreen = new StartScreen(this);
	}

	@Override
	public void render() {
		currentScreen.render(Gdx.graphics.getDeltaTime());
		
		if (currentScreen.isDone()) {
			currentScreen.dispose();

			if (currentScreen instanceof StartScreen) {
				setScreen(new GamePlayScreen(this));

			} else {
				if (currentScreen instanceof GamePlayScreen) {
					setScreen(new MainMenu(this));
				} 
			}
		}
	}

	@Override
	public void dispose() {
		currentScreen.dispose();
	}
}
