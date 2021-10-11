package com.akrck02.enjoiin.core;

import com.akrck02.enjoiin.graphics.Direction;
import com.akrck02.enjoiin.graphics.Sprite;
import com.akrck02.enjoiin.graphics.Textures;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class Player extends GameObject{

    private SpriteBatch batch;
    private Sprite sprite;

    public Player(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        HashMap<Direction, Texture> sprites = new HashMap<>();
        sprites.put(Direction.IDLE,Textures.PLAYER_IDLE);
        sprites.put(Direction.NORTH,Textures.PLAYER_NORTH);
        sprites.put(Direction.SOUTH,Textures.PLAYER_SOUTH);
        sprites.put(Direction.EAST,Textures.PLAYER_EAST);
        sprites.put(Direction.WEST,Textures.PLAYER_WEST);

        batch = new SpriteBatch();
        this.sprite = new Sprite(sprites);
        this.sprite.setCurrent(Direction.IDLE);
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(this.sprite.getCurrent(), (float) this.x, (float) this.y);
        batch.end();
    }

    @Override
    public void update() {

        if(y > 0){
            this.y -= 300 * Gdx.graphics.getDeltaTime();
        }

    }


    public void moveUp(){
        this.sprite.setCurrent(Direction.NORTH);
    }

    public void moveDown(){
        this.sprite.setCurrent(Direction.SOUTH);
    }

    public void moveLeft(){
        this.sprite.setCurrent(Direction.WEST);
        final double acceleration = 200;
        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double newX = this.x - acceleration * deltaTime;

        if(newX > 0)
            this.x = newX;

    }

    public void moveRight(){
        this.sprite.setCurrent(Direction.EAST);
        final double acceleration = 200;
        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double newX = this.x + acceleration * deltaTime;

        if(newX < Constants.SCREEN_WIDTH - this.width)
            this.x = newX;
    }

    public void jump(){

        final double deltaTime = Gdx.graphics.getDeltaTime();
        final double acceleration = 700;
        final double maxDifference = 200;

        double lastY = this.y;

        double newY = this.y + acceleration * deltaTime;
        double deltaY = newY - lastY;

        if(deltaY < maxDifference && newY < Constants.SCREEN_HEIGHT - this.height)
            this.y = newY;
    }

    public void action(){

    }


    public void move(){

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            moveLeft();

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            moveRight();

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            moveUp();

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            moveDown();

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
            jump();

    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
