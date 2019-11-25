package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.RhythmHeaven;

public class MenuScreen implements Screen{
		
	static float beat = 0.7185f;
	public static int ANIMATION_FRAMES = 16;
	
	public static float RHYTHM_SPEED = beat / ANIMATION_FRAMES;
	public static float LIGHT_SPEED = beat / 2;
	RhythmHeaven rhythm;
	float stateTime;
	
	public static int MENU_WIDTH = 478;
	public static int MENU_HEIGHT = 152;
	
	public static int LIGHT_WIDTH = 160;
	public static int LIGHT_HEIGHT = 259;
	
	public static int X_OF_START = 450;
	public static int X_OF_SCORE = 250;
	public static int X_OF_EXIT = 75;
	
	int select = 1;
	
	Animation GameStartOn[];

	Animation GameScoreOn[];
	
	Animation GameExitOn[];
	
	Animation TrafficLight1[];
	Animation TrafficLight2[];

	
//	Sound sound = Gdx.audio.newSound(Gdx.files.internal("title.mp3"));
	Sound selectSound = Gdx.audio.newSound(Gdx.files.internal("selectSound.mp3"));
	Sound MenuSound = Gdx.audio.newSound(Gdx.files.internal("menu.mp3"));
	Sound ErrorSound = Gdx.audio.newSound(Gdx.files.internal("selectError.mp3"));
	
	
	public MenuScreen(RhythmHeaven rhythm) {
		this.rhythm = rhythm;
		
		TextureRegion [][] StartOnSource = new TextureRegion(new Texture(Gdx.files.internal("GameStartOn.png"))).split(MENU_WIDTH, MENU_HEIGHT);
		
		TextureRegion [][] ScoreOnSource = new TextureRegion(new Texture(Gdx.files.internal("GameScoreOn.png"))).split(MENU_WIDTH, MENU_HEIGHT);
		
		TextureRegion [][] ExitOnSource = new TextureRegion(new Texture(Gdx.files.internal("GameExitOn.png"))).split(MENU_WIDTH, MENU_HEIGHT);
		
		TextureRegion [][] LightSource1 = new TextureRegion(new Texture(Gdx.files.internal("TrafficLight1.png"))).split(LIGHT_WIDTH, LIGHT_HEIGHT);
		TextureRegion [][] LightSource2 = new TextureRegion(new Texture(Gdx.files.internal("TrafficLight2.png"))).split(LIGHT_WIDTH, LIGHT_HEIGHT);
		
		GameStartOn = new Animation [1];
		
		GameScoreOn = new Animation [1];
		
		GameExitOn = new Animation [1];
		
		TrafficLight1 = new Animation [1];
		TrafficLight2 = new Animation [1];
		
		GameStartOn[0] = new Animation(RHYTHM_SPEED, StartOnSource[0]);
		
		GameScoreOn[0] = new Animation(RHYTHM_SPEED, ScoreOnSource[0]);
		
		GameExitOn[0] = new Animation(RHYTHM_SPEED, ExitOnSource[0]);
		
		TrafficLight1[0] = new Animation(LIGHT_SPEED, LightSource1[0]);
		TrafficLight2[0] = new Animation(LIGHT_SPEED, LightSource2[0]);
		
		MenuSound.play();
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		stateTime += delta;
		Gdx.gl.glClearColor(0.0f, 0.6392f, 0.82352f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if(select > 2) {
				ErrorSound.play();
			} else {
				select++;
				selectSound.play();
			}
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.UP)) {
			if(select < 2) {
				ErrorSound.play();
			} else {
				select--;
				selectSound.play();
			}
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			switch(select) {
			case 1:
				rhythm.setScreen(new SelectScreen(rhythm));
				MenuSound.dispose();
				break;
			case 2:
				rhythm.setScreen(new ScoreScreen(rhythm));
				MenuSound.dispose();
				break;
			case 3:
				rhythm.setScreen(new TitleScreen(rhythm));
				MenuSound.dispose();
				break;
			}
		}
		
		RhythmHeaven.batch.begin();
		
		RhythmHeaven.batch.draw(new Texture("MenuBackground.jpg"), 0, 0, rhythm.WIDTH, rhythm.HEIGHT);

		TextureRegion currentFrameStartOn = new TextureRegion((TextureRegion) GameStartOn[0].getKeyFrame(stateTime, true));
		
		TextureRegion currentFrameScoreOn = new TextureRegion((TextureRegion) GameScoreOn[0].getKeyFrame(stateTime, true));
		
		TextureRegion currentFrameExitOn = new TextureRegion((TextureRegion) GameExitOn[0].getKeyFrame(stateTime, true));
		
		TextureRegion currentFrameLight1 = new TextureRegion((TextureRegion) TrafficLight1[0].getKeyFrame(stateTime, true));
		TextureRegion currentFrameLight2 = new TextureRegion((TextureRegion) TrafficLight2[0].getKeyFrame(stateTime, true));
		
		RhythmHeaven.batch.draw(currentFrameLight1, (rhythm.WIDTH / 2 - MENU_WIDTH / 2) - 200, X_OF_START - 50);
		RhythmHeaven.batch.draw(currentFrameLight2, (rhythm.WIDTH / 2 - MENU_WIDTH / 2) + 550, X_OF_EXIT - 50);
		
		switch(select) {
		case 1:
			RhythmHeaven.batch.draw(currentFrameStartOn, rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_START, MENU_WIDTH, MENU_HEIGHT);
			RhythmHeaven.batch.draw(new Texture("GameScoreUn.png"), rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_SCORE);
			RhythmHeaven.batch.draw(new Texture("GameExitUn.png"), rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_EXIT);
			break;
		case 2:
			RhythmHeaven.batch.draw(new Texture("GameStartUn.png"), rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_START);
			RhythmHeaven.batch.draw(currentFrameScoreOn, rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_SCORE, MENU_WIDTH, MENU_HEIGHT);
			RhythmHeaven.batch.draw(new Texture("GameExitUn.png"), rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_EXIT);
			break;
		case 3:
			RhythmHeaven.batch.draw(new Texture("GameStartUn.png"), rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_START);
			RhythmHeaven.batch.draw(new Texture("GameScoreUn.png"), rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_SCORE);
			RhythmHeaven.batch.draw(currentFrameExitOn, rhythm.WIDTH / 2 - MENU_WIDTH / 2, X_OF_EXIT, MENU_WIDTH, MENU_HEIGHT);
			break;
		}
//		System.out.println(select);
		
		
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
