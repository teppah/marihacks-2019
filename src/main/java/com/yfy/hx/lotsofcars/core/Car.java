package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Car extends AbstractEntity {
    public Facing facing;


    public enum Facing {
        NORTH,
        EAST,
        WEST,
        SOUTH
    }
}

