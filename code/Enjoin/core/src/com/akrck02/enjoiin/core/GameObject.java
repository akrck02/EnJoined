package com.akrck02.enjoiin.core;

public abstract class GameObject {

    protected double x;
    protected double y;
    protected double height;
    protected double width;

    public abstract void render();
    public abstract void update();
    public abstract void dispose();

}
