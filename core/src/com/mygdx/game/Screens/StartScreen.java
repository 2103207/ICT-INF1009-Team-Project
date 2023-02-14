package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;

public class StartScreen extends AbstractScreen implements ScreenManager{
    private OrthographicCamera camera;
    private Texture backgroundTexture;
    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private ScreenInputHandler inputHandler;

    @Override
    public void setScreen(AbstractScreen screen) {
        game.setScreen(screen);
    }

    public StartScreen(final MyGdxGame game) {
        super(game);
        inputHandler = new ScreenInputHandler(game);
        final MyGdxGame finalGame = game;

        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        backgroundTexture = new Texture("start_screen_background.jpg");
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        stage = new Stage();

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        // Creating buttons
        TextButton playButton = new TextButton("Play", skin);
        playButton.setSize(200, 50);
        playButton.setPosition(
                (Gdx.graphics.getWidth() - playButton.getWidth()) / 2,
                (Gdx.graphics.getHeight() - playButton.getHeight()) / 2 + 150
        );
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // code to start the game
                game.setScreen(new GamePlayScreen(game));
            }
        });
        TextButton instructionsButton = new TextButton("Instructions", skin);
        instructionsButton.setSize(200, 50);
        instructionsButton.setPosition(
                (Gdx.graphics.getWidth() - instructionsButton.getWidth()) / 2,
                (Gdx.graphics.getHeight() - instructionsButton.getHeight()) / 2 + 50
        );
        instructionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new InstructionScreen(game));
            }
        });

        TextButton leaderboardButton = new TextButton("Leaderboard", skin);
        leaderboardButton.setSize(200, 50);
        leaderboardButton.setPosition(
                (Gdx.graphics.getWidth() - leaderboardButton.getWidth()) / 2,
                (Gdx.graphics.getHeight() - leaderboardButton.getHeight()) / 2 - 50
        );
        leaderboardButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // code to show instructions screen
                game.setScreen(new LeaderboardScreen(game));
            }
        });

        TextButton exitButton = new TextButton("Exit", skin);
        exitButton.setSize(200, 50);
        exitButton.setPosition(
                (Gdx.graphics.getWidth() - exitButton.getWidth()) / 2,
                (Gdx.graphics.getHeight() - exitButton.getHeight()) / 2 - 150
        );
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // code to show leaderboard screen
                Gdx.app.exit();
            }
        });

        stage.addActor(playButton);
        stage.addActor(exitButton);
        stage.addActor(instructionsButton);
        stage.addActor(leaderboardButton);

        InputMultiplexer multiplexer = new InputMultiplexer(stage, inputHandler);
        Gdx.input.setInputProcessor(multiplexer);
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
    public void show() {
        // called when this screen is set as the screen with game.setScreen();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {
        // called when current screen changes from this to a different screen
    }

    @Override
    public void resume() {
        // called when current screen changes back to this screen
    }

    @Override
    public void hide() {
        // called when current screen changes to another screen
    }

    @Override
    public void dispose() {
        // never called automatically
        backgroundTexture.dispose();
        batch.dispose();
        skin.dispose();
        stage.dispose();
    }
}