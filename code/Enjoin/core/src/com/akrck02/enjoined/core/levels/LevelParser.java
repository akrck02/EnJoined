package com.akrck02.enjoined.core.levels;

public interface LevelParser {

    String parseStart(String content);
    String parseDoor(String content);
    String parseTiles(String content);
    String parseItems(String content);

}
