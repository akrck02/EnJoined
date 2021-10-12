package com.akrck02.enjoined.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile extends GameObject {

    private Texture sprite;
    private SpriteBatch batch;
    private TileStateSet states;

    public Tile(Texture sprite, TileStateSet states, double x, double y, double width, double height){
        this.coordinates = new Vector2D(x,y);
        this.sprite = sprite;
        this.states = states;
        this.width = width;
        this.height = height;
        this.body = new HitBox(this,this.width,this.height);
        this.batch = new SpriteBatch();
    }

    /**
     * Clone tile
     * @return
     */
    public Tile clone(){
        return new Tile(this.sprite, this.states, this.coordinates.x, this.coordinates.y, this.height, this.width);
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(sprite, (float) this.coordinates.x, (float) this.coordinates.y, (float) this.width, (float) this.height);
        batch.end();
        this.body.render();
    }

    @Override
    public void update() {
        this.body.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void setCoordinates(Vector2D vector){
        this.coordinates = vector;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "coordinates=" + coordinates +
                ", body=" + body +
                ", height=" + height +
                ", width=" + width +
                ", sprite=" + sprite +
                ", batch=" + batch +
                ", states=" + states +
                '}';
    }
}
