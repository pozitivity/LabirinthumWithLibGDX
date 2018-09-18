package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Core;
import com.mygdx.game.LabirinthumWorld;
import com.mygdx.game.UI.LabirinthumUI;

public class GameScreen implements Screen {

    private Core game;
    private LabirinthumWorld labirinthumWorld;
    private LabirinthumUI labirinthumUI;

    public GameScreen(Core game) {
        this.game = game;
        labirinthumUI = new LabirinthumUI(game);
        labirinthumWorld = new LabirinthumWorld(labirinthumUI);
        Gdx.input.setInputProcessor(labirinthumUI.stage);
        Gdx.input.setCursorCatched(true);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        labirinthumUI.update(delta);
        labirinthumWorld.render(delta);

        labirinthumUI.render();
    }

    @Override
    public void resize(int width, int height) {
        labirinthumUI.resize(width, height);
        labirinthumWorld.resize(width, height);

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
        labirinthumWorld.dispose();
        labirinthumUI.dispose();
    }
}
