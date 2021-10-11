package com.akrck02.enjoiin.core;

import com.akrck02.enjoiin.core.data.Constants;
import com.akrck02.enjoiin.core.savestates.Savestate;
import com.akrck02.enjoiin.graphics.Direction;
import com.akrck02.enjoiin.graphics.Sprite;
import com.akrck02.enjoiin.graphics.Textures;
import com.akrck02.enjoiin.input.InputMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class Player extends GameObject {

    private SpriteBatch batch;
    private Sprite sprite;
    private PlayerController controller;
    private StateSet states;

    //stats
    private int lifes;
    private Savestate savestate;

    public Player(Savestate savestate,double x, double y, double width, double height) {
        this.coordinates = new Vector2D(x, y);
        this.width = width;
        this.lifes = 1;
        this.height = height;
        this.body = new HitBox(this, width, height);
        this.controller = new PlayerController(this, new InputMap());
        this.states = new StateSet();
        this.savestate = savestate;

        HashMap<Direction, Texture> sprites = new HashMap<>();
        sprites.put(Direction.IDLE, Textures.PLAYER_IDLE);
        sprites.put(Direction.NORTH, Textures.PLAYER_NORTH);
        sprites.put(Direction.SOUTH, Textures.PLAYER_SOUTH);
        sprites.put(Direction.EAST, Textures.PLAYER_EAST);
        sprites.put(Direction.WEST, Textures.PLAYER_WEST);

        batch = new SpriteBatch();
        this.sprite = new Sprite(sprites);
        this.sprite.setCurrent(Direction.IDLE);
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(this.sprite.getCurrent(), (float) this.coordinates.x, (float) this.coordinates.y);
        batch.end();
        body.render();
    }

    @Override
    public void update() {
        controller.update();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }


    //Get and set properties
    public Sprite getSprite() {
        return sprite;
    }

    public PlayerController getController() {
        return controller;
    }

    public StateSet getStates() {
        return states;
    }

    public InputMap getInputs() {
        return controller.getInputs();
    }

    public Savestate getSavestate() {
        return savestate;
    }

    public int getLifes() {
        return lifes;
    }

    //to string
    @Override
    public String toString() {
        return "Player{" +
                "states=" + states +
                '}';
    }
}
