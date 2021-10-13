package com.akrck02.enjoined.core;

import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.graphics.Direction;
import com.akrck02.enjoined.input.InputMap;
import com.badlogic.gdx.Gdx;

public class PlayerController implements Updateable {

    public final static double MAX_SPEED = 400;
    public final static double ACCELERATION = 100;
    public final static double MAX_JUMP_SPEED = 400;
    public final static double IDLE_SPEED = 1;

    private Player player;
    private InputMap inputs;

    private double speed;

    public PlayerController(Player player, InputMap inputs) {
        this.player = player;
        this.inputs = inputs;

        //movement stats
        this.speed = 0;
    }

    @Override
    public void update() {

        /*
         *  Action handle
         */
        if (inputs.isAction()) {

        }

        /**
         * Jump handle
         */
        if (inputs.isJump()) {

            if(!this.player.getMoveStates().isCollideUp()) {

                speed += ACCELERATION;
                if (speed >= MAX_JUMP_SPEED) {
                    speed = MAX_JUMP_SPEED;
                    player.getMoveStates().setJumping(false);
                    player.getMoveStates().setFalling(true);
                }

                jump();
            } else this.player.getMoveStates().setCollideUp(false);
        } else {
            if(!this.player.getMoveStates().isCollideDown()){
                this.speed = Physics.GRAVITY;
                double newY = player.coordinates.y - speed;

                if (newY < 0) {
                    newY = 0;
                    this.speed = 0;
                }

                player.coordinates.y = newY;
            }
            this.player.getMoveStates().setCollideDown(false);
        }

        /*
         * Up movement handle
         */
        if (inputs.isUp()) {
            moveUp();
        }

        /*
         * Down movement handle
         */
        if (inputs.isDown()) {
            moveDown();
        }

        /*
         * Right movement handle
         */
        if (inputs.isRight()) {
            if(!player.getMoveStates().isCollideRight()) {
                if (player.getMoveStates().isAccelerating()) {
                    this.speed += ACCELERATION;
                    if (this.speed > MAX_SPEED) {
                        this.speed = MAX_SPEED;
                        player.getMoveStates().setAccelerating(false);
                        player.getMoveStates().setDecelerating(true);
                    }
                }

                moveRight();
            }
            player.getMoveStates().setCollideRight(false);
        }

        /*
         * Left movement handle
         */
        if (inputs.isLeft()) {
            if (player.getMoveStates().isAccelerating()) {
                this.speed += ACCELERATION;
                if (this.speed > MAX_SPEED) {
                    this.speed = MAX_SPEED;
                    player.getMoveStates().setAccelerating(false);
                    player.getMoveStates().setDecelerating(true);
                }
            }

            moveLeft();
        }

        player.body.update();
    }

    /**
     * Move the character up
     */
    private void moveUp() {
        player.getMoveStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.NORTH);
    }

    /**
     * Move the character down
     */
    private void moveDown() {
        player.getMoveStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.SOUTH);
    }

    /**
     * Move the character to the  left
     */
    private void moveLeft() {
        player.getMoveStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.WEST);

        final double acceleration = 200;
        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double newX = player.coordinates.x - speed * deltaTime;

        if (newX > 0)
            player.coordinates.x = newX;

    }

    /**
     * Move the character to the right
     */
    private void moveRight() {
        player.getMoveStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.EAST);
        ;
        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double newX = player.coordinates.x + speed * deltaTime;

        if (newX < AppData.SCREEN_WIDTH - player.width)
            player.coordinates.x = newX;
    }

    /**
     * Make the character jump
     */
    private void jump() {

        final double deltaTime = Gdx.graphics.getDeltaTime();
        double newY = player.coordinates.y;
        newY += speed * deltaTime;


        if (newY >= AppData.SCREEN_HEIGHT - player.height)
            newY = AppData.SCREEN_HEIGHT - player.height;

        player.coordinates.y = newY;
    }


    public void resetInputs() {
        InputMap inputs = this.player.getInputs();
        inputs.setUp(false);
        inputs.setDown(false);
        inputs.setRight(false);
        inputs.setLeft(false);
        inputs.setAction(false);
        inputs.setJump(false);
    }

    //Getters and setters

    public void action() {

    }

    public InputMap getInputs() {
        return inputs;
    }

    public double getSpeed() {
        return speed;
    }
}
