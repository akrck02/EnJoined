package com.akrck02.enjoiin.input;

import com.akrck02.enjoiin.core.Player;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.ControllerMapping;

public class XboxController implements ControllerListener {

    private Player player;
    public XboxController(Player player){
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
                this.player.jump();

        if(buttonCode == mapping.buttonDpadUp)
            this.player.moveUp();

        if(buttonCode == mapping.buttonDpadDown)
            this.player.moveDown();

        if(buttonCode == mapping.buttonDpadRight)
            this.player.moveRight();

        if(buttonCode == mapping.buttonDpadLeft)
            this.player.moveLeft();


        return false;
    }

    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        return false;
    }

    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        return false;
    }
}
