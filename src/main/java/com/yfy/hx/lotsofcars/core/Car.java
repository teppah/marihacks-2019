package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Car extends AbstractEntity {
    public Facing facing;

    public Car() {
        super("car");
    }

    public Car(Facing facing) {
        super("car");
        this.facing = facing;
    }

    public enum Facing {
        NORTH,
        EAST,
        WEST,
        SOUTH
    }
}

