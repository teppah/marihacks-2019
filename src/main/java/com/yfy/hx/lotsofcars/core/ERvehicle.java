package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class ERvehicle extends AbstractEntity {
public String uuid;

public Facing facing;

public ERvehicle() {
        super("ERvehicle");
        facing = Facing.NORTH;
        }

public ERvehicle(Facing facing) {
        super("ERvehicle");
        this.facing = facing;
        }

public enum Facing {
    NORTH,
    EAST,
    WEST,
    SOUTH
}
}

