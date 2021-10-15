package com.akrck02.enjoined.core.levels;

import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.Tile;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.data.TileRegistry;

public class DiskLevelParser implements LevelParser{

    private Level level;

    public DiskLevelParser(Level level){
        this.level = level;
    }

    /**
     * Parse the start position from the level file
     * @param content - the file content
     * return cropped file content;
     */
    @Override
    public String parseStart(String content) {
        int lineEnd = content.indexOf("\n");
        String line = content.substring(0,lineEnd).trim();

        String[] vectorArray = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(",");

        double x = Double.parseDouble(vectorArray[0]);
        double y = Double.parseDouble(vectorArray[1]);
        this.level.setStart(new Vector2D(x,y));

        Player player = this.level.getPlayer();

        if(player != null){
            Vector2D playerVector = player.getCoordinates();
            playerVector.x = x;
            playerVector.y = y;
        }

        content = content.substring(lineEnd + 1);
        return content;
    }

    /**
     * Parse the door position from the level file
     * @param content - the file content
     * return cropped file content;
     */
    @Override
    public String parseDoor(String content) {
        int lineEnd = content.indexOf("\n");
        String line = content.substring(0,lineEnd).trim();

        String[] vectorArray = line.substring(line.indexOf("[") + 1, line.indexOf("]")).split(",");

        double x = Double.parseDouble(vectorArray[0]);
        double y = Double.parseDouble(vectorArray[1]);
        level.setDoor(new Vector2D(x,y));

        Player player = this.level.getPlayer2();
        if(player != null){
            Vector2D playerVector = player.getCoordinates();
            playerVector.x = x;
            playerVector.y = y;
        }

        content = content.substring(lineEnd + 1);
        return content;
    }

    /**
     * Parse the tiles from the level file
     * @param content - the file content
     * return cropped file content;
     */
    @Override
    public String parseTiles(String content) {
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
            level.getTiles().add(tile);
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
    @Override
    public String parseItems(String content) {
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
            this.level.getItems().add(tile);
        }

        content = content.substring(tilesEnd + 3);
        content = content.substring(content.indexOf("\n")).trim();

        return content;
    }
}
