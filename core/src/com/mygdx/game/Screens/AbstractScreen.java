package com.mygdx.game.Screens;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.mygdx.game.MyGdxGame;

public abstract class AbstractScreen implements Screen {
    protected final MyGdxGame game;
    private InputMultiplexer inputMultiplexer;
    private ScreenInputHandler screenInputHandler;

    public AbstractScreen(MyGdxGame game) {
        this.game = game;
        createInputHandlers();
    }

    private void createInputHandlers() {
        inputMultiplexer = new InputMultiplexer();
        screenInputHandler = new ScreenInputHandler(game);
        inputMultiplexer.addProcessor(screenInputHandler);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        try {
            Gdx.gl.glClearColor(0.5f, 0.1f, 0.1f, 1);
            Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        } catch (Exception e) {
            // Add error handling here, e.g. logging the exception
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }

    public ScreenInputHandler getScreenInputHandler() {
        return screenInputHandler;
    }
}