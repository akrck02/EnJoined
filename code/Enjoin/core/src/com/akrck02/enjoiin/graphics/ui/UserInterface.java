package com.akrck02.enjoiin.graphics.ui;

import com.akrck02.enjoiin.core.GameObject;
import com.akrck02.enjoiin.core.Player;

public class UserInterface extends GameObject {

    private Player player;
    private LevelCounter levels;
    private CookieCounter cookies;
    private HeartCounter life;

    public UserInterface(Player player){
        this.player = player;
        this.levels = new LevelCounter(player);
        this.cookies = new CookieCounter(player);
        this.life = new HeartCounter(player);
    }

    @Override
    public void render() {
        levels.render();
        cookies.render();
        life.render();
    }

    @Override
    public void update() {
        levels.update();
        cookies.update();
        life.update();
    }

    @Override
    public void dispose() {
        levels.dispose();
        cookies.dispose();
        life.dispose();
    }
}
