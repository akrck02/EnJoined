package com.akrck02.enjoined.core;

import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.graphics.Direction;
import com.akrck02.enjoined.input.InputMap;
import com.badlogic.gdx.Gdx;

public class PlayerController implements Updateable {

    public final static double MAX_SPEED = 400;
    public final static double ACCELERATION = 400;
    public final static double MAX_JUMP_SPEED = 400;
    public final static double IDLE_SPEED = 0;
    public final static double MAX_JUMP_DISTANCE = 50;

    private double deltaX;
    private double deltaY;

    private Player player;
    private InputMap inputs;

    private boolean maxJump;
    private Double originY;

    private double speed;

    public PlayerController(Player player, InputMap inputs) {
        this.player = player;
        this.inputs = inputs;
        this.maxJump = false;

        this.deltaX = 0;
        this.deltaY = 0;

        //movement stats
        this.speed = IDLE_SPEED;
    }

    @Override
    public void update() {

        /*
         *  Action handle
         */
        if (inputs.isAction()) {

        }

        if (this.player.getPhysicStates().isCollideRight()) {


        } else if (this.player.getPhysicStates().isCollideRight()) {


        } else if (this.player.getPhysicStates().isCollideUp()) {


        } else if (this.player.getPhysicStates().isCollideDown()) {


        } else {

            /*
             * Up movement handle
             */
            if (inputs.isUp()) moveUp();

            /*
             * Down movement handle
             */
            if (inputs.isDown()) moveDown();

            /*
             * Right movement handle
             */
            if (inputs.isRight()) {
                if (!player.getPhysicStates().isCollideRight()) {
                    if (player.getPhysicStates().isAccelerating()) {
                        this.speed += ACCELERATION + deltaX;
                        if (this.speed > MAX_SPEED) {
                            this.speed = MAX_SPEED;
                            player.getPhysicStates().setAccelerating(false);
                            player.getPhysicStates().setDecelerating(true);
                        }
                    }

                    moveRight();
                }
                player.getPhysicStates().setCollideRight(false);
            }

            /*
             * Left movement handle
             */
            if (inputs.isLeft()) {
                if (player.getPhysicStates().isAccelerating()) {
                    this.speed += ACCELERATION + deltaX;
                    if (this.speed > MAX_SPEED) {
                        this.speed = MAX_SPEED;
                        player.getPhysicStates().setAccelerating(false);
                        player.getPhysicStates().setDecelerating(true);
                    }
                }

                moveLeft();
            }

            /**
             * Jump handle
             */
            if (inputs.isJump() && !maxJump) {
                System.out.println("Jump");
                if (!this.player.getPhysicStates().isCollideUp()) {

                    if (originY == null) {
                        originY = player.coordinates.y;
                    }

                    speed += ACCELERATION;
                    if (speed >= MAX_JUMP_SPEED) {
                        speed = MAX_JUMP_SPEED;
                        player.getPhysicStates().setAscending(false);
                        player.getPhysicStates().setDescending(true);
                    }

                    jump();

                    if (this.player.coordinates.y - originY >= MAX_JUMP_DISTANCE) {
                        maxJump = true;
                    }

                } else this.player.getPhysicStates().setCollideUp(false);
            } else {
                if (!this.player.getPhysicStates().isCollideDown()) {
                    this.speed = Physics.GRAVITY;
                    double newY = player.coordinates.y - speed;

                    if (newY < 0) {
                        newY = 0;
                        this.speed = 0;
                    }

                    player.coordinates.y = newY + deltaY;
                } else {
                    this.originY = null;
                    this.maxJump = false;
                }

                this.player.getPhysicStates().setCollideDown(false);
            }
        }
        player.body.update();
    }

    /**
     * Move the character up
     */
    private void moveUp() {
        player.getPhysicStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.NORTH);
    }

    /**
     * Move the character down
     */
    private void moveDown() {
        player.getPhysicStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.SOUTH);
    }

    /**
     * Move the character to the  left
     */
    private void moveLeft() {
        player.getPhysicStates().setAccelerating(true);
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
        player.getPhysicStates().setAccelerating(true);
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

        player.coordinates.y = newY - deltaY;
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

    public PlayerController setDeltaX(double deltaX) {
        this.deltaX = deltaX;
        return this;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public PlayerController setDeltaY(double deltaY) {
        this.deltaY = deltaY;
        return this;
    }

    public double getDeltaY() {
        return deltaY;
    }
}
