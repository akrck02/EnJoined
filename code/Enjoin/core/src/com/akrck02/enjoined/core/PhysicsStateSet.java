package com.akrck02.enjoined.core;

public class PhysicsStateSet {

    private boolean jumping;
    private boolean falling;

    private boolean collideUp;
    private boolean collideDown;
    private boolean collideLeft;
    private boolean collideRight;

    private boolean futureCollideUp;
    private boolean futureCollideDown;
    private boolean futureCollideLeft;
    private boolean futureCollideRight;

    public PhysicsStateSet() {
        reset();
    }

    public void reset(){
        this.falling = false;
        this.jumping = false;

        this.collideUp = false;
        this.collideDown = false;
        this.collideLeft = false;
        this.collideRight = false;

        this.futureCollideUp = false;
        this.futureCollideDown = false;
        this.futureCollideLeft = false;
        this.futureCollideRight = false;
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

    public boolean isCollideUp() {
        return collideUp;
    }

    public void setCollideUp(boolean collideUp) {
        this.collideUp = collideUp;
    }

    public boolean isCollideDown() {
        return collideDown;
    }

    public void setCollideDown(boolean collideDown) {
        this.collideDown = collideDown;
    }

    public boolean isCollideLeft() {
        return collideLeft;
    }

    public void setCollideLeft(boolean collideLeft) {
        this.collideLeft = collideLeft;
    }

    public boolean isCollideRight() {
        return collideRight;
    }

    public void setCollideRight(boolean collideRight) {
        this.collideRight = collideRight;
    }

    public boolean isFutureCollideUp() {
        return futureCollideUp;
    }

    public void setFutureCollideUp(boolean futureCollideUp) {
        this.futureCollideUp = futureCollideUp;
    }

    public boolean isFutureCollideDown() {
        return futureCollideDown;
    }

    public void setFutureCollideDown(boolean futureCollideDown) {
        this.futureCollideDown = futureCollideDown;
    }

    public boolean isFutureCollideLeft() {
        return futureCollideLeft;
    }

    public void setFutureCollideLeft(boolean futureCollideLeft) {
        this.futureCollideLeft = futureCollideLeft;
    }

    public boolean isFutureCollideRight() {
        return futureCollideRight;
    }

    public void setFutureCollideRight(boolean futureCollideRight) {
        this.futureCollideRight = futureCollideRight;
    }
}
