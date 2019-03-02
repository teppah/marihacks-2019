package com.yfy.hx.lotsofcars.core;

import org.springframework.stereotype.Component;

@Component
public class Grid {
    public AbstractEntity[][] grid = new AbstractEntity[40][20];

    public static final int gridHeight = 20;
    public static final int gridWidth = 40;

    public void print() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.println();
        }
    }


}
