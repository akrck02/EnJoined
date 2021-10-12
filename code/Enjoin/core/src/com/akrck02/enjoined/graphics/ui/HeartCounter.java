package com.akrck02.enjoined.graphics.ui;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.Constants;
import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HeartCounter extends GameObject {

    private SpriteBatch batch;
    private Player player;

    public HeartCounter(Player player) {
        this.coordinates = new Vector2D( Constants.GAME_WIDTH - 130, Constants.GAME_HEIGHT - 80);
        this.player = player;
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        int lifes = player.getLifes();
        batch.begin();
        for (int i = 1; i <= 3; i++) {
            Texture current = Textures.HEART;
            if(i > lifes)
                current = Textures.HEART_EMPTY;

            batch.draw(current,(float) this.coordinates.x + 20 * i, (float) this.coordinates.y);
        }
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
