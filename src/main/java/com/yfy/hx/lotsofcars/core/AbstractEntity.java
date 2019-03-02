package com.yfy.hx.lotsofcars.core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity {
    public int x;
    public int y;

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
