package com.akrck02.enjoined.core.data;

import com.akrck02.enjoined.core.Tile;
import com.akrck02.enjoined.core.TileStateSet;
import com.akrck02.enjoined.graphics.Textures;

import java.util.HashMap;

public class TileRegistry {

    public static final HashMap<String, Tile> GLOBAL_TILES;
    static {
        GLOBAL_TILES = new HashMap<>();
        final Tile cookie = new Tile(Textures.COOKIE, new TileStateSet(),0,0,64,64);
        final Tile heart = new Tile(Textures.HEART, new TileStateSet(),0,0,64,64);

        final Tile cityBlock = new Tile(Textures.CITY_BLOCK, new TileStateSet(),0,0,64,64);

        GLOBAL_TILES.put("0",cookie);
        GLOBAL_TILES.put("1",heart);
        GLOBAL_TILES.put("2",cityBlock);
    }


}
