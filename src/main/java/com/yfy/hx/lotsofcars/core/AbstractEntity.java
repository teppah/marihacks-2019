package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractEntity {
    public int x;
    public int y;

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
