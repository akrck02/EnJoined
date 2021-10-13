package com.akrck02.enjoined.graphics.ui;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.graphics.Textures;
import com.akrck02.enjoined.graphics.font.Text;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CookieCounter extends GameObject {

    private Player player;
    private SpriteBatch batch;

    public CookieCounter(Player player){
        this.player = player;
        this.coordinates = new Vector2D(AppData.GAME_WIDTH - 200, AppData.GAME_HEIGHT - 80);
        this.batch = new SpriteBatch();
    }

    @Override
    public void render() {
        batch.begin();

        String cookies = player.getSavestate().getCookies() + "";
        StringBuffer sbr = new StringBuffer(cookies);
        sbr.reverse();
        cookies = sbr.toString();

        for (int i = 0; i < cookies.length(); i++) {
            Texture levelNum = Text.font.get(cookies.charAt(i) + "");
            batch.draw(levelNum,(float) this.coordinates.x - (30 * (i + 1)),(float) this.coordinates.y);
        }

        batch.draw(Textures.COOKIE,(float) this.coordinates.x, (float) this.coordinates.y - 2);
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

