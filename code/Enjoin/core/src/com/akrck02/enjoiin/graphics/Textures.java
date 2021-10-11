package com.akrck02.enjoiin.graphics;

import com.badlogic.gdx.graphics.Texture;

public class Textures {

    public final static String CHARACTER_DIR = "characters/";
    public final static String BACKGROUNDS_DIR = "backgrounds/";
    public final static String FONT_DIR = "font/";
    public final static String ITEMS_DIR = "items/";
    public final static String TILES_DIR = "tiles/";

    public final static Texture DEFAULT_TEXTURE = new Texture("default.png");
    public final static Texture HITBOX_TEXTURE = new Texture("hitbox.png");

    public final static Texture PLAYER_IDLE = new Texture(CHARACTER_DIR + "PlayerIdle.png");
    public final static Texture PLAYER_NORTH = new Texture(CHARACTER_DIR + "PlayerNorth.png");
    public final static Texture PLAYER_SOUTH = new Texture(CHARACTER_DIR + "PlayerSouth.png");
    public final static Texture PLAYER_EAST = new Texture(CHARACTER_DIR + "PlayerEast.png");
    public final static Texture PLAYER_WEST = new Texture(CHARACTER_DIR + "PlayerWest.png");

    public final static Texture NO_BACKGROUND = new Texture(BACKGROUNDS_DIR + "noBackground.png");
    public final static Texture TUTORIAL_BACKGROUND = new Texture(BACKGROUNDS_DIR + "noBackground.png");
    public final static Texture CITY_BACKGROUND = new Texture(BACKGROUNDS_DIR + "CityBackground.png");
    public final static Texture SPACE_BACKGROUND = NO_BACKGROUND;
    public final static Texture HELL_BACKGROUND = NO_BACKGROUND;
    public final static Texture NORTH_POLE_BACKGROUND = NO_BACKGROUND;
    public final static Texture CHRISTMAS_BACKGROUND = NO_BACKGROUND;

    public final static Texture COOKIE = new Texture(ITEMS_DIR + "Cookie.png");
    public final static Texture HEART = new Texture(ITEMS_DIR + "Heart.png");
    public final static Texture HEART_EMPTY = new Texture(ITEMS_DIR + "HeartEmpty.png");

    //text resources
    public final static Texture LEVEL_WORD = new Texture(FONT_DIR + "Level.png");
    public final static Texture CHAR_0 = new Texture(FONT_DIR + "0.png");
    public final static Texture CHAR_1 = new Texture(FONT_DIR + "1.png");
    public final static Texture CHAR_2 = new Texture(FONT_DIR + "2.png");
    public final static Texture CHAR_3 = new Texture(FONT_DIR + "3.png");
    public final static Texture CHAR_4 = new Texture(FONT_DIR + "4.png");
    public final static Texture CHAR_5 = new Texture(FONT_DIR + "5.png");
    public final static Texture CHAR_6 = new Texture(FONT_DIR + "6.png");
    public final static Texture CHAR_7 = new Texture(FONT_DIR + "7.png");
    public final static Texture CHAR_8 = new Texture(FONT_DIR + "8.png");
    public final static Texture CHAR_9 = new Texture(FONT_DIR + "9.png");


}
