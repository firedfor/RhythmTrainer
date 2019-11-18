package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.RhythmHeaven;

public class TitleScreen implements Screen{
	
	float stateTime;
	public static float SPEED = 0.06f;
//	public static float SPEED = 0.0646f;
//	3배가 되는 크기!!
	public static int titleWidth = 750;
	public static int titleHeight = 1005;
	
	public static int TEXT_WIDTH = (int)( 605 / 1.3);
	public static int TEXT_HEIGHT = (int)(106 / 1.3);
	RhythmHeaven rhythm;
	Animation ani[];
	Sound sound = Gdx.audio.newSound(Gdx.files.internal("title.mp3"));
	float time;
	int beat;
	
	public TitleScreen(RhythmHeaven rhythm) {
		this.rhythm = rhythm;
		TextureRegion[][] source = new TextureRegion(new Texture(Gdx.files.internal("Title.png"))).split(250, 335);
		ani = new Animation[1];
		ani[0] = new Animation(SPEED, source[0]);
		sound.play();
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		time += delta;
		beat = (int) (time / 0.48);
//		beat = (int) (time / 0.51724);
		RhythmHeaven.batch.begin();
		stateTime += delta;
//		System.out.println(stateTime);
		TextureRegion currentFrame = new TextureRegion((TextureRegion) ani[0].getKeyFrame(stateTime, true));
		
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(beat >= 8) {
			RhythmHeaven.batch.draw(currentFrame, 150, -200, titleWidth, titleHeight);
			RhythmHeaven.batch.draw(new Texture("TextPress.png"), RhythmHeaven.WIDTH / 2, 50, TEXT_WIDTH, TEXT_HEIGHT);
			
			
			if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
				sound.dispose();
				rhythm.setScreen(new MenuScreen(rhythm));
			}
			
			
		}
		
//		System.out.println(Gdx.input.isButtonPressed(Keys.A));
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
		
		
		
		RhythmHeaven.batch.end();
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
