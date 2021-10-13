package com.akrck02.enjoined.core;

public class MoveStateSet {

    private boolean falling;
    private boolean jumping;
    private boolean accelerating;
    private boolean decelerating;

    private boolean collideUp;
    private boolean collideDown;
    private boolean collideLeft;
    private boolean collideRight;

    public MoveStateSet() {
        this.falling = false;
        this.jumping = false;
        this.accelerating = false;
        this.decelerating = false;

        this.collideUp = false;
        this.collideDown = false;
        this.collideLeft = false;
        this.collideRight = false;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isAccelerating() {
        return accelerating;
    }

    public boolean isDecelerating() {
        return decelerating;
    }

    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    public void setDecelerating(boolean decelerating) {
        this.decelerating = decelerating;
    }

    public boolean isCollideUp() {
        return collideUp;
    }

    public MoveStateSet setCollideUp(boolean collideUp) {
        this.collideUp = collideUp;
        return this;
    }

    public boolean isCollideDown() {
        return collideDown;
    }

    public MoveStateSet setCollideDown(boolean collideDown) {
        this.collideDown = collideDown;
        return this;
    }

    public boolean isCollideLeft() {
        return collideLeft;
    }

    public MoveStateSet setCollideLeft(boolean collideLeft) {
        this.collideLeft = collideLeft;
        return this;
    }

    public boolean isCollideRight() {
        return collideRight;
    }

    public MoveStateSet setCollideRight(boolean collideRight) {
        this.collideRight = collideRight;
        return this;
    }
}
