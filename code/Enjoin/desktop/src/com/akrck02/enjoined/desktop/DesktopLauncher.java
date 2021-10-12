package com.akrck02.enjoined.desktop;

import com.akrck02.enjoined.core.data.AppData;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.akrck02.enjoined.Enjoin;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = AppData.TITLE + " - " + AppData.VERSION;
		config.addIcon(AppData.GAME_ICON, Files.FileType.Local);
		config.width = AppData.GAME_WIDTH;
		config.height = AppData.SCREEN_HEIGHT;

		LwjglApplication app = new LwjglApplication(new Enjoin(), config);
	}
}
