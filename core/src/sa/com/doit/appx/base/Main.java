package sa.com.doit.appx.base;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Main extends ApplicationAdapter {
	Stage stage;
	SpriteBatch batch;
	Image img;

	@Override
	public void create () {
		stage = new Stage();
		batch = new SpriteBatch();
		img = new Image(new Texture("badlogic.jpg"));
		img.setY(150);
		img.addAction(Actions.forever(Actions.parallel(
				Actions.sequence(Actions.moveBy(800,0,1f),Actions.moveBy(-800,0,1f)),
				Actions.rotateBy(360,2f))));
		stage.addActor(img);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();

		stage.act();
		stage.draw();
	}

	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}

}
