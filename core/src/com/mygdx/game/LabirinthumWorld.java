package com.mygdx.game;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.mygdx.game.UI.LabirinthumUI;
import com.mygdx.game.systems.RenderSystem;
import com.mygdx.game.util.Resolution;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;


public class LabirinthumWorld {

	private static final float FOV = 67F;

	private LabirinthumUI labirinthumUI;

	private ModelBatch modelBatch;
	private Environment environment;
	private PerspectiveCamera perspectiveCamera;
	private Engine engine;
	private Entity character;



	public LabirinthumWorld(LabirinthumUI labirinthumUI) {
		this.labirinthumUI = labirinthumUI;

		initEnvironment();
		initModelBatch();
		initPersCamera();
		addSystems();
	}

	private void initEnvironment() {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.3f, 0.3f, 0.3f, 1.f));
	}

	private void initPersCamera() {
		perspectiveCamera = new PerspectiveCamera(FOV, Resolution.HD.getWidth(), Resolution.HD.getHeight());
//        perspectiveCamera.position.set(30f, 40f, 30f);
//        perspectiveCamera.lookAt(0, 0, 0);
//        perspectiveCamera.near = 1f;
//        perspectiveCamera.far = 300f;
//        perspectiveCamera.update();
	}

	private void initModelBatch() {
		modelBatch = new ModelBatch();
	}

	private void addSystems() {
		engine = new Engine();
		engine.addSystem(new RenderSystem(modelBatch, environment));
	}

	public void render(float delta) {
		renderWorld(delta);
	}

	protected void renderWorld(float delta) {
		modelBatch.begin(perspectiveCamera);
		engine.update(delta);
		modelBatch.end();

	}

	public void resize(int width, int height) {
		perspectiveCamera.viewportHeight = height;
		perspectiveCamera.viewportWidth = width;

	}

	public void dispose() {
		modelBatch.dispose();

		modelBatch = null;
	}

	public void remove(Entity entity) {
		engine.removeEntity(entity);
	}

}
