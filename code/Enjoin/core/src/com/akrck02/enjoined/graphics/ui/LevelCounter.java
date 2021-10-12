package com.akrck02.enjoined.graphics.ui;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.graphics.Textures;
import com.akrck02.enjoined.graphics.font.Text;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelCounter extends GameObject {

    private SpriteBatch batch;
    private Player player;
    private Texture levelText;

    public LevelCounter(Player player) {
        this.player = player;
        this.batch = new SpriteBatch();
        this.coordinates = new Vector2D(30, AppData.GAME_HEIGHT - 60);
        this.levelText = Textures.LEVEL_WORD;
    }

    @Override
    public void render() {

        String level = player.getSavestate().getCurrentLevel() + "";

        batch.begin();
        batch.draw(levelText,(float) this.coordinates.x,(float) this.coordinates.y);

        for (int i = 0; i < level.length(); i++) {
            Texture levelNum = Text.font.get(level.charAt(i) + "");
            batch.draw(levelNum,(float) this.coordinates.x + 125 + (25 * (i + 1)),(float) this.coordinates.y -12);
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
