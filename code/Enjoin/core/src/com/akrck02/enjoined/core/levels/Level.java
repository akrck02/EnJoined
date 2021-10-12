package com.akrck02.enjoined.core.levels;

import com.akrck02.enjoined.Enjoin;
import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.Tile;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.TileRegistry;
import com.akrck02.enjoined.core.interfaces.Renderizable;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.core.savestates.Savestate;
import com.akrck02.enjoined.graphics.Wallpaper;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.LinkedList;
import java.util.List;

public class Level implements Updateable, Renderizable {

    private Vector2D start;
    private Vector2D door;

    private Player player;
    private Player player2;

    private List<GameObject> objects;
    private Wallpaper wallpaper;

    private List<Tile> tiles;
    private List<Tile> items;

    public Level(String url){
        tiles = new LinkedList<>();
        items = new LinkedList<>();
        objects = new LinkedList<>();
        wallpaper = new Wallpaper();

        loadLevel(url);
    }

    /**
     * Load level from the file
     * @param url - The url
     */
    private void loadLevel(String url){

        FileHandle files = Gdx.files.getFileHandle(url, Files.FileType.Internal);
        String file = files.readString();

        file = parseStart(file);
        file = parseDoor(file);
        file = parseTiles(file);
        file = parseItems(file);

    }

    /**
     * Parse the start position from the level file
     * @param content - the file content
     * return cropped file content;
     */
    private String parseStart(String content){

        int lineEnd = content.indexOf("\n");
        String line = content.substring(0,lineEnd).trim();

        String[] vectorArray = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(",");

        double x = Double.parseDouble(vectorArray[0]);
        double y = Double.parseDouble(vectorArray[1]);
        this.start = new Vector2D(x,y);

        content = content.substring(lineEnd + 1);
        return content;
    }

    /**
     * Parse the door position from the level file
     * @param content - the file content
     * return cropped file content;
     */
    private String parseDoor(String content){
        int lineEnd = content.indexOf("\n");
        String line = content.substring(0,lineEnd).trim();

        String[] vectorArray = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(",");

        double x = Double.parseDouble(vectorArray[0]);
        double y = Double.parseDouble(vectorArray[1]);
        this.door = new Vector2D(x,y);

        player2 = new Player(new Savestate(),x,y,64,64,false);

        content = content.substring(lineEnd + 1);
        return content;
    }

    /**
     * Parse the tiles from the level file
     * @param content - the file content
     * return cropped file content;
     */
    private String parseTiles(String content){
        int tilesStart = content.indexOf("tiles:") + 6;
        int tilesEnd = content.indexOf("end");

        String tilesString = content.substring(tilesStart,tilesEnd).trim();
        String[] lines = tilesString.split(";");

        for (String line: lines) {
            line = line.trim();

            String[] vectorArray = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(",");
            String tileID = line.substring(0, line.indexOf(":")).trim();

            double x = Double.parseDouble(vectorArray[0]);
            double y = Double.parseDouble(vectorArray[1]);
            Vector2D vector = new Vector2D(x,y);

            Tile tile = TileRegistry.GLOBAL_TILES.get(tileID).clone();
            tile.setCoordinates(vector);
            tiles.add(tile);
        }

        content = content.substring(tilesEnd + 3);
        content = content.substring(content.indexOf("\n")).trim();

        return content;
    }

    /**
     * Parse the items from the level file
     * @param content - the file content
     * return cropped file content;
     */
    private String parseItems(String content){
        int tilesStart = content.indexOf("items:") + 6;
        int tilesEnd = content.indexOf("end");

        String tilesString = content.substring(tilesStart,tilesEnd).trim();
        String[] lines = tilesString.split(";");

        for (String line: lines) {
            line = line.trim();

            String[] vectorArray = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(",");
            String tileID = line.substring(0, line.indexOf(":")).trim();

            double x = Double.parseDouble(vectorArray[0]);
            double y = Double.parseDouble(vectorArray[1]);
            Vector2D vector = new Vector2D(x,y);

            Tile tile = TileRegistry.GLOBAL_TILES.get(tileID).clone();
            tile.setCoordinates(vector);
            items.add(tile);
        }

        content = content.substring(tilesEnd + 3);
        content = content.substring(content.indexOf("\n")).trim();

        return content;
    }

    @Override
    public void render() {
        wallpaper.render();
        for (Tile tile : tiles)
            tile.render();

        for (Tile tile : items)
            tile.render();

        for (GameObject object: objects)
            object.render();

        player.render();
        player2.render();
    }

    @Override
    public void update() {
        for (Tile tile : tiles){
            tile.update();
            boolean collide = player.getBody().isCollidingNorth(tile.getBody());
            if(collide) System.out.println("Collide!");
        }


        for (GameObject object: objects){
            object.update();
        }


        for (Tile tile : items){
            tile.update();
        }

        player.update();
        player2.update();
        wallpaper.update();
    }

    @Override
    public void dispose() {
        player.dispose();

        for (Tile tile : tiles)
            tile.dispose();

        for (Tile tile : items)
            tile.dispose();

        for (GameObject object: objects)
            object.dispose();


        wallpaper.dispose();

    }


    // Set player
    public Level setPlayers(Player player, Player player2) {
        this.player = player;
        this.player2 = player2;
        return this;
    }

}
