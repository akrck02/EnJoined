package com.akrck02.enjoiin;

import com.akrck02.enjoiin.core.Player;
import com.akrck02.enjoiin.graphics.Wallpaper;
import com.akrck02.enjoiin.input.XboxController;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Enjoin extends ApplicationAdapter {

	private Player player;
	private Array<Controller> controllers;
	private Wallpaper wallpaper;

	@Override
	public void create () {
		player = new Player(100,0, 64,64);
		controllers = Controllers.getControllers();
		if(controllers.size > 0){
			Controller c = controllers.get(0);
			c.addListener(new XboxController(this.player));
		}

		wallpaper = new Wallpaper();
	}

	@Override
	public void render () {
		this.player.move();
		ScreenUtils.clear(255, 255, 255, 1);
		this.wallpaper.render();
		player.render();
		player.update();
	}
	
	@Override
	public void dispose () {
		player.dispose();
		wallpaper.dispose();
	}
}
