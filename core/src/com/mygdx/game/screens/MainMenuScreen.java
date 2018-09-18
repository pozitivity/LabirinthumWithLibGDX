package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Core;
import com.mygdx.game.util.Resolution;

public class MainMenuScreen implements Screen {

    private Core game;
    private Stage stage;
    private Image backgroundImage, titleImage;
    private ImageButton playButton, introButton, aboutButton, quitButton;

    private TextureAtlas buttonAtlas;
    private Skin skin;



    public MainMenuScreen(Core game) {
        this.game = game;
        stage = new Stage(new FitViewport(Resolution.HD.getWidth(), Resolution.HD.getHeight()));
        initWidgets();
        configureWidgets();
        setListeners();
    }

    private void initWidgets() {
        backgroundImage = new Image(new Texture(Gdx.files.getLocalStoragePath().concat("/core/assets/img/menu/fon.jpg")));
        titleImage = new Image(new Texture(Gdx.files.getLocalStoragePath().concat("/core/assets/img/menu/Labirinthum.png")));
        buttonAtlas = new TextureAtlas(Gdx.files.getLocalStoragePath().concat("/core/assets/img/menu/intro.png"));
        skin.addRegions(buttonAtlas);
        introButton = new ImageButton(skin);

    }

    private void configureWidgets() {

    }

    private void setListeners() {
        quitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /** Updates */
        stage.act(delta);
        /** Draw */
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
        stage.dispose();
    }
}
