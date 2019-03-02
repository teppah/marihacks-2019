package com.yfy.hx.lotsofcars.core;

import org.springframework.stereotype.Component;

public class Grid {
    public AbstractEntity[][] grid = new AbstractEntity[40][20];

    public static final int gridHeight = 20;
    public static final int gridWidth = 40;

    public void print() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.println();
        }
    }


    public void addThing(AbstractEntity entity, int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("bro sumtins wrong: x = " + x + " and y = " + y);
        }

        else if (x >  gridWidth && y > gridHeight) {
            throw new IllegalArgumentException("Invalid x and y coord: x = " + x + " y = " + y);
        } else {
            entity.x = x;
            entity.y = y;
            grid[x][y] = entity;
        }


    }


}
