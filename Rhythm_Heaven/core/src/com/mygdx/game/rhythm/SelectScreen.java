package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.RhythmHeaven;

public class SelectScreen implements Screen{
	
	RhythmHeaven rhythm;

	public static int WIDTH = 577;
	public static int HEIGHT = 814;
	public static int REAL_WIDTH = WIDTH / 2;
	public static int REAL_HEIGHT = HEIGHT / 2;
	
	Sound pokemon = Gdx.audio.newSound(Gdx.files.internal("pokemon.mp3"));
	Sound kirby = Gdx.audio.newSound(Gdx.files.internal("kirby.mp3"));
	
	public int select = 0;
	public int music;
	int cnt;
	
	public SelectScreen (RhythmHeaven rhythm){
		this.rhythm = rhythm;
	}

	@Override
	public void show() {
		switch(select) {
		case 0:
			pokemon.play();
			break;
		case 1:
			pokemon.dispose();
			kirby.play();
			break;
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			select++;
			cnt = 0;
		} else if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			select--;
			cnt = 0;
		}
		
		rhythm.batch.begin();
		
		switch(select){
		case 0:
			rhythm.batch.draw(new Texture("pokemon.png"), rhythm.WIDTH / 2 - WIDTH / 2 + 150, rhythm.HEIGHT / 2 - HEIGHT / 2 + 180, REAL_WIDTH, REAL_HEIGHT);
			if(cnt == 0) {
				pokemon.play();
				kirby.pause();
			}
			cnt = 1;
			
			break;
		case 1:
			
			if(cnt == 0) {
				pokemon.pause();
				kirby.play();
			}
			cnt = 1;
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
