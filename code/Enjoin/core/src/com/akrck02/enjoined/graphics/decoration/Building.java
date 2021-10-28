package com.akrck02.enjoined.graphics.decoration;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Building extends GameObject {

    public static enum BuildingType {
        SMALL(Textures.SMALL_BUILDING,144,224),
        LARGE(Textures.LARGE_BUILDING,144,296),
        BIG(Textures.BIG_BUILDING,210,365);

        private final Texture texture;
        private final int width;
        private final int height;

        BuildingType(Texture texture, int width,int height){
            this.texture = texture;
            this.width = width;
            this.height = height;
        }

        public Texture getTexture() {
            return texture;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    private final BuildingType type;
    private final SpriteBatch batch;

    public Building(BuildingType type, double x, double y){
        this.coordinates = new Vector2D(x,y);
        this.type = type;
        this.batch = new SpriteBatch();
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(type.getTexture(), (float) this.coordinates.x, (float) this.coordinates.y);
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
