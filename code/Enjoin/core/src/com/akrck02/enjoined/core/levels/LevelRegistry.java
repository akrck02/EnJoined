package com.akrck02.enjoined.core.levels;

import com.akrck02.enjoined.core.data.Zones;

import java.util.HashMap;
import java.util.LinkedList;

public class LevelRegistry {

    public static final String LEVEL_DIR = "levels/";
    public static final HashMap<Zones, LinkedList<String>> LEVELS;
    static {
        LEVELS = new HashMap();

        LinkedList<String> tutorial = new LinkedList<>();
        LinkedList<String> city = new LinkedList<>();
        LinkedList<String> hell = new LinkedList<>();
        LinkedList<String> space = new LinkedList<>();
        LinkedList<String> northPole = new LinkedList<>();
        LinkedList<String> christmas = new LinkedList<>();

        tutorial.add(LEVEL_DIR + "1.lvl");
        tutorial.add(LEVEL_DIR + "2.lvl");

        LEVELS.put(Zones.TUTORIAL, tutorial);
        LEVELS.put(Zones.CITY, city);
        LEVELS.put(Zones.HELL, hell);
        LEVELS.put(Zones.SPACE, space);
        LEVELS.put(Zones.NORTH_POLE, northPole);
        LEVELS.put(Zones.CHRISTMAS, christmas);
    }

}
