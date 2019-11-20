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
	
	Sound dong = Gdx.audio.newSound(Gdx.files.internal("dong.ogg"));
	Sound ka = Gdx.audio.newSound(Gdx.files.internal("ka.ogg"));

	public static int WIDTH = 577;
	public static int HEIGHT = 814;
	public static int REAL_WIDTH = WIDTH / 2;
	public static int REAL_HEIGHT = HEIGHT / 2;
	
	Sound pokemon = Gdx.audio.newSound(Gdx.files.internal("pokemon.mp3"));
	Sound kirby = Gdx.audio.newSound(Gdx.files.internal("kirby.mp3"));
	Sound joker = Gdx.audio.newSound(Gdx.files.internal("joker.mp3"));
	Sound lockstep = Gdx.audio.newSound(Gdx.files.internal("lockstep.mp3"));
	
	public int select = 0;
	public boolean unbeat = false;
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
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			pokemon.dispose();
			kirby.dispose();
			joker.dispose();
			lockstep.dispose();
			dong.play();
			rhythm.setScreen(new GameScreen(rhythm, select, unbeat));
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			ka.play();
			if(select < 3) {
				select++;
				cnt = 0;
			}			
			
		} else if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			ka.play();
			if(select > 0) {
				select--;
				cnt = 0;
			}
		} else if(Gdx.input.isKeyJustPressed(Keys.UP)) {
			ka.play();
			if(unbeat == false) {
				unbeat = true;
			} else {
				unbeat = false;
			}
			
		} else if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			ka.play();
			if(unbeat == false) {
				unbeat = true;
			} else {
				unbeat = false;
			}
			
		}
		
		rhythm.batch.begin();
		
		rhythm.batch.draw(new Texture("unbeat.png"), 10, rhythm.HEIGHT - 80);
		
		if(unbeat == false) {
			rhythm.batch.draw(new Texture("false.png"), 250, rhythm.HEIGHT - 80);
		} else if(unbeat == true) {
			rhythm.batch.draw(new Texture("true.png"), 250 , rhythm.HEIGHT - 80);
		}
		
		switch(select){
		case 0:
			rhythm.batch.draw(new Texture("pokemon.png"), rhythm.WIDTH / 2 - WIDTH / 2 + 150, rhythm.HEIGHT / 2 - HEIGHT / 2 + 180, REAL_WIDTH, REAL_HEIGHT);
			if(cnt == 0) {
				pokemon.play();
				kirby.pause();
				joker.pause();
				lockstep.pause();
			}
			cnt = 1;
			
			break;
		case 1:
			rhythm.batch.draw(new Texture("kirby.png"), rhythm.WIDTH / 2 - WIDTH / 2 + 150, rhythm.HEIGHT / 2 - HEIGHT / 2 + 180, REAL_WIDTH, REAL_HEIGHT);
			if(cnt == 0) {
				pokemon.pause();
				kirby.play();
				joker.pause();
				lockstep.pause();
			}
			cnt = 1;
			
			break;
			
		case 2:
			rhythm.batch.draw(new Texture("joker.png"), rhythm.WIDTH / 2 - WIDTH / 2 + 150, rhythm.HEIGHT / 2 - HEIGHT / 2 + 180, REAL_WIDTH, REAL_HEIGHT);
			if(cnt == 0) {
				pokemon.pause();
				kirby.pause();
				joker.play();
				lockstep.pause();
			}
			cnt = 1;
			
			break;
			
		case 3:
			rhythm.batch.draw(new Texture("lockstep.png"), rhythm.WIDTH / 2 - WIDTH / 2 + 150, rhythm.HEIGHT / 2 - HEIGHT / 2 + 180, REAL_WIDTH, REAL_HEIGHT);
			if(cnt == 0) {
				pokemon.pause();
				kirby.pause();
				joker.pause();
				lockstep.play();
			}
			cnt = 1;
			
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
