package com.akrck02.enjoined.core;

public class PhysicsStateSet {

    private boolean ascending;
    private boolean descending;

    private boolean accelerating;
    private boolean decelerating;

    private boolean collideUp;
    private boolean collideDown;
    private boolean collideLeft;
    private boolean collideRight;

    public PhysicsStateSet() {
        reset();
    }

    public void reset(){
        this.descending = false;
        this.ascending = false;
        this.accelerating = false;
        this.decelerating = false;

        this.collideUp = false;
        this.collideDown = false;
        this.collideLeft = false;
        this.collideRight = false;
    }

    public boolean isDescending() {
        return descending;
    }

    public void setDescending(boolean descending) {
        this.descending = descending;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
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

    public PhysicsStateSet setCollideUp(boolean collideUp) {
        this.collideUp = collideUp;
        return this;
    }

    public boolean isCollideDown() {
        return collideDown;
    }

    public PhysicsStateSet setCollideDown(boolean collideDown) {
        this.collideDown = collideDown;
        return this;
    }

    public boolean isCollideLeft() {
        return collideLeft;
    }

    public PhysicsStateSet setCollideLeft(boolean collideLeft) {
        this.collideLeft = collideLeft;
        return this;
    }

    public boolean isCollideRight() {
        return collideRight;
    }

    public PhysicsStateSet setCollideRight(boolean collideRight) {
        this.collideRight = collideRight;
        return this;
    }
}
