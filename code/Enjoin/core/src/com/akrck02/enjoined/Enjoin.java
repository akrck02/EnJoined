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
import com.badlogic.gdx.controllers.Controllers;
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
	public static boolean recharge = false;

	@Override
	public void create () {

		Gdx.graphics.setResizable(false);

		savestate = SaveIo.getSavestate();
		player = new Player(this,100,500, 64,64,true);
		player2 = new Player(this,0,200, 64,64,false);

		ui = new UserInterface(this.player);
		level = loadLevel();

		keyboard = new KeyboardController(this.player.getInputs());
		gamepad = new GamepadController(this.player.getInputs());

		Controllers.addListener(this.gamepad);
		Gdx.input.setInputProcessor(this.keyboard);
	}

	/**
	 * Load a level into the game
	 */
	public Level loadLevel() {
   		return new Level(player, player2, LevelRegistry.LEVELS.get(Zones.TUTORIAL).get(0));
	}

	@Override
	public void render () {
		ScreenUtils.clear(255, 255, 255, 1);

		if(recharge){
			player.getController().resetInputs();
			player2.getController().resetInputs();

			recharge();
			recharge = false;
		}

		if(swapPlayer){
			player.getController().resetInputs();

			swapPlayers();
			gamepad.setInputs(player.getInputs());
			keyboard.setInputs(player.getInputs());
			player.getController().resetInputs();

			swapPlayer = false;
		}


		level.render();
		level.update();
		ui.render();

		//Render debug data
		if(AppData.ENVIROMENT == Enviroment.DEBUG){
			int fps = Gdx.graphics.getFramesPerSecond();
			Text.drawText("FPS " + fps, 0,600);
			Text.drawText("Gamepads " + Controllers.getControllers().size , 0,550);
			Text.drawText("Speed " +  String.format("%,.2f", this.player.getController().getSpeed()) , 0,500);
			Text.drawText("x " + String.format("%,.2f", this.player.getCoordinates().x) , 0,450);
			Text.drawText("y " + String.format("%,.2f", this.player.getCoordinates().y) , 0,400);
		}
	}

	/**
	 * Swap player controls
	 */
	private void swapPlayers(){
		Player aux = this.player;
		this.player = this.player2;
		this.player2 = aux;
	}

	/**
	 * Recharges the level
	 */
	private void recharge(){
		player = new Player(this,100,500, 64,64,true);
		player2 = new Player(this,0,200, 64,64,false);
		this.level = loadLevel();
	}

	@Override
	public void dispose () {
		level.dispose();
		ui.dispose();
	}

	public Savestate getSavestate() {
		return savestate;
	}
	public Level getLevel() {
		return level;
	}
}
