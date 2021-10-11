package com.akrck02.enjoiin.core.savestates;

import com.akrck02.enjoiin.core.data.Levels;
import com.akrck02.enjoiin.core.data.Zones;

public class Savestate {

    private Zones currentZone;
    private int currentLevel;
    private int cookies;

    public Savestate() {
        this.currentZone = Zones.CITY;
        this.currentLevel = 1;
        this.cookies = 0;
    }

    public Zones getCurrentZone() {
        return currentZone;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCookies() {
        return cookies;
    }

    public void setCurrentZone(Zones currentZone) {
        this.currentZone = currentZone;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }
}
