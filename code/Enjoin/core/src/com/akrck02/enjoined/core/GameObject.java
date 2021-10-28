package com.akrck02.enjoined.core;

import com.akrck02.enjoined.core.interfaces.Renderizable;
import com.akrck02.enjoined.core.interfaces.Updateable;

public abstract class GameObject implements Renderizable, Updateable {

    protected Vector2D coordinates;
    protected HitBox body;
    protected double height;
    protected double width;
    protected PhysicsStateSet physicsStateSet;

    /**
     * Render the gameObject into the screen
     */
    public abstract void render();

    /**
     * Update gameObject states and variables
     */
    public abstract void update();

    /**
     * Dispose the graphic resources
     */
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
