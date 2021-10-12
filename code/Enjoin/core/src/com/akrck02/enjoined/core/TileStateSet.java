package com.akrck02.enjoined.core;

public class TileStateSet {

    private boolean collide;
    private boolean breakable;


    public TileStateSet() {
        this.collide = false;
        this.breakable = false;
    }

    public boolean isCollide() {
        return collide;
    }

    public void setCollide(boolean collide) {
        this.collide = collide;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }
}
