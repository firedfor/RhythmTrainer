package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.RhythmHeaven;

public class ResultScreen implements Screen{
	
	RhythmHeaven rhythm;
	int result;
	public static int WIDTH = 737;
	public static int HEIGHT = 436;
	public static int REAL_WIDTH = (int) (WIDTH / 1.5);
	public static int REAL_HEIGHT = (int) (HEIGHT / 1.5);
	int cnt;
	
	Sound finalScene = Gdx.audio.newSound(Gdx.files.internal("finalScene.mp3"));
	Sound next = Gdx.audio.newSound(Gdx.files.internal("resultNext.mp3"));
	
	public ResultScreen(RhythmHeaven rhythm, int result) {
		this.rhythm = rhythm;
		this.result = result;
	}

	@Override
	public void show() {
		finalScene.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		rhythm.batch.begin();
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			next.play();
			rhythm.setScreen(new MenuScreen(rhythm));
		}
		
		switch(result) {
		case 0:
			rhythm.batch.draw(new Texture("resultTryagain.png"), rhythm.WIDTH / 2 - REAL_WIDTH / 2, rhythm.HEIGHT / 2 - REAL_HEIGHT / 2, REAL_WIDTH, REAL_HEIGHT);
			rhythm.batch.draw(new Texture("resultTryagainMent.png"), rhythm.WIDTH / 2 - 199 / 2, 70);
			break;
			
		case 1:
			rhythm.batch.draw(new Texture("resultOK.png"), rhythm.WIDTH / 2 - REAL_WIDTH / 2, rhythm.HEIGHT / 2 - REAL_HEIGHT / 2, REAL_WIDTH, REAL_HEIGHT);
			rhythm.batch.draw(new Texture("resultOKMent.png"), rhythm.WIDTH / 2 - 285 / 2, 70);
			break;
		case 2:
			rhythm.batch.draw(new Texture("resultSuperb.png"), rhythm.WIDTH / 2 - REAL_WIDTH / 2, rhythm.HEIGHT / 2 - REAL_HEIGHT / 2, REAL_WIDTH, REAL_HEIGHT);
			rhythm.batch.draw(new Texture("resultSuperbment.png"), rhythm.WIDTH / 2 - 186 / 2, 70);
			break;
		}
		
		rhythm.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
