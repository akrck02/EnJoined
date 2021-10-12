package com.akrck02.enjoined.input;

import com.akrck02.enjoined.Enjoin;
import com.akrck02.enjoined.core.Player;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.ControllerMapping;

public class GamepadController implements ControllerListener {

    private Player player;
    public GamepadController(Player player){
        this.player = player;
    }

    @Override
    public void connected(Controller controller) {
        System.out.println("Connected xbox controller");
    }

    @Override
    public void disconnected(Controller controller) {

    }

    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {

        ControllerMapping mapping = controller.getMapping();

        if(buttonCode == mapping.buttonA)
                this.player.getInputs().setAction(true);

        if(buttonCode == mapping.buttonX || buttonCode == mapping.buttonR1)
            this.player.getInputs().setJump(true);

        if(buttonCode == mapping.buttonDpadUp)
            this.player.getInputs().setUp(true);

        if(buttonCode == mapping.buttonDpadDown)
            this.player.getInputs().setDown(true);

        if(buttonCode == mapping.buttonDpadRight)
            this.player.getInputs().setRight(true);

        if(buttonCode == mapping.buttonDpadLeft)
            this.player.getInputs().setLeft(true);

        if(buttonCode == mapping.buttonL1){
            Enjoin.swapPlayer = true;
            System.out.println("Swap");
        }

        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        ControllerMapping mapping = controller.getMapping();

        if(buttonCode == mapping.buttonA)
            this.player.getInputs().setAction(false);

        if(buttonCode == mapping.buttonX || buttonCode == mapping.buttonR1)
            this.player.getInputs().setJump(false);

        if(buttonCode == mapping.buttonDpadUp)
            this.player.getInputs().setUp(false);

        if(buttonCode == mapping.buttonDpadDown)
            this.player.getInputs().setDown(false);

        if(buttonCode == mapping.buttonDpadRight)
            this.player.getInputs().setRight(false);

        if(buttonCode == mapping.buttonDpadLeft)
            this.player.getInputs().setLeft(false);

        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        return false;
    }

    public GamepadController setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
