package com.akrck02.enjoined.graphics;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Vector2D;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button extends GameObject {

    private SpriteBatch batch;
    private Texture sprite;
    private Texture spriteSelected;
    private boolean selected;

    public Button(Texture sprite,Texture selected, double x, double y){
        this.batch = new SpriteBatch();
        this.sprite = sprite;
        this.spriteSelected = selected;
        this.coordinates = new Vector2D(x,y);
        this.selected = false;
    }

    @Override
    public void render() {
        batch.begin();
        if(selected)
            batch.draw(spriteSelected,(float) this.coordinates.x, (float) this.coordinates.y);
        else
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

    public boolean isSelected() {
        return selected;
    }

    public Button setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }
}
