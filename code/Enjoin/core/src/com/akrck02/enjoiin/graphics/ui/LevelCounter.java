package com.akrck02.enjoiin.graphics.ui;

import com.akrck02.enjoiin.core.GameObject;
import com.akrck02.enjoiin.core.Player;
import com.akrck02.enjoiin.core.Vector2D;
import com.akrck02.enjoiin.core.data.Constants;
import com.akrck02.enjoiin.graphics.Textures;
import com.akrck02.enjoiin.graphics.font.Text;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelCounter extends GameObject {

    private SpriteBatch batch;
    private Player player;
    private Texture levelText;

    public LevelCounter(Player player) {
        this.player = player;
        this.batch = new SpriteBatch();
        this.coordinates = new Vector2D(30,Constants.GAME_HEIGHT - 60);
        this.levelText = Textures.LEVEL_WORD;
    }

    @Override
    public void render() {
        Texture levelNum = Text.font.get(player.getSavestate().getCurrentLevel() + "");

        batch.begin();
        batch.draw(levelText,(float) this.coordinates.x,(float) this.coordinates.y);
        batch.draw(levelNum,(float) this.coordinates.x + 180,(float) this.coordinates.y);
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
