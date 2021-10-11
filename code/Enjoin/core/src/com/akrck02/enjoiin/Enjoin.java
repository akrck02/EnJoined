package com.akrck02.enjoiin;

import com.akrck02.enjoiin.core.collectionables.Cookie;
import com.akrck02.enjoiin.core.GameObject;
import com.akrck02.enjoiin.core.Player;
import com.akrck02.enjoiin.core.collectionables.Heart;
import com.akrck02.enjoiin.core.data.Constants;
import com.akrck02.enjoiin.core.savestates.SaveIo;
import com.akrck02.enjoiin.core.savestates.Savestate;
import com.akrck02.enjoiin.graphics.Wallpaper;
import com.akrck02.enjoiin.graphics.ui.UserInterface;
import com.akrck02.enjoiin.input.KeyboardController;
import com.akrck02.enjoiin.input.GamepadController;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.LinkedList;
import java.util.List;

public class Enjoin extends ApplicationAdapter {

	private Savestate savestate;

	private Player player;
	private List<GameObject> objects;

	private Array<Controller> controllers;
	private KeyboardController keyboard;

	private UserInterface ui;
	private Wallpaper wallpaper;

	@Override
	public void create () {
		savestate = SaveIo.getSavestate();
		player = new Player(savestate,100,500, 64,64);

		ui = new UserInterface(player);
		objects = new LinkedList<>();

		controllers = Controllers.getControllers();
		if(controllers.size > 0){
			Controller c = controllers.get(0);
			c.addListener(new GamepadController(this.player));
		}

		for (int i = 0; i < 12 ; i++) {
			double randomX = Math.random() * (Constants.SCREEN_WIDTH - 64);
			double randomY = Math.random() * (Constants.SCREEN_HEIGHT - 64);
		}

		keyboard = new KeyboardController(player);
		Gdx.input.setInputProcessor(keyboard);
		wallpaper = new Wallpaper();
	}

	@Override
	public void render () {

		ScreenUtils.clear(255, 255, 255, 1);
		this.wallpaper.render();

		player.update();
		player.render();

		for (GameObject object: objects) {
			object.update();
			object.render();
		}

		ui.render();
	}
	
	@Override
	public void dispose () {
		player.dispose();
		wallpaper.dispose();
		for (GameObject object: objects) {
			object.dispose();
		}
	}
}
