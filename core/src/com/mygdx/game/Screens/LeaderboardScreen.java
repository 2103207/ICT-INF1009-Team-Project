package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

public class LeaderboardScreen extends AbstractScreen implements ScreenManager {
    private OrthographicCamera camera;
    private Texture backgroundTexture;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;

    public LeaderboardScreen(final MyGdxGame game) {
        super(game);

        backgroundTexture = new Texture("start_screen_background.jpg");
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        stage = new Stage();

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton backButton = new TextButton("Back", skin);
        backButton.setSize(200, 50);
        backButton.setPosition(
                (Gdx.graphics.getWidth() - backButton.getWidth()) / 2,
                (Gdx.graphics.getHeight() - backButton.getHeight()) / 2 - 200
        );
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new StartScreen(game));
            }
        });

        stage.addActor(backButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw the background texture
        batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        // Rendering the stage
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void dispose() {
        backgroundTexture.dispose();
        batch.dispose();
        skin.dispose();
        stage.dispose();
    }

    @Override
    public void setScreen(AbstractScreen screen) {
        game.setScreen(screen);
    }
}
