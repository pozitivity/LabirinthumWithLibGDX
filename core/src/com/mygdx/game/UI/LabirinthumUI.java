package com.mygdx.game.UI;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Core;
import com.mygdx.game.util.Resolution;

public class LabirinthumUI {

    private Core game;
    public Stage stage;

    public LabirinthumUI(Core game) {
        this.game = game;
        stage = new Stage(new FitViewport(Resolution.HD.getWidth(), Resolution.HD.getHeight()));
    }

    public void update(float delta) {
        stage.act(delta);
    }

    public void render() {
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    public void dispose() {
        stage.dispose();
    }
}
