package com.akrck02.enjoined.core;

public class Vector2D {

    public double x;
    public double y;
    public double direction;


    public Vector2D(double x , double y){
        this.x = x;
        this.y = y;
        this.direction = 0;
    }

    public Vector2D(double x, double y, double direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
