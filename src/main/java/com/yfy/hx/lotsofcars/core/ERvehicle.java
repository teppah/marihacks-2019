package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public class ERvehicle extends Car {

    public ERvehicle() {
        super("ervehicle");
    }

    public ERvehicle(Facing facing) {
        super(facing);
    }


}

