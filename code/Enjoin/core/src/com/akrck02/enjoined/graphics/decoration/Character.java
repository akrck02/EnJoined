package com.akrck02.enjoined.graphics.decoration;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.graphics.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character extends GameObject {

    private SpriteBatch batch;
    private Texture sprite;

    public Character(Texture sprite, double x, double y) {
        this.coordinates = new Vector2D(x,y);
        this.batch = new SpriteBatch();
        this.sprite = sprite;
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(this.sprite,(float) this.coordinates.x, (float) this.coordinates.y , 48,48);
        batch.end();
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {

    }
}
