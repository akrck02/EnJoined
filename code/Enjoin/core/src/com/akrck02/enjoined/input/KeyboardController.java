package com.akrck02.enjoined.input;

import com.akrck02.enjoined.Enjoin;
import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.data.Enviroment;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyboardController implements InputProcessor {

    private InputMap inputs;

    public KeyboardController(InputMap inputs) {
        this.inputs = inputs;
    }


    @Override
    public boolean keyDown(int keycode) {

        if(keycode == Input.Keys.ENTER)
            this.inputs.setAction(true);

        if(keycode == Input.Keys.SPACE)
            this.inputs.setJump(true);

        if(keycode == Input.Keys.DPAD_UP)
            this.inputs.setUp(true);

        if(keycode == Input.Keys.DPAD_DOWN)
            this.inputs.setDown(true);

        if(keycode == Input.Keys.DPAD_RIGHT)
            this.inputs.setRight(true);

        if(keycode == Input.Keys.DPAD_LEFT)
            this.inputs.setLeft(true);

        if(keycode == Input.Keys.F3){
            if(AppData.ENVIROMENT == Enviroment.PRODUCTION)
                AppData.ENVIROMENT = Enviroment.DEBUG;
            else
                AppData.ENVIROMENT = Enviroment.PRODUCTION;
        }

        if(keycode == Input.Keys.S){
            Enjoin.swapPlayer = true;
        }

        if(keycode == Input.Keys.R){
            Enjoin.recharge = true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.X)
            this.inputs.setAction(false);

        if(keycode == Input.Keys.SPACE)
            this.inputs.setJump(false);

        if(keycode == Input.Keys.DPAD_UP)
            this.inputs.setUp(false);

        if(keycode == Input.Keys.DPAD_DOWN)
            this.inputs.setDown(false);

        if(keycode == Input.Keys.DPAD_RIGHT)
            this.inputs.setRight(false);

        if(keycode == Input.Keys.DPAD_LEFT)
            this.inputs.setLeft(false);

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

    public KeyboardController setInputs(InputMap inputs) {
        this.inputs = inputs;
        return this;
    }
}
