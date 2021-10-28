package com.akrck02.enjoined.core;

import com.akrck02.enjoined.Enjoin;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.interfaces.Renderizable;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.graphics.Direction;
import com.akrck02.enjoined.graphics.font.Text;
import com.akrck02.enjoined.input.InputMap;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class PlayerController implements Updateable, Renderizable {

    public final double IDLE_SPEED = 0;
    public final double MAX_SPEED = 1;
    public final double ACCELERATION = 101;
    public final double DISTANCE = 7;
    public final double MAX_JUMP_DISTANCE = 90;

    private final Enjoin game;
    private final Player player;
    private final InputMap inputs;
    private final ShapeRenderer shapes;

    private boolean maxJump;
    private Double originY;

    private Rectangle futureUpHitbox;
    private Rectangle futureDownHitbox;
    private Rectangle futureLeftHitbox;
    private Rectangle futureRightHitbox;

    private double speed;

    public PlayerController(Enjoin game, Player player, InputMap inputs) {
        this.game = game;
        this.player = player;
        this.inputs = inputs;
        this.maxJump = false;
        this.shapes = new ShapeRenderer();

        //movement stats
        this.speed = IDLE_SPEED;
    }

    @Override
    public void update() {

        checkCollisions();

        futureUpHitbox = null;
        futureDownHitbox = null;
        futureLeftHitbox = null;
        futureRightHitbox = null;

        /*
         * Up movement handle
         */
        if (inputs.isUp())
            moveUp();

        /*
         * Down movement handle
         */
        if (inputs.isDown())
            moveDown();

        /*
         * Right movement handle
         */
        if (!player.getPhysicStates().isFutureCollideRight() && inputs.isRight())
            moveRight();

        /*
         * Left movement handle
         */
        if (!player.getPhysicStates().isFutureCollideLeft() && inputs.isLeft())
            moveLeft();

        if (inputs.isJump() && (!player.getPhysicStates().isJumping() && !player.getPhysicStates().isFalling()))
            player.getPhysicStates().setJumping(true);


        if (!player.getPhysicStates().isFutureCollideUp() && player.getPhysicStates().isJumping() && !maxJump) {
            jump();
        } else if (!player.getPhysicStates().isFutureCollideDown()) {
            fall();
        } else {
            player.getPhysicStates().setJumping(false);
            player.getPhysicStates().setFalling(false);
            maxJump = false;
            originY = null;
        }


        if (!player.getInputs().isDown() && !player.getInputs().isUp() && !player.getInputs().isLeft() && !player.getInputs().isRight())
            this.speed = IDLE_SPEED;

        player.body.update();
        calculateFutureHitboxes();

        player.getPhysicStates().setFutureCollideUp(false);
        player.getPhysicStates().setFutureCollideDown(false);
        player.getPhysicStates().setFutureCollideLeft(false);
        player.getPhysicStates().setFutureCollideRight(false);
    }

    /**
     * Move the character up
     */
    private void moveUp() {
        player.getSprite().setCurrent(Direction.NORTH);
    }

    /**
     * Move the character down
     */
    private void moveDown() {
        player.getSprite().setCurrent(Direction.SOUTH);
    }

    /**
     * Move the character to the  left
     */
    private void moveLeft() {
        player.getSprite().setCurrent(Direction.WEST);

        if (this.speed > this.MAX_SPEED)
            this.speed = MAX_SPEED;
        else
            this.speed *= (this.ACCELERATION / 100);

        if (this.speed < 1)
            this.speed = 1;

        double x = player.coordinates.x - this.DISTANCE * this.speed;

        if (x > 0)
            player.coordinates.x = x;
    }

    /**
     * Move the character to the right
     */
    private void moveRight() {
        player.getSprite().setCurrent(Direction.EAST);

        if (this.speed > this.MAX_SPEED) {
            this.speed = MAX_SPEED;
        } else {
            this.speed *= (this.ACCELERATION / 100);
        }

        if (this.speed < 1)
            this.speed = 1;

        final double x = (player.coordinates.x + this.DISTANCE * this.speed);
        if (x < AppData.SCREEN_WIDTH - player.width)
            player.coordinates.x = x;
    }

    /**
     * Make the character jump
     */
    private void jump() {
        player.getPhysicStates().setFalling(false);
        player.getPhysicStates().setJumping(true);

        if (originY == null) {
            originY = player.coordinates.y;
        }

        if (this.speed > this.MAX_SPEED)
            this.speed = MAX_SPEED;
        else
            this.speed *= (this.ACCELERATION / 100);

        if (this.speed < 1)
            this.speed = 1;

        double y = player.coordinates.y + this.DISTANCE * this.speed;

        if (y >= AppData.SCREEN_HEIGHT - player.height)
            y = AppData.SCREEN_HEIGHT - player.height;

        player.coordinates.y = y;

        if (this.player.coordinates.y - originY >= MAX_JUMP_DISTANCE) {
            maxJump = true;
        }

    }

    /**
     * Make the character fall
     */
    private void fall() {

        player.getPhysicStates().setFalling(true);
        player.getPhysicStates().setJumping(false);

        this.speed = Physics.GRAVITY;
        double newY = player.coordinates.y - speed;

        if (newY < 0) {
            System.out.println("surface level 0");
            newY = 1;
            this.speed = 0;

            player.getPhysicStates().setFalling(false);
            player.getPhysicStates().setJumping(false);

            maxJump = false;
            originY = null;
        }

        player.coordinates.y = newY;
        this.player.getPhysicStates().setCollideDown(true);
    }


    private void checkCollisions() {

        //Check future collisions
        List<Tile> tiles = game.getLevel().getTiles();

        for (Tile object : tiles) {
            if (object.getStates().isCollide()) {
                Rectangle otherHitbox = object.getBody().getRectangle();

                if (futureUpHitbox != null) {
                    if (otherHitbox.overlaps(futureUpHitbox))
                        player.getPhysicStates().setFutureCollideUp(true);
                }
                if (futureDownHitbox != null) {
                    if (otherHitbox.overlaps(futureDownHitbox))
                        player.getPhysicStates().setFutureCollideDown(true);
                }
                if (futureLeftHitbox != null) {
                    if (otherHitbox.overlaps(futureLeftHitbox))
                        player.getPhysicStates().setFutureCollideLeft(true);
                }
                if (futureRightHitbox != null) {
                    if (otherHitbox.overlaps(futureRightHitbox))
                        player.getPhysicStates().setFutureCollideRight(true);
                }
            }
        }

    }

    /**
     * Calculate future character hit boxes
     */
    private void calculateFutureHitboxes() {
        double ns = this.speed *= (this.ACCELERATION / 100);
        if (ns > this.MAX_SPEED)
            ns = MAX_SPEED;

        if (ns == 0)
            ns = 1;

        double nx = player.coordinates.x - (DISTANCE * ns);
        futureLeftHitbox = new Rectangle((float) nx, (float) player.coordinates.y, (float) player.width, (float) player.height);

        nx = player.coordinates.x + (DISTANCE * ns);
        futureRightHitbox = new Rectangle((float) nx, (float) player.coordinates.y, (float) player.width, (float) player.height);

        double ny = player.coordinates.y + (DISTANCE * ns);
        futureUpHitbox = new Rectangle((float) player.coordinates.x, (float) ny, (float) player.width, (float) player.height);

        ny = player.coordinates.y - Physics.GRAVITY;
        futureDownHitbox = new Rectangle((float) player.coordinates.x, (float) ny, (float) player.width, (float) player.height);
    }

    /**
     * Reset player inputs
     */
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
    public InputMap getInputs() {
        return inputs;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public void render() {

        if (futureUpHitbox != null) {
            shapes.setColor(255, 0, 255, 1);
            shapes.begin(ShapeRenderer.ShapeType.Line);
            shapes.rect(futureUpHitbox.x, futureUpHitbox.y, futureUpHitbox.width, futureUpHitbox.height);
            shapes.end();
        }
        if (futureDownHitbox != null) {
            shapes.setColor(0, 0, 255, 1);
            shapes.begin(ShapeRenderer.ShapeType.Line);
            shapes.rect(futureDownHitbox.x, futureDownHitbox.y, futureDownHitbox.width, futureDownHitbox.height);
            shapes.end();
        }
        if (futureLeftHitbox != null) {
            shapes.setColor(0, 255, 0, 1);
            shapes.begin(ShapeRenderer.ShapeType.Line);
            shapes.rect(futureLeftHitbox.x, futureLeftHitbox.y, futureLeftHitbox.width, futureLeftHitbox.height);
            shapes.end();
        }
        if (futureRightHitbox != null) {
            shapes.begin(ShapeRenderer.ShapeType.Line);
            shapes.setColor(255, 0, 0, 1);
            shapes.rect(futureRightHitbox.x, futureRightHitbox.y, futureRightHitbox.width, futureRightHitbox.height);
            shapes.end();
        }
    }

    @Override
    public void dispose() {

    }
}
