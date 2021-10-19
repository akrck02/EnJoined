package com.akrck02.enjoined;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.data.Enviroment;
import com.akrck02.enjoined.graphics.Button;
import com.akrck02.enjoined.graphics.Textures;
import com.akrck02.enjoined.graphics.decoration.Character;
import com.akrck02.enjoined.graphics.decoration.Clouds;
import com.akrck02.enjoined.graphics.font.Text;
import com.akrck02.enjoined.input.GamepadController;
import com.akrck02.enjoined.input.InputMap;
import com.akrck02.enjoined.input.KeyboardController;
import com.akrck02.enjoined.sound.Sounds;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.vm.ci.meta.Constant;

import java.util.LinkedList;
import java.util.List;

public class StartScreen extends ApplicationAdapter {

    private Enjoin game;
    private SpriteBatch batch;
    private List<GameObject> objects;

    private KeyboardController keyboard;
    private GamepadController gamepad;

    private Texture title;
    private Character player;
    private Character player2;
    private Button newgame;
    private Button continuegame;
    private Texture wallpaper;
    private InputMap inputs;
    private int selected;

    @Override
    public void create() {
        objects = new LinkedList<>();
        batch = new SpriteBatch();
        inputs = new InputMap();

        Gdx.graphics.setResizable(false);
        selected = 0;

        keyboard = new KeyboardController(this.inputs);
        gamepad = new GamepadController(this.inputs);

        Controllers.addListener(this.gamepad);
        Gdx.input.setInputProcessor(this.keyboard);

        Sounds.MAIN_THEME.setLooping(true);
        Sounds.MAIN_THEME.play();

        wallpaper = Textures.MENU_BACKGROUND;

        Clouds clouds = new Clouds(64,540);
        Clouds clouds2 = new Clouds(220,490);

        newgame = new Button(Textures.MENU_NEW_GAME, Textures.MENU_NEW_GAME_SELECTED, 420,280);
        continuegame = new Button(Textures.MENU_CONTINUE, Textures.MENU_CONTINUE_SELECTED, 610,280);

        player = new Character(Textures.PLAYER_EAST, 645,500);
        player2 = new Character(Textures.PLAYER_2_WEST, 1028,590);

        this.title = Textures.MENU_TITLE;

        objects.add(clouds);
        objects.add(clouds2);
        objects.add(newgame);
        objects.add(continuegame);

        objects.add(
                new GameObject(){
                    private SpriteBatch batch = new SpriteBatch();

                    @Override
                    public void render() {
                        batch.begin();
                        batch.draw(title,300,380);
                        batch.end();
                    }

                    @Override
                    public void update() {}

                    @Override
                    public void dispose() {}
                }
        );

    }


    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        if(game == null) {

            batch.begin();
            batch.draw(wallpaper, 0, 0);
            batch.end();

            for (GameObject object : objects) {
                object.update();
                object.render();
            }

            player.render();
            player.update();

            player2.render();
            player2.update();

            if (selected == 0) {
                if (newgame.isSelected()) {

                } else {
                    continuegame.setSelected(false);
                    newgame.setSelected(true);
                }
            } else if (selected == 1) {
                if (continuegame.isSelected()) {

                } else {
                    continuegame.setSelected(true);
                    newgame.setSelected(false);
                }
            }

            if (inputs.isLeft())
                selected = 0;

            if (inputs.isRight())
                selected = 1;

            if (inputs.isAction()){
                if(selected == 0){
                    game = new Enjoin();
                    game.create();
                } else if(selected == 1){
                    game = new Enjoin();
                    game.create();
                }
            }

            //Render debug data
            if(AppData.ENVIROMENT == Enviroment.DEBUG){
                int fps = Gdx.graphics.getFramesPerSecond();
                Text.drawText("Version " + AppData.VERSION, 0,650);
                Text.drawText("FPS " + fps, 0,600);
                Text.drawText("Gamepads " + Controllers.getControllers().size , 0,550);
            }

        } else {
            if(   Sounds.MAIN_THEME.isPlaying())
                Sounds.MAIN_THEME.stop();

            game.render();
        }

    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}

