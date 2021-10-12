package com.akrck02.enjoined.core.levels;

import com.akrck02.enjoined.core.data.Zones;

import java.util.HashMap;
import java.util.LinkedList;

public class LevelRegistry {

    public static final String LEVEL_DIR = "levels/";
    public static final HashMap<Zones, LinkedList<Level>> LEVELS;
    static {
        LEVELS = new HashMap();

        LinkedList<Level> tutorial = new LinkedList<Level>();
        LinkedList<Level> city = new LinkedList<>();
        LinkedList<Level> hell = new LinkedList<>();
        LinkedList<Level> space = new LinkedList<>();
        LinkedList<Level> northPole = new LinkedList<>();
        LinkedList<Level> christmas = new LinkedList<>();

        tutorial.add(new Level(LEVEL_DIR + "1.lvl"));

        LEVELS.put(Zones.TUTORIAL, tutorial);
        LEVELS.put(Zones.CITY, city);
        LEVELS.put(Zones.HELL, hell);
        LEVELS.put(Zones.SPACE, space);
        LEVELS.put(Zones.NORTH_POLE, northPole);
        LEVELS.put(Zones.CHRISTMAS, christmas);

    }

}
