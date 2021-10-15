package com.akrck02.enjoined.graphics.decoration;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Clouds extends GameObject {

    private SpriteBatch batch;
    private Texture sprite;
    private double baseY;
    private boolean ascending;

    private final double SPEED = .3;
    private final double DISTANCE = 30;

    public Clouds (double x, double y){
        this.batch = new SpriteBatch();
        this.coordinates = new Vector2D(x,y);
        this.baseY = y;

        double random = Math.random();
        this.ascending = random > 0.45;
        System.out.println(ascending);
        this.sprite = Textures.CLOUDS;
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(sprite,(float) this.coordinates.x, (float) this.coordinates.y);
        batch.end();
    }

    @Override
    public void update() {
        if(ascending){
            this.coordinates.y -= SPEED;
            if(this.coordinates.y < baseY - DISTANCE)
                ascending = false;
        }else {
            this.coordinates.y += SPEED;
            if(this.coordinates.y > baseY)
                ascending = true;

        }
    }

    @Override
    public void dispose() {
    batch.dispose();
    }
}
