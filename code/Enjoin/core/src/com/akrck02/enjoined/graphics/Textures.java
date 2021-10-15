package com.akrck02.enjoined.graphics;

import com.badlogic.gdx.graphics.Texture;

public class Textures {

    public final static String CHARACTER_DIR = "characters/";
    public final static String BACKGROUNDS_DIR = "backgrounds/";
    public final static String DECORATIONS_DIR = "decorations/";
    public final static String MENU_DIR = "menu/";
    public final static String FONT_DIR = "font/";
    public final static String ITEMS_DIR = "items/";
    public final static String TILES_DIR = "tiles/";

    public final static Texture DEFAULT_TEXTURE = new Texture("default.png");
    public final static Texture HITBOX_TEXTURE = new Texture("hitbox.png");

    //characters
    public final static Texture PLAYER_IDLE = new Texture(CHARACTER_DIR + "PlayerIdle.png");
    public final static Texture PLAYER_NORTH = new Texture(CHARACTER_DIR + "PlayerNorth.png");
    public final static Texture PLAYER_SOUTH = new Texture(CHARACTER_DIR + "PlayerSouth.png");
    public final static Texture PLAYER_EAST = new Texture(CHARACTER_DIR + "PlayerEast.png");
    public final static Texture PLAYER_WEST = new Texture(CHARACTER_DIR + "PlayerWest.png");

    public final static Texture PLAYER_2_IDLE = new Texture(CHARACTER_DIR + "Player2Idle.png");
    public final static Texture PLAYER_2_NORTH = new Texture(CHARACTER_DIR + "Player2North.png");
    public final static Texture PLAYER_2_SOUTH = new Texture(CHARACTER_DIR + "Player2South.png");
    public final static Texture PLAYER_2_EAST = new Texture(CHARACTER_DIR + "Player2East.png");
    public final static Texture PLAYER_2_WEST = new Texture(CHARACTER_DIR + "Player2West.png");

    //backgrounds
    public final static Texture NO_BACKGROUND = new Texture(BACKGROUNDS_DIR + "noBackground.png");
    public final static Texture TUTORIAL_BACKGROUND = new Texture(BACKGROUNDS_DIR + "noBackground.png");
    public final static Texture CITY_BACKGROUND = new Texture(BACKGROUNDS_DIR + "cityBackground.png");
    public final static Texture MENU_BACKGROUND = new Texture(BACKGROUNDS_DIR + "menuBackground.png");
    public final static Texture SPACE_BACKGROUND = NO_BACKGROUND;
    public final static Texture HELL_BACKGROUND = NO_BACKGROUND;
    public final static Texture NORTH_POLE_BACKGROUND = NO_BACKGROUND;
    public final static Texture CHRISTMAS_BACKGROUND = NO_BACKGROUND;

    //background decorations
    public final static Texture CLOUDS = new Texture(DECORATIONS_DIR + "clouds.png");

    //items
    public final static Texture COOKIE = new Texture(ITEMS_DIR + "Cookie.png");
    public final static Texture HEART = new Texture(ITEMS_DIR + "Heart.png");
    public final static Texture HEART_EMPTY = new Texture(ITEMS_DIR + "HeartEmpty.png");

    //tiles
    public final static Texture CITY_BLOCK = new Texture(TILES_DIR + "CityBlockShort.png");
    public final static Texture CHRISTMAS_BLOCK = new Texture(TILES_DIR + "ChristmasBlockShort.png");
    public final static Texture CHRISTMAS_2_BLOCK = new Texture(TILES_DIR + "Christmas2BlockShort.png");
    public final static Texture FOREST_BLOCK = new Texture(TILES_DIR + "ForestBlockShort.png");
    public final static Texture GRASS_BLOCK = new Texture(TILES_DIR + "GrassBlockShort.png");
    public final static Texture HELL_BLOCK = new Texture(TILES_DIR + "HellBlockShort.png");
    public final static Texture SPACE_BLOCK = new Texture(TILES_DIR + "MarsBlockShort.png");
    public final static Texture NORTH_POLE_BLOCK = new Texture(TILES_DIR + "NorthPoleBlockShort.png");

    //menu resources
    public final static Texture MENU_TITLE = new Texture(MENU_DIR + "title.png");
    public final static Texture MENU_LINE = new Texture(MENU_DIR + "line.png");
    public final static Texture MENU_CONTINUE = new Texture(MENU_DIR + "continue.png");
    public final static Texture MENU_CONTINUE_SELECTED = new Texture(MENU_DIR + "continueselected.png");
    public final static Texture MENU_NEW_GAME = new Texture(MENU_DIR + "newgame.png");
    public final static Texture MENU_NEW_GAME_SELECTED = new Texture(MENU_DIR + "newgameselected.png");

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

    public final static Texture CHAR_A = new Texture(FONT_DIR + "A.png");
    public final static Texture CHAR_B = new Texture(FONT_DIR + "B.png");
    public final static Texture CHAR_C = new Texture(FONT_DIR + "C.png");
    public final static Texture CHAR_D = new Texture(FONT_DIR + "D.png");
    public final static Texture CHAR_E = new Texture(FONT_DIR + "E.png");
    public final static Texture CHAR_F = new Texture(FONT_DIR + "F.png");
    public final static Texture CHAR_G = new Texture(FONT_DIR + "G.png");
    public final static Texture CHAR_H = new Texture(FONT_DIR + "H.png");
    public final static Texture CHAR_I = new Texture(FONT_DIR + "I.png");
    public final static Texture CHAR_J = new Texture(FONT_DIR + "J.png");
    public final static Texture CHAR_K = new Texture(FONT_DIR + "K.png");
    public final static Texture CHAR_L = new Texture(FONT_DIR + "L.png");
    public final static Texture CHAR_N = new Texture(FONT_DIR + "N.png");
    public final static Texture CHAR_M = new Texture(FONT_DIR + "M.png");
    public final static Texture CHAR_O = new Texture(FONT_DIR + "O.png");
    public final static Texture CHAR_P = new Texture(FONT_DIR + "P.png");
    public final static Texture CHAR_Q = new Texture(FONT_DIR + "Q.png");
    public final static Texture CHAR_R = new Texture(FONT_DIR + "R.png");
    public final static Texture CHAR_S = new Texture(FONT_DIR + "S.png");
    public final static Texture CHAR_T = new Texture(FONT_DIR + "T.png");
    public final static Texture CHAR_U = new Texture(FONT_DIR + "U.png");
    public final static Texture CHAR_V = new Texture(FONT_DIR + "V.png");
    public final static Texture CHAR_W = new Texture(FONT_DIR + "W.png");
    public final static Texture CHAR_X = new Texture(FONT_DIR + "X.png");
    public final static Texture CHAR_Y = new Texture(FONT_DIR + "Y.png");
    public final static Texture CHAR_Z = new Texture(FONT_DIR + "Z.png");

    public final static Texture CHAR_COLON = new Texture(FONT_DIR + "colon.png");
    public final static Texture CHAR_SEMICOLON = new Texture(FONT_DIR + "semicolon.png");
    public final static Texture CHAR_COMMA = new Texture(FONT_DIR + "comma.png");
    public final static Texture CHAR_DOT = new Texture(FONT_DIR + "dot.png");
    public final static Texture CHAR_INTERROGATION = new Texture(FONT_DIR + "interrogation.png");
    public final static Texture CHAR_EXCLAMATION = new Texture(FONT_DIR + "exclamation.png");

}
