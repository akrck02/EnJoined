package com.akrck02.enjoined.graphics.font;

import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Text {

    public static int WIDTH = 30;
    public static int HEIGHT = 60;

    public static HashMap<String, Texture> font;
    static {
        font = new HashMap<>();
        font.put("0", Textures.CHAR_0);
        font.put("1", Textures.CHAR_1);
        font.put("2", Textures.CHAR_2);
        font.put("3", Textures.CHAR_3);
        font.put("4", Textures.CHAR_4);
        font.put("5", Textures.CHAR_5);
        font.put("6", Textures.CHAR_6);
        font.put("7", Textures.CHAR_7);
        font.put("8", Textures.CHAR_8);
        font.put("9", Textures.CHAR_9);
    }

}
