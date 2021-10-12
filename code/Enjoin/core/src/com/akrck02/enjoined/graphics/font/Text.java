package com.akrck02.enjoined.graphics.font;

import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Locale;

public class Text {

    public static int WIDTH = 30;
    public static int HEIGHT = 60;
    public static SpriteBatch batch = new SpriteBatch();


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

        font.put("A", Textures.CHAR_A);
        font.put("B", Textures.CHAR_B);
        font.put("C", Textures.CHAR_C);
        font.put("D", Textures.CHAR_D);
        font.put("E", Textures.CHAR_E);
        font.put("F", Textures.CHAR_F);
        font.put("H", Textures.CHAR_H);
        font.put("I", Textures.CHAR_I);
        font.put("J", Textures.CHAR_J);
        font.put("K", Textures.CHAR_K);
        font.put("L", Textures.CHAR_L);
        font.put("M", Textures.CHAR_M);
        font.put("N", Textures.CHAR_N);
        font.put("O", Textures.CHAR_O);
        font.put("P", Textures.CHAR_P);
        font.put("Q", Textures.CHAR_Q);
        font.put("R", Textures.CHAR_R);
        font.put("S", Textures.CHAR_S);
        font.put("T", Textures.CHAR_T);
        font.put("U", Textures.CHAR_U);
        font.put("V", Textures.CHAR_V);
        font.put("W", Textures.CHAR_W);
        font.put("X", Textures.CHAR_X);
        font.put("Y", Textures.CHAR_Y);
        font.put("Z", Textures.CHAR_Z);
    }

    public static void drawText(String text, double x, double y){
     try {
         batch.begin();
         text = text.toUpperCase(Locale.ROOT);

         for (int i = 0; i < text.length(); i++) {
             Texture levelNum = font.get(text.charAt(i) + "");
             if(levelNum != null)
                batch.draw(levelNum, (float) x + (30 * (i + 1)), (float) y - 12);
         }

         batch.end();
     }catch (Exception e){e.printStackTrace();}
    }

}
