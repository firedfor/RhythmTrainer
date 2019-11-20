package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.RhythmHeaven;

public class GameScreen implements Screen{
	
//	Sound dong = Gdx.audio.newSound(Gdx.files.internal("dong.ogg"));
//	Sound ka = Gdx.audio.newSound(Gdx.files.internal("ka.ogg"));
	Sound music = Gdx.audio.newSound(Gdx.files.internal("title.mp3"));
	
	Texture[] GameButton = new Texture[2];
	public int score;
	public float timer;
//	public float beat = 0.6f;
	public float touch;
	public float songLength = 30.0f;
	public static int BUTTON_WIDTH = (int)(772 / 1.5);
	public static int BUTTON_HEIGHT = (int)(531 / 1.5);
	
	boolean effectSound = false;
	boolean fail = false;
	
	RhythmHeaven rhythm;
	
	public GameScreen(RhythmHeaven rhythm) {
		this.rhythm = rhythm;
		GameButton[0] = new Texture("GameButtonUn.png");
		GameButton[1] = new Texture("GameButtonOn.png");
		music.play();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println();
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
		
		if(Gdx.input.isKeyPressed(Keys.ANY_KEY)){
			rhythm.batch.draw(GameButton[1], rhythm.WIDTH / 2 - BUTTON_WIDTH / 2, (rhythm.HEIGHT / 2 - BUTTON_HEIGHT / 2) - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		} else {
			rhythm.batch.draw(GameButton[0], rhythm.WIDTH / 2 - BUTTON_WIDTH / 2, (rhythm.HEIGHT / 2 - BUTTON_HEIGHT / 2) - 50, BUTTON_WIDTH, BUTTON_HEIGHT);
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {

			touch = timer;
			
			// 효과음 부분			
			if(effectSound == false) {
				dong.play();
				effectSound = true;
				
			} else {
				ka.play(); 
				effectSound = false;
			}
			
			// 판정 부분
			if(touch < (((int)(timer / beat) * beat) - beat / 2) && touch > (((int)(timer / beat) * beat) - beat)){
				fail = true;				
			} 
			
			if(touch > (((int)(timer / beat) * beat) - beat / 5) && touch < (((int)(timer / beat) * beat) + beat / 5) && fail == false) {
				score += 2;
				fail = true;
				System.out.println("perfect");
				System.out.println(score);
			} else if(touch > (((int)(timer / beat) * beat) - beat / 3) && touch < (((int)(timer / beat) * beat) + beat / 3) && fail == false) {
				score += 1;
				fail = true;
				System.out.println("good");
				System.out.println(score);
			}
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
