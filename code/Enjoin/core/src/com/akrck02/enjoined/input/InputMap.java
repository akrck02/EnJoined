package com.akrck02.enjoined.input;

public class InputMap {

    //Actions
    private boolean action;
    private boolean jump;

    //Directions
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;


    public InputMap(){
        this.action = false;
        this.jump = false;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isAction() {
        return action;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }


    //to string

    @Override
    public String toString() {
        return "InputMap{" +
                "action=" + action +
                ", jump=" + jump +
                ", up=" + up +
                ", down=" + down +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
