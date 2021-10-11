package com.akrck02.enjoiin.core;


import com.akrck02.enjoiin.core.data.Constants;
import com.akrck02.enjoiin.core.data.Enviroment;
import com.akrck02.enjoiin.core.interfaces.Renderizable;
import com.akrck02.enjoiin.core.interfaces.Updateable;
import com.akrck02.enjoiin.graphics.Textures;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class HitBox implements Renderizable, Updateable {

    private Rectangle rectangle;
    private Player player;
    private  SpriteBatch batch;

    public HitBox (Player player, double width, double height){
        batch = new SpriteBatch();

        this.player = player;
        this.rectangle = new Rectangle();
        rectangle.x = (float) player.coordinates.x;
        rectangle.y = (float) player.coordinates.y;
        rectangle.width = (float) width;
        rectangle.height = (float) height;
    }

    @Override
    public void render() {
        if(Constants.ENVIROMENT == Enviroment.DEBUG){
            Texture texture = Textures.HITBOX_TEXTURE;
            batch.begin();
            batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            batch.end();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void update() {
        rectangle.x = (float) player.coordinates.x;
        rectangle.y = (float) player.coordinates.y;
    }

    public boolean isColliding(HitBox other){
        return  rectangle.overlaps(other.rectangle);
    }

    @Override
    public String toString() {
        return "HitBox{" +
                "rectangle=" + rectangle +
                '}';
    }

}
