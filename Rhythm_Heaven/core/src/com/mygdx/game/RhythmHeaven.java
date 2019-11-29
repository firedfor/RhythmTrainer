package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.rhythm.MenuScreen;
import com.mygdx.game.rhythm.ResultScreen;
import com.mygdx.game.rhythm.ScoreScreen;
import com.mygdx.game.rhythm.SelectScreen;
import com.mygdx.game.rhythm.TitleScreen;

public class RhythmHeaven extends Game {

	public static final int WIDTH = 1080;
	public static final int HEIGHT = 720;
	
	public int finalScore;
	
	public static SpriteBatch batch;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new TitleScreen(this));
//		this.setScreen(new MenuScreen(this));
//		this.setScreen(new GameScreen(this));
//		this.setScreen(new SelectScreen(this));
//		this.setScreen(new ScoreScreen(this, 0, 5000));
//		this.setScreen(new ResultScreen(this, 2));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
}
