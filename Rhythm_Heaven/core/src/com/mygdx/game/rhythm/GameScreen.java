package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.RhythmHeaven;

public class GameScreen implements Screen{
	
	RhythmHeaven rhythm;
	Texture[] GameButton = new Texture[2];
	int select;
	public float beat;
	public float realbeat;
	boolean unbeat;
	
	Sound pokemon = Gdx.audio.newSound(Gdx.files.internal("pokemon.mp3"));
	Sound kirby = Gdx.audio.newSound(Gdx.files.internal("kirby.mp3"));
	Sound joker = Gdx.audio.newSound(Gdx.files.internal("joker.mp3"));
	Sound lockstep = Gdx.audio.newSound(Gdx.files.internal("lockstep.mp3"));
	
	Sound dong = Gdx.audio.newSound(Gdx.files.internal("dong.ogg"));
	Sound ka = Gdx.audio.newSound(Gdx.files.internal("ka.ogg"));
	
	public GameScreen(RhythmHeaven rhythm, int select, boolean unbeat) {
		this.rhythm = rhythm;
		GameButton[0] = new Texture("GameButtonUn.png");
		GameButton[1] = new Texture("GameButtonOn.png");
		this.select = select;
		this.unbeat = unbeat;   
		
		switch(select) {
		case 0:
			pokemon.play();
			realbeat = beat = 0.6741f;
			if(unbeat == true)
				beat += beat / 2;
			break;
		
		case 1:
			kirby.play();
			realbeat = beat = 0.7044f;
			if(unbeat == true)
				beat += beat / 2;
			break;
			
		case 2:
			joker.play();
			realbeat = beat = 0.6147f;
			if(unbeat == true)
				beat += beat / 2;
			break;
			
		case 3:
			lockstep.play();
			realbeat = beat = 0.3703f * 2.0f;
			if(unbeat == true)
				beat += beat / 2;
			break;
		}
	}
	
	public int score;
	public float timer;	
	public float touch;
	public float songLength = 30.0f;
	public static int BUTTON_WIDTH = (int)(772 / 1.5);
	public static int BUTTON_HEIGHT = (int)(531 / 1.5);
	
	boolean fail = false;	
	char key;

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		timer += delta;
		
//		System.out.println(fail);
		
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		rhythm.batch.begin();
		
		if(timer > ((int)(timer / beat) * beat) - beat / 10 && timer < ((int)(timer / beat) * beat) + beat / 10){
			fail = false;	
		}
		
		if(Gdx.input.isKeyPressed(Keys.F) || Gdx.input.isKeyPressed(Keys.D)){
			rhythm.batch.draw(GameButton[1], rhythm.WIDTH / 2 - BUTTON_WIDTH / 2, (rhythm.HEIGHT / 2 - BUTTON_HEIGHT / 2) - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		} else {
			rhythm.batch.draw(GameButton[0], rhythm.WIDTH / 2 - BUTTON_WIDTH / 2, (rhythm.HEIGHT / 2 - BUTTON_HEIGHT / 2) - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		}
		
		
//		if(timer % beat >= 0 && timer % beat < 0.1) {
//
//			System.out.println((int) ((songLength / beat) * 2));
//		}
		
		
		
		if(Gdx.input.isKeyJustPressed(Keys.F)) {

			touch = timer;
		
			dong.play();
				
			judgment(touch);
			
		} else if(Gdx.input.isKeyJustPressed(Keys.D)) {

			touch = timer;
		
			ka.play();
				
			judgment(touch);
			
		}
		
		
		rhythm.batch.end();
		
		if(timer >= songLength) {
			rhythm.setScreen(new ScoreScreen(rhythm, score, (int)((songLength / realbeat)) * 2 ));
		}
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
	
	public void judgment(float touch) {
		
		System.out.println(fail);
		
		if(touch < (((int)(timer / beat) * beat) - (beat / 1.9)) && touch > (((int)(timer / beat) * beat) - (beat / 1.1))){
			fail = true;				
		}
		
		else if(touch > (((int)(timer / beat) * beat) - beat / 4) && touch < (((int)(timer / beat) * beat) + beat / 4) && fail == false) {
			score += 2;
			fail = true;
			System.out.println("perfect");
			System.out.println(fail);
			System.out.println(score);
		} 
		
		else if(touch > (((int)(timer / beat) * beat) - beat / 2) && touch < (((int)(timer / beat) * beat) + beat / 2) && fail == false) {
			score += 1;
			fail = true;
			System.out.println("good");
			System.out.println(fail);
			System.out.println(score);
		}
		
		
	}

}
