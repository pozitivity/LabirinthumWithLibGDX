package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Core;
import com.mygdx.game.util.Resolution;

public class DesktopLauncher {

	private static final Boolean FULLSCREEN = false;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		setConfig(Resolution.HD.getWidth(),
				Resolution.HD.getHeight(),
				FULLSCREEN,
				"Labirinthum",
				true,
				config);

		new LwjglApplication(new Core(), config);
	}

	private static void setConfig(Integer width, Integer height, Boolean fullscreen, String title, Boolean useGL3, LwjglApplicationConfiguration config) {
		config.height = height;
		config.width = width;
		config.useGL30 = useGL3;
		config.title = title;
		config.fullscreen = fullscreen;
	}
}
