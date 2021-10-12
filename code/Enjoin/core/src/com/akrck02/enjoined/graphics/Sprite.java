package com.akrck02.enjoined.graphics;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Sprite {

    private Texture current;
    private HashMap<Direction, Texture> sprites;

    public Sprite(HashMap<Direction, Texture> sprites){
        this.sprites = sprites;
    }

    public void setCurrent(Direction direction){
        current = this.sprites.get(direction);
    }

    public Texture getCurrent() {
        return this.current;
    }

}
