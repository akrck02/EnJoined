package com.akrck02.enjoined.graphics.wallpaper;

import com.akrck02.enjoined.core.GameObject;
import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.graphics.Textures;
import com.akrck02.enjoined.graphics.decoration.Building;
import com.akrck02.enjoined.graphics.decoration.Cloud;

public class CityWallpaper extends Wallpaper{

    public CityWallpaper() {
        super(Textures.CITY_BACKGROUND);
        generateClouds();
        generateBuildings();
    }

    /**
     * Generate buildings in semi random pattern
     */
    private void generateClouds() {
        int n = (int) (1 + Math.random() * 10);

        double last = 0;

        for (int i = 0; i < n; i++) {
            double y = 400 + Math.random() * 100;
            double x =  last  + Cloud.WIDTH/1.2d + (AppData.SCREEN_WIDTH * ((Math.random() * 50)/100));

            Cloud c = new Cloud(x, y);
            objects.add(c);
            last = x;
        }
    }

    /**
     * Generate clouds in semi random patterns
     */
    private void generateBuildings() {

        int n = (int) (5 + Math.random() * 5);
        double ratio = 0;
        double last = 0;
        double lastWidth = 0;

        for (int i = 0; i < n; i++) {
            Building.BuildingType type = null;

            double r = Math.random();
            if(r <= 0.153) type = Building.BuildingType.BIG;
            else if(r < 0.666) type = Building.BuildingType.SMALL;
            else type = Building.BuildingType.LARGE;

            ratio = (Math.random() * 40) / 100;
            double x = last + lastWidth + (lastWidth * ratio);
            double y = 0;

            Building b = new Building(type,x,y);
            objects.push(b);

            lastWidth = type.getWidth();
            last = x;
        }

    }

    @Override
    public void render() {
        this.batch.begin();
        this.batch.draw(this.background, (float) this.coordinates.x, (float) this.coordinates.y);
        this.batch.end();

        for (GameObject object: objects)
            object.render();
    }

    @Override
    public void update() {

        for (GameObject object: objects)
            object.update();

    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
}
