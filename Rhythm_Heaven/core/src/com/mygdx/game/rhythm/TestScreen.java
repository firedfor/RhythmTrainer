package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.RhythmHeaven;

public class TestScreen implements Screen{
	
	public static float SPEED = 0.05f;
	
	Animation[] steps;
	float stateTime;
	boolean click = false;
	
	RhythmHeaven rhythm;
	
	public TestScreen (RhythmHeaven rhythm) {
		this.rhythm = rhythm;
		steps = new Animation[1];
		TextureRegion[][] step = new TextureRegion(new Texture(Gdx.files.internal("animation_test.png"))).split(75, 127);
		steps[0] = new Animation(SPEED, step[0]);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		RhythmHeaven.batch.begin();
		System.out.println(click);
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += delta;
		TextureRegion currentFrame = new TextureRegion((TextureRegion) steps[0].getKeyFrame(stateTime, false));
		if(Gdx.input.isTouched() || click == true) {
			click = true;
//			RhythmHeaven.batch.draw((TextureRegion) steps[0].getKeyFrame(stateTime, true), 0, 0);
			RhythmHeaven.batch.draw((TextureRegion) currentFrame, 0, 0);
			System.out.println(steps[0].getKeyFrameIndex(stateTime));
			if(steps[0].getKeyFrameIndex(stateTime) >= 10) {
				click = false;
				stateTime = 0;
			} else if(Gdx.input.isTouched()) {
				stateTime = 0;
			}
			
		} else if (click == false) {
			RhythmHeaven.batch.draw((TextureRegion) steps[0].getKeyFrame(0.0f, true), 0, 0);
		}
		
		RhythmHeaven.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
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
		
	}

	


}
