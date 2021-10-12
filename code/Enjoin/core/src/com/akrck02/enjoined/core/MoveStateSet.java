package com.akrck02.enjoined.core;

public class MoveStateSet {

    private boolean falling;
    private boolean jumping;
    private boolean accelerating;
    private boolean decelerating;

    public MoveStateSet() {
        this.falling = false;
        this.jumping = false;
        this.accelerating = false;
        this.decelerating = false;
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

    public boolean isDecelerating() {return decelerating;}

    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }

    public void setDecelerating(boolean decelerating) {this.decelerating = decelerating;}
    public boolean isGrounded(){
        return !isJumping() && !isFalling();
    }

    @Override
    public String toString() {
        return "{" +
                "falling=" + falling +
                ", jumping=" + jumping +
                ", accelerating =" + accelerating +
                ", decelerating =" + decelerating +
                ", grounded=" + isGrounded() +
                '}';
    }
}
