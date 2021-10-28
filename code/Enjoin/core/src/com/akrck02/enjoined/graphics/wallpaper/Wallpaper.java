package com.akrck02.enjoined.graphics.wallpaper;

import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.Zones;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Wallpaper extends GameObject {

    protected Texture background;
    protected SpriteBatch batch;
    protected LinkedList<GameObject> objects;

    public Wallpaper(Texture background){
        this.objects = new LinkedList<>();
        this.batch = new SpriteBatch();
        this.coordinates = new Vector2D(0,0);
        this.width = AppData.SCREEN_WIDTH;
        this.height = AppData.SCREEN_HEIGHT;
        this.background = background;
    }

    @Override
    public abstract void render();

    @Override
    public abstract void update();

    @Override
    public abstract void dispose();
}
