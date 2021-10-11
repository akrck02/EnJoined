package com.akrck02.enjoiin.graphics;

import com.akrck02.enjoiin.core.data.Constants;
import com.akrck02.enjoiin.core.GameObject;
import com.akrck02.enjoiin.core.Vector2D;
import com.akrck02.enjoiin.core.data.Zones;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class Wallpaper extends GameObject {

    private Texture current;
    private HashMap<Zones, Texture> wallpapers;
    private SpriteBatch batch;

    public Wallpaper(){

        this.batch = new SpriteBatch();
        this.coordinates = new Vector2D(0,0);
        this.width = Constants.SCREEN_WIDTH;
        this.height = Constants.SCREEN_HEIGHT;

        this.wallpapers = new HashMap<>();
        this.wallpapers.put(Zones.TUTORIAL,Textures.TUTORIAL_BACKGROUND);
        this.wallpapers.put(Zones.CITY,Textures.CITY_BACKGROUND);
        this.wallpapers.put(Zones.SPACE,Textures.SPACE_BACKGROUND);
        this.wallpapers.put(Zones.HELL,Textures.HELL_BACKGROUND);
        this.wallpapers.put(Zones.NORTH_POLE,Textures.NORTH_POLE_BACKGROUND);
        this.wallpapers.put(Zones.CHRISTMAS,Textures.CHRISTMAS_BACKGROUND);

        this.current = this.wallpapers.get(Zones.CITY);
    }

    public void setCurrent(Zones zone){
        this.current = this.wallpapers.get(zone);
    }

    public Texture getCurrent() {
        return this.current;
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(this.current, (float) this.coordinates.x, (float) this.coordinates.y);
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
