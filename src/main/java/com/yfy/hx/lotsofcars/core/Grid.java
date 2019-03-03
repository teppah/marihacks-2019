package com.yfy.hx.lotsofcars.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Grid {
    public AbstractEntity[][] grid = new AbstractEntity[40][20];

    public List<Car> cars = new ArrayList<>();

    public static final int gridHeight = 20;
    public static final int gridWidth = 40;

    private static Random r = new Random();

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
            if (entity instanceof Car) {
                cars.add((Car) entity);
            }
        }
    }

    public AbstractEntity get(int x, int y){
        return grid[x][y];
    }

    public void addCar(Car car) {
        while (true) {
            int x = r.nextInt(gridWidth);
            int y = r.nextInt(gridHeight);
            AbstractEntity ae = grid[x][y];
            if (ae instanceof Road) {
                Road road = (Road) ae;
                if (road.currentCar == null) {
                    cars.add(car);
                    car.x = x;
                    car.y = y;
                    road.currentCar = car;
                    log.info("added new car {}", car);
                    log.info("road is at x={} and y={}", road.x, road.y);
                    break;
                }
            }
        }

    }


}
