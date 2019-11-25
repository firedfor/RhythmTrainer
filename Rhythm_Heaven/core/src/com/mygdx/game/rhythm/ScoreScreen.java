package com.mygdx.game.rhythm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.RhythmHeaven;

public class ScoreScreen implements Screen{
	
	RhythmHeaven rhythm;
	float timer;
	int cnt = 0;
	int finalScore;
	
	Sound load = Gdx.audio.newSound(Gdx.files.internal("resultLoad.mp3"));
	Sound Final = Gdx.audio.newSound(Gdx.files.internal("resultFinal.mp3"));
	Sound next = Gdx.audio.newSound(Gdx.files.internal("resultNext.mp3"));
	
	Sound tryAgain = Gdx.audio.newSound(Gdx.files.internal("tryAgain.mp3"));
	Sound OK = Gdx.audio.newSound(Gdx.files.internal("OK.mp3"));
	Sound superb = Gdx.audio.newSound(Gdx.files.internal("superb.mp3"));
	
	public ScoreScreen(RhythmHeaven rhythm, int score, int beat){
		this.rhythm = rhythm;
		this.finalScore = (int) (((float)score / beat) * 100);
	}
	
	public ScoreScreen(RhythmHeaven rhythm){
		this.rhythm = rhythm;
	}

	@Override
	public void show() {
//		System.out.println(finalScore);
		
	}
	

	@Override
	public void render(float delta) {
		
		timer += delta;
		
		
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		rhythm.batch.begin();
		
		if(timer > 2.0) {
			if(cnt == 0) {
				load.play();
				cnt++;
			}
			
			rhythm.batch.draw(new Texture("simjung.png"), 45, rhythm.HEIGHT - 134);
		}
		
		if(finalScore == 0) {
			
			if(timer > 3.5) {
				
				if(cnt == 1) {
					load.play();
					cnt++;
				}
				
				rhythm.batch.draw(new Texture("score0_1.png"), 250, rhythm.HEIGHT - 350);
				
			} if (timer > 5.0) {
				
				if(cnt == 2) {
					Final.play();
					cnt++;
				}
				
				rhythm.batch.draw(new Texture("score0_2.png"), 200, rhythm.HEIGHT - 430);
				
			} if (timer > 7.0) {
				
				if(cnt == 3) {
					tryAgain.play();
					cnt++;
				}
			
				
				rhythm.batch.draw(new Texture("tryagain.png"), rhythm.WIDTH - 547, 45);
				
				if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
					next.play();
					tryAgain.dispose();
					rhythm.setScreen(new ResultScreen(rhythm, 0));
				}
			}			
			
		} else if(finalScore < 50) {
			
			if(timer > 3.5) {
				
				if(cnt == 1) {
					load.play();
					cnt++;
				}
				
				rhythm.batch.draw(new Texture("score60_1.png"), 200, rhythm.HEIGHT - 350);
				
			} if (timer > 5.0) {
				
				if(cnt == 2) {
					Final.play();
					cnt++;
				}
				
				rhythm.batch.draw(new Texture("score60_2.png"), 200, rhythm.HEIGHT - 430);
				
			} if (timer > 7.0) {
				
				if(cnt == 3) {
					tryAgain.play();
					cnt++;
				}
			
				
				rhythm.batch.draw(new Texture("tryagain.png"), rhythm.WIDTH - 547, 45);
				
				if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
					next.play();
					tryAgain.dispose();
					rhythm.setScreen(new ResultScreen(rhythm, 0));
				}
			}
		}
		
		else if(finalScore < 60) {
					
				if(timer > 3.5) {
						
					if(cnt == 1) {
						load.play();
						cnt++;
					}
						
					rhythm.batch.draw(new Texture("score70_1.png"), 200, rhythm.HEIGHT - 350);
						
				} if (timer > 5.0) {
						
					if(cnt == 2) {
						Final.play();
						cnt++;
					}
						
					rhythm.batch.draw(new Texture("score70_2.png"), 280, rhythm.HEIGHT - 430);
						
				} if (timer > 7.0) {
						
					if(cnt == 3) {
						tryAgain.play();
						cnt++;
					}
						
					rhythm.batch.draw(new Texture("tryagain.png"), rhythm.WIDTH - 547, 45);
						
					if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
						next.play();
						tryAgain.dispose();
						rhythm.setScreen(new ResultScreen(rhythm, 0));
					}
				}
		}
		
		else if(finalScore < 90) {
			
			if(timer > 3.5) {
					
				if(cnt == 1) {
					load.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("score80_1.png"), 300, rhythm.HEIGHT - 350);
					
			} if (timer > 5.0) {
					
				if(cnt == 2) {
					Final.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("score80_2.png"), 280, rhythm.HEIGHT - 430);
					
			} if (timer > 7.0) {
					
				if(cnt == 3) {
					OK.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("OK.png"), rhythm.WIDTH - 547, 45);
					
				if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
					next.play();
					OK.dispose();
					rhythm.setScreen(new ResultScreen(rhythm, 1));
				}
			}
		}
		
		else if(finalScore < 100) {
			
			if(timer > 3.5) {
					
				if(cnt == 1) {
					load.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("score90_1.png"), 220, rhythm.HEIGHT - 350);
					
			} if (timer > 5.0) {
					
				if(cnt == 2) {
					Final.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("score90_2.png"), 380, rhythm.HEIGHT - 430);
					
			} if (timer > 7.0) {
					
				if(cnt == 3) {
					OK.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("butOK.png"), rhythm.WIDTH - 547, 45, 452, 201);
					
				if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
					next.play();
					OK.dispose();
					rhythm.setScreen(new ResultScreen(rhythm, 1));
				}
			}
		}
		
		else {
			
			if(timer > 3.5) {
					
				if(cnt == 1) {
					load.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("score100_1.png"), 400, rhythm.HEIGHT - 350);
					
			} if (timer > 5.0) {
					
				if(cnt == 2) {
					Final.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("score100_2.png"), 380, rhythm.HEIGHT - 430);
					
			} if (timer > 7.0) {
					
				if(cnt == 3) {
					superb.play();
					cnt++;
				}
					
				rhythm.batch.draw(new Texture("superb.png"), rhythm.WIDTH - 547, 45, 485, 201);
					
				if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
					next.play();
					superb.dispose();
					rhythm.setScreen(new ResultScreen(rhythm, 2));
				}
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
