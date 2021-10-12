package com.akrck02.enjoined.core;

import com.akrck02.enjoined.core.data.Constants;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.graphics.Direction;
import com.akrck02.enjoined.input.InputMap;
import com.badlogic.gdx.Gdx;

public class PlayerController implements Updateable {

    public final static double MAX_SPEED = 400;
    public final static double ACCELERATION = 100;
    public final static double MAX_JUMP_SPEED = 400;

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
        /**
         if (!player.getStates().isGrounded() && player.coordinates.y > 0) {
         player.coordinates.y -= 300 * Gdx.graphics.getDeltaTime();
         player.getStates().setFalling(true);
         } else {
         player.getStates().setJumping(false);
         player.getStates().setFalling(false);
         }
         */

        if (inputs.isAction()) {

        }

        if (inputs.isJump()) {

            if(!player.getStates().isFalling())
                player.getStates().setJumping(true);

            if (player.getStates().isJumping()) {
                speed += ACCELERATION;       
                if(speed >= MAX_JUMP_SPEED){
                    speed = MAX_JUMP_SPEED;
                    player.getStates().setJumping(false);
                    player.getStates().setFalling(true);
                }

            } else if (player.getStates().isFalling()) {
               
            }
            jump();

        }


        if (inputs.isUp()) {
            moveUp();
        }


        if (inputs.isDown()) {
            moveDown();
        }

        if (inputs.isRight()) {

            if (player.getStates().isAccelerating()) {
                this.speed += ACCELERATION;
                if (this.speed > MAX_SPEED) {
                    this.speed = MAX_SPEED;
                    player.getStates().setAccelerating(false);
                    player.getStates().setDecelerating(true);
                }
            }

            moveRight();
        }

        if (inputs.isLeft()) {
            if (player.getStates().isAccelerating()) {
                this.speed += ACCELERATION;
                if (this.speed > MAX_SPEED) {
                    this.speed = MAX_SPEED;
                    player.getStates().setAccelerating(false);
                    player.getStates().setDecelerating(true);
                }
            }

            moveLeft();
        }

        player.body.update();
    }


    public void moveUp() {
        player.getStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.NORTH);
    }

    public void moveDown() {
        player.getStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.SOUTH);
    }

    public void moveLeft() {
        player.getStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.WEST);

        final double acceleration = 200;
        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double newX = player.coordinates.x - speed * deltaTime;

        if (newX > 0)
            player.coordinates.x = newX;

    }

    public void moveRight() {
        player.getStates().setAccelerating(true);
        player.getSprite().setCurrent(Direction.EAST);
        ;
        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double newX = player.coordinates.x + speed * deltaTime;

        if (newX < Constants.SCREEN_WIDTH - player.width)
            player.coordinates.x = newX;
    }

    public void jump() {

        final double deltaTime = Gdx.graphics.getDeltaTime();
        double newY = player.coordinates.y;

        System.out.println("SPEED:" + speed);
        if (player.getStates().isJumping()) {
            newY += speed * deltaTime;
            System.out.println("Jumping!");

        } else if (player.getStates().isFalling()) {
            newY -= speed * deltaTime;
            System.out.println("Falling! :(");
        }

        if (newY >= Constants.SCREEN_HEIGHT - player.height)
            newY = Constants.SCREEN_HEIGHT - player.height;

        if (newY <= 0)
            newY = 0;

        player.coordinates.y = newY;
    }

    public void action() {

    }

    public InputMap getInputs() {
        return inputs;
    }

}
