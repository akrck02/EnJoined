package com.akrck02.enjoined.core;

import com.akrck02.enjoined.Enjoin;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.data.Enviroment;
import com.akrck02.enjoined.core.savestates.Savestate;
import com.akrck02.enjoined.graphics.Direction;
import com.akrck02.enjoined.graphics.Sprite;
import com.akrck02.enjoined.graphics.Textures;
import com.akrck02.enjoined.input.InputMap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.vm.ci.meta.Constant;

import java.util.HashMap;

public class Player extends GameObject {

    private SpriteBatch batch;
    private Sprite sprite;
    private PlayerController controller;
    private PhysicsStateSet physicsStateSet;
    private Enjoin game;

    //stats
    private int lifes;
    private Savestate savestate;

    public Player(Enjoin game,double x, double y, double width, double height,boolean playerOne) {
        this.game = game;
        this.coordinates = new Vector2D(x, y);
        this.width = width;
        this.lifes = 3;
        this.height = height;
        this.body = new HitBox(this, width, height);
        this.controller = new PlayerController(game, this, new InputMap());
        this.physicsStateSet = new PhysicsStateSet();
        this.savestate = game.getSavestate();
        this.savestate.setCookies(0);


        HashMap<Direction, Texture> sprites = new HashMap<>();
        if(playerOne){
            sprites.put(Direction.IDLE, Textures.PLAYER_IDLE);
            sprites.put(Direction.NORTH, Textures.PLAYER_NORTH);
            sprites.put(Direction.SOUTH, Textures.PLAYER_SOUTH);
            sprites.put(Direction.EAST, Textures.PLAYER_EAST);
            sprites.put(Direction.WEST, Textures.PLAYER_WEST);
        } else {
            sprites.put(Direction.IDLE, Textures.PLAYER_2_IDLE);
            sprites.put(Direction.NORTH, Textures.PLAYER_2_NORTH);
            sprites.put(Direction.SOUTH, Textures.PLAYER_2_SOUTH);
            sprites.put(Direction.EAST, Textures.PLAYER_2_EAST);
            sprites.put(Direction.WEST, Textures.PLAYER_2_WEST);
        }

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

        if(AppData.ENVIROMENT == Enviroment.DEBUG)
            controller.render();
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

    public PhysicsStateSet getPhysicStates() {
        return physicsStateSet;
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
                "states=" + physicsStateSet +
                '}';
    }
}
