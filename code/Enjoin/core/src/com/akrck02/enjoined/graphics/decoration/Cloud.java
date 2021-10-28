package com.akrck02.enjoined.graphics.decoration;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cloud extends GameObject {

    private final SpriteBatch batch;
    private final Texture texture;

    public static final int HEIGHT = 167;
    public static final int WIDTH = 268;

    private static final double SPEED = 1d / 172;
    private static final double DISTANCE = 100d;

    private double delta;

    public Cloud(double x , double y) {
        batch = new SpriteBatch();
        this.coordinates = new Vector2D(x,y);
        this.texture = Textures.CLOUD;
        this.delta = Math.random() * 71;
    }


    @Override
    public void render() {
        batch.begin();
        batch.draw(this.texture, (float) this.coordinates.x , (float) this.coordinates.y);
        batch.end();
    }

    @Override
    public void update() {

        if(this.coordinates.x <= -WIDTH){
            this.coordinates.x = AppData.SCREEN_WIDTH;


            double up = Math.random() * 11;
            double r = Math.random() * 21;
            if(up > 5) r = -r;

            r = r /100;

            this.coordinates.y += (this.coordinates.y * r);
            this.delta = Math.random() * 71;
        }

        this.coordinates.x -= DISTANCE * (SPEED + SPEED * (delta/100));

    }



    @Override
    public void dispose() {
        batch.dispose();
    }
}
