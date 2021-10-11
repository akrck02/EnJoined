package com.akrck02.enjoiin.core.collectionables;

import com.akrck02.enjoiin.core.GameObject;
import com.akrck02.enjoiin.core.Vector2D;
import com.akrck02.enjoiin.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cookie extends GameObject {

    public static final double HEIGHT = 64;
    public static final double WIDTH = 64;

    private SpriteBatch batch;
    private Texture sprite;

    public Cookie(double x, double y){
        this.coordinates = new Vector2D(x,y);
        this.batch = new SpriteBatch();
        this.sprite = Textures.COOKIE;
    }

    @Override
    public void render() {
        System.out.println("Rendering cookie");
        batch.begin();
        System.out.println(this.coordinates);
        batch.draw(sprite,(float) this.coordinates.x, (float) this.coordinates.y);
        batch.end();
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
