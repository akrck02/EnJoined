package com.akrck02.enjoined.input;

import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.data.Enviroment;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyboardController implements InputProcessor {

    private Player player;

    public KeyboardController(Player player) {
        this.player = player;
    }


    @Override
    public boolean keyDown(int keycode) {

        if(keycode == Input.Keys.X)
            this.player.getInputs().setAction(true);

        if(keycode == Input.Keys.SPACE)
            this.player.getInputs().setJump(true);

        if(keycode == Input.Keys.DPAD_UP)
            this.player.getInputs().setUp(true);

        if(keycode == Input.Keys.DPAD_DOWN)
            this.player.getInputs().setDown(true);

        if(keycode == Input.Keys.DPAD_RIGHT)
            this.player.getInputs().setRight(true);

        if(keycode == Input.Keys.DPAD_LEFT)
            this.player.getInputs().setLeft(true);

        if(keycode == Input.Keys.F3){
            if(AppData.ENVIROMENT == Enviroment.PRODUCTION)
                AppData.ENVIROMENT = Enviroment.DEBUG;
            else
                AppData.ENVIROMENT = Enviroment.PRODUCTION;
        }


        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.X)
            this.player.getInputs().setAction(false);

        if(keycode == Input.Keys.SPACE)
            this.player.getInputs().setJump(false);

        if(keycode == Input.Keys.DPAD_UP)
            this.player.getInputs().setUp(false);

        if(keycode == Input.Keys.DPAD_DOWN)
            this.player.getInputs().setDown(false);

        if(keycode == Input.Keys.DPAD_RIGHT)
            this.player.getInputs().setRight(false);

        if(keycode == Input.Keys.DPAD_LEFT)
            this.player.getInputs().setLeft(false);

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public KeyboardController setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
