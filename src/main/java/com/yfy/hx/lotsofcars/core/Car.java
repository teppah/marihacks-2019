package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class Car extends AbstractEntity {
    public String uuid;

    public Facing facing;

    public Car() {
        super("car");
        facing = Facing.NORTH;
    }

    public Car(String type) {
        super(type);
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

