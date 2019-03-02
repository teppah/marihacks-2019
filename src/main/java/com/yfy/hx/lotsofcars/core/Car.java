package com.yfy.hx.lotsofcars.core;

public class Car extends AbstractEntity {
    public Facing facing;

    public Car(int x, int y, Facing facing) {
        super(x, y);
        this.facing = facing;
    }

    public enum Facing {
        NORTH,
        EAST,
        WEST,
        SOUTH
    }
}

