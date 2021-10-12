package com.akrck02.enjoined;

import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.data.Enviroment;
import com.akrck02.enjoined.core.data.Zones;
import com.akrck02.enjoined.core.levels.Level;
import com.akrck02.enjoined.core.levels.LevelRegistry;
import com.akrck02.enjoined.core.savestates.SaveIo;
import com.akrck02.enjoined.core.savestates.Savestate;
import com.akrck02.enjoined.graphics.font.Text;
import com.akrck02.enjoined.graphics.ui.UserInterface;
import com.akrck02.enjoined.input.GamepadController;
import com.akrck02.enjoined.input.KeyboardController;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Enjoin extends ApplicationAdapter {

	private Level level;
	private Savestate savestate;

	private Player player;
	private Player player2;

	private KeyboardController keyboard;
	private GamepadController gamepad;
	private UserInterface ui;

	public static boolean swapPlayer = false;

	@Override
	public void create () {
		Gdx.graphics.setResizable(false);

		savestate = SaveIo.getSavestate();
		player = new Player(this.savestate,100,500, 64,64,true);
		player2 = new Player(this.savestate,0,200, 64,64,false);

		ui = new UserInterface(this.player);
		level = loadLevel();
		level.setPlayers(this.player,this.player2);

		keyboard = new KeyboardController(this.player);
		gamepad = new GamepadController(this.player);

		Controllers.addListener(this.gamepad);
		Gdx.input.setInputProcessor(this.keyboard);
	}

	/**
	 * Load a level into the game
	 */
	public Level loadLevel() {
   		return LevelRegistry.LEVELS.get(Zones.TUTORIAL).get(0);
	}

	@Override
	public void render () {
		ScreenUtils.clear(255, 255, 255, 1);

		if(swapPlayer){
			swapPlayers();
			gamepad.setPlayer(player);
			keyboard.setPlayer(player);
		}


		level.render();
		level.update();
		ui.render();

		//Render debug data
		if(AppData.ENVIROMENT == Enviroment.DEBUG){
			int fps = Gdx.graphics.getFramesPerSecond();
			Text.drawText("FPS " + fps, 0,600);
			Text.drawText("Players " + Controllers.getControllers().size , 0,550);
		}
	}

	public void swapPlayers(){
		Player aux = this.player;
		this.player = this.player2;
		this.player2 = aux;
	}

	@Override
	public void dispose () {
		level.dispose();
		ui.dispose();
	}
}
