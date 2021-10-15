package com.akrck02.enjoined.core.levels;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.Player;
import com.akrck02.enjoined.core.Tile;
import com.akrck02.enjoined.core.Vector2D;
import com.akrck02.enjoined.core.interfaces.Renderizable;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.graphics.Wallpaper;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.LinkedList;
import java.util.List;

public class Level implements Updateable, Renderizable {

    private Vector2D start = new Vector2D(0,0);
    private Vector2D door = new Vector2D(64,64);

    private Player player;
    private Player player2;

    private List<GameObject> objects;
    private Wallpaper wallpaper;

    private List<Tile> tiles;
    private List<Tile> items;

    private LevelParser parser;

    public Level(Player player, Player player2, String url) {
        this.player = player;
        this.player2 = player2;

        tiles = new LinkedList<>();
        items = new LinkedList<>();
        objects = new LinkedList<>();

        parser = new DiskLevelParser(this);
        wallpaper = new Wallpaper();
        loadLevel(url);
    }

    public Level(Level other) {
        tiles = other.tiles;
        items = other.items;
        objects = other.objects;
        parser = new DiskLevelParser(this);

        wallpaper = other.wallpaper;
        door = other.door;
        start = other.start;
        player = other.player;
        player2 = other.player2;
    }


    /**
     * Load level from the file
     *
     * @param url - The url
     */
    private void loadLevel(String url) {

        FileHandle files = Gdx.files.getFileHandle(url, Files.FileType.Internal);
        String file = files.readString();

        file = this.parser.parseStart(file);
        file = this.parser.parseDoor(file);
        file = this.parser.parseTiles(file);
        file = this.parser.parseItems(file);

    }

    @Override
    public void render() {
        wallpaper.render();
        for (Tile tile : tiles)
            tile.render();

        for (Tile tile : items)
            tile.render();

        for (GameObject object : objects)
            object.render();

        player.render();
        player2.render();
    }

    @Override
    public void update() {

        for (Tile tile : tiles) {
            tile.update();
            checkCollisions(player, tile);
            checkCollisions(player2, tile);
        }


        for (GameObject object : objects) {
            object.update();
        }


        for (Tile tile : items) {
            tile.update();
        }

        player.update();
        player2.update();
        wallpaper.update();
    }

    public void checkCollisions(Player player, GameObject object) {
        boolean colliding = player.getBody().isColliding(object.getBody());
        if (colliding) {
            boolean collideUp = player.getBody().isCollidingUp(object.getBody());
            boolean collideDown = player.getBody().isCollidingDown(object.getBody());
            boolean collideLeft = player.getBody().isCollidingLeft(object.getBody());
            boolean collideRight = player.getBody().isCollidingRight(object.getBody());

            if (collideUp) {
                player.getPhysicStates().setCollideUp(true);

                double dy = (object.getCoordinates().y - player.getCoordinates().y);
                player.getController().setDeltaY(-dy);
            }
            if (collideDown) {
                double dy = (player.getCoordinates().y - object.getCoordinates().y) + 1;
                player.getController().setDeltaY(dy);
                player.getPhysicStates().setCollideDown(true);
            }
            if (collideLeft) {
                player.getPhysicStates().setCollideLeft(true);

                double dx = (player.getCoordinates().x - object.getCoordinates().x );
                player.getController().setDeltaX(dx);
            }
            if (collideRight) {
                player.getPhysicStates().setCollideRight(true);

                double dx = (object.getCoordinates().x - player.getCoordinates().x);
                player.getController().setDeltaX(-dx);
            }
        }

    }

    @Override
    public void dispose() {
        player.dispose();

        for (Tile tile : tiles)
            tile.dispose();

        for (Tile tile : items)
            tile.dispose();

        for (GameObject object : objects)
            object.dispose();


        wallpaper.dispose();

    }

    /**
     * Clone this level
     * @return
     */
    public Level clone(){
        return new Level(this);
    }

    // Set player
    public Level setPlayers(Player player, Player player2) {
        this.player = player;
        this.player2 = player2;
        return this;
    }

    public Level setStart(Vector2D start) {
        this.start = start;
        return this;
    }

    public Level setDoor(Vector2D door) {
        this.door = door;
        return this;
    }

    public List<Tile> getItems() {
        return items;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getPlayer2() {
        return player2;
    }
}
