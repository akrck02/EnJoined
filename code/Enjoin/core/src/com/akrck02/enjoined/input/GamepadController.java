package com.akrck02.enjoined.input;

import com.akrck02.enjoined.Enjoin;
import com.akrck02.enjoined.core.Player;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.ControllerMapping;

public class GamepadController implements ControllerListener {

    private InputMap inputs;
    public GamepadController(InputMap inputs){
        this.inputs = inputs;
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

        if(buttonCode == mapping.buttonX)
            this.inputs.setAction(true);

        if(buttonCode == mapping.buttonA || buttonCode == mapping.buttonR1)
            this.inputs.setJump(true);

        if(buttonCode == mapping.buttonDpadUp)
            this.inputs.setUp(true);

        if(buttonCode == mapping.buttonDpadDown)
            this.inputs.setDown(true);

        if(buttonCode == mapping.buttonDpadRight)
            this.inputs.setRight(true);

        if(buttonCode == mapping.buttonDpadLeft)
            this.inputs.setLeft(true);

        if(buttonCode == mapping.buttonL1){
            if(controller.canVibrate())
                controller.startVibration(250,1);

            Enjoin.swapPlayer = true;
        }

        if(buttonCode == mapping.buttonStart){
            if(controller.canVibrate())
                controller.startVibration(250,0);

            Enjoin.recharge = true;
        }

        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        ControllerMapping mapping = controller.getMapping();

        if(buttonCode == mapping.buttonX)
            this.inputs.setAction(false);

        if(buttonCode == mapping.buttonA || buttonCode == mapping.buttonR1)
            this.inputs.setJump(false);

        if(buttonCode == mapping.buttonDpadUp)
            this.inputs.setUp(false);

        if(buttonCode == mapping.buttonDpadDown)
            this.inputs.setDown(false);

        if(buttonCode == mapping.buttonDpadRight)
            this.inputs.setRight(false);

        if(buttonCode == mapping.buttonDpadLeft)
            this.inputs.setLeft(false);

        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        ControllerMapping mapping = controller.getMapping();
        if(axisCode == mapping.axisLeftX){
            if(value > 0.5) {
                inputs.setRight(true);
                inputs.setLeft(false);
            } else
                if(value < -0.5) {
                    inputs.setLeft(true);
                    inputs.setRight(false);
                } else {
                    inputs.setRight(false);
                    inputs.setLeft(false);
                }
        }
        if(axisCode == mapping.axisLeftY){
            if(value > 0.5) {
                inputs.setUp(false);
                inputs.setDown(true);
            } else
            if(value < -0.5) {
                inputs.setDown(false);
                inputs.setUp(true);
            } else {
                inputs.setUp(false);
                inputs.setDown(false);
            }
        }

        return false;
    }

    public GamepadController setInputs(InputMap inputs) {
        this.inputs = inputs;
        return this;
    }
}
