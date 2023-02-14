package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.mygdx.game.MyGdxGame;

public abstract class Overlay implements Screen {
    protected final MyGdxGame game;
    private boolean visible = false;

    public Overlay(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
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
    public void dispose() {
    }

    @Override
    public void show() {
        visible = true;
    }

    @Override
    public void hide() {
        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}