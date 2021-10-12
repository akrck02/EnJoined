package com.akrck02.enjoined.core;

import com.akrck02.enjoined.core.interfaces.Renderizable;
import com.akrck02.enjoined.core.interfaces.Updateable;

public abstract class GameObject implements Renderizable, Updateable {

    protected Vector2D coordinates;
    protected HitBox body;
    protected double height;
    protected double width;

    public abstract void render();
    public abstract void update();
    public abstract void dispose();

    public Vector2D getCoordinates() {
        return coordinates;
    }

    public HitBox getBody() {
        return body;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
