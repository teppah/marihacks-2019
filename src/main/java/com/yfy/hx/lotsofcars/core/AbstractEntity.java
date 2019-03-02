package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractEntity {
    public String type;


    public int x;
    public int y;

    public AbstractEntity(String type) {
        this.type = type;
    }

    public AbstractEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
