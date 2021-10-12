package com.akrck02.enjoined.core;


import com.akrck02.enjoined.core.data.AppData;
import com.akrck02.enjoined.core.data.Enviroment;
import com.akrck02.enjoined.core.interfaces.Renderizable;
import com.akrck02.enjoined.core.interfaces.Updateable;
import com.akrck02.enjoined.graphics.Textures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class HitBox implements Renderizable, Updateable {

    private Rectangle rectangle;
    private GameObject object;
    private  SpriteBatch batch;

    public HitBox (GameObject object, double width, double height){
        batch = new SpriteBatch();

        this.object = object;
        this.rectangle = new Rectangle();
        rectangle.x = (float) object.coordinates.x;
        rectangle.y = (float) object.coordinates.y;
        rectangle.width = (float) width;
        rectangle.height = (float) height;
    }

    @Override
    public void render() {
        if(AppData.ENVIROMENT == Enviroment.DEBUG){
            Texture texture = Textures.HITBOX_TEXTURE;
            batch.begin();
            batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            batch.end();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void update() {
        rectangle.x = (float) object.coordinates.x;
        rectangle.y = (float) object.coordinates.y;
    }

    /**
     * Check if hitbox is colliding
     * @param other
     * @return boolean
     */
    public boolean isColliding(HitBox other){
        return  rectangle.overlaps(other.rectangle);
    }

    /**
     * Check if the body is colliding in the north
     * of the other hitbox
     * @param other - The other hitbox
     * @return boolean
     */
    public boolean isCollidingNorth(HitBox other) {
        Rectangle minirec = new Rectangle();
        minirec.height = 1;
        minirec.width = rectangle.width;
        minirec.x = rectangle.x;
        minirec.y = rectangle.y + (rectangle.height - 1);

        return minirec.overlaps(other.rectangle);
    }

    /**
     * Check if the body is colliding in the south
     * of the other hitbox
     * @param other - The other hitbox
     * @return boolean
     */
    public boolean isCollidingSouth(HitBox other) {
        Rectangle minirec = new Rectangle();
        minirec.height = 1;
        minirec.width = rectangle.width;
        minirec.x = rectangle.x;
        minirec.y = rectangle.y;

        return minirec.overlaps(other.rectangle);
    }

    /**
     * Check if the body is colliding in the left
     * of the other hitbox
     * @param other - The other hitbox
     * @return boolean
     */
    public boolean isCollidingLeft(HitBox other) {
        Rectangle minirec = new Rectangle();
        minirec.height = rectangle.height;
        minirec.width = 1;
        minirec.x = rectangle.x;
        minirec.y = rectangle.y;

        return minirec.overlaps(other.rectangle);
    }

    /**
     * Check if the body is colliding in the right
     * of the other hitbox
     * @param other - The other hitbox
     * @return boolean
     */
    public boolean isCollidingRight(HitBox other) {
        Rectangle minirec = new Rectangle();
        minirec.height = rectangle.height;
        minirec.width = 1;
        minirec.x = rectangle.x + rectangle.width - 1;
        minirec.y = rectangle.y;

        return minirec.overlaps(other.rectangle);
    }




    @Override
    public String toString() {
        return "HitBox{" +
                "rectangle=" + rectangle +
                '}';
    }

}
