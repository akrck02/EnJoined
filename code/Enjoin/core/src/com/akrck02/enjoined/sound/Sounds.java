package com.akrck02.enjoined.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sounds {

    public final static String SOUND_DIR = "sounds/";
    public final static String EFFECTS_DIR = SOUND_DIR + "effects/";
    public final static String MUSIC_DIR = SOUND_DIR + "music/";

    public final static Music MAIN_THEME = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_DIR + "enjoined.wav"));

}
