package com.akrck02.enjoiin.desktop;

import com.akrck02.enjoiin.core.data.Constants;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.akrck02.enjoiin.Enjoin;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constants.TITLE + " - " + Constants.VERSION;
		config.addIcon(Constants.GAME_ICON, Files.FileType.Local);
		config.width = Constants.GAME_WIDTH;
		config.height = Constants.SCREEN_HEIGHT;

		LwjglApplication app = new LwjglApplication(new Enjoin(), config);
	}
}
