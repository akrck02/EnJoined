package com.akrck02.enjoiin.core;

import com.akrck02.enjoiin.core.interfaces.Renderizable;
import com.akrck02.enjoiin.core.interfaces.Updateable;

public abstract class GameObject implements Renderizable, Updateable {

    protected Vector2D coordinates;
    protected HitBox body;
    protected double height;
    protected double width;

    public abstract void render();
    public abstract void update();
    public abstract void dispose();


}
