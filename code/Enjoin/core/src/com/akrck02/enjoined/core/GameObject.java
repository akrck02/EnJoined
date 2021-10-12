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


}
