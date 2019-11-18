package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.RhythmHeaven;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = RhythmHeaven.WIDTH;
		config.height = RhythmHeaven.HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new RhythmHeaven(), config);		

		
	}
}