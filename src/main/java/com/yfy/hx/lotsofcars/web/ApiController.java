package com.yfy.hx.lotsofcars.web;

import com.yfy.hx.lotsofcars.core.AbstractEntity;
import com.yfy.hx.lotsofcars.core.Car;
import com.yfy.hx.lotsofcars.core.ERvehicle;
import com.yfy.hx.lotsofcars.core.Grid;
import com.yfy.hx.lotsofcars.core.Road;
import com.yfy.hx.lotsofcars.core.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
@Slf4j
public class ApiController {
    private Grid grid;

    @Autowired
    public ApiController(Grid grid) {
        this.grid = grid;
        log.info("finished initialization");
    }

    @GetMapping("api/grid")
    public AbstractEntity[][] getGrid() {
        log.info("requested grid");
        return grid.grid;
    }

    @GetMapping("api/get-at-location")
    public AbstractEntity getAtLocation(@RequestParam Integer x,
                                        @RequestParam Integer y) {
        if (x != null && y != null) {
            return grid.get(x, y);
        }

        return null;
    }


<<<<<<< HEAD
//need to finish this
    // @GetMapping("api/get-position")
    // public AbstractEntity getPosition(@RequestParam String uuid) {
        
    //     if (uuid != null) {
            

    //         return grid.get();
    //     }

    //     return null;
    // }
=======
    @GetMapping("api/get-car")
    public Car getCar(@RequestParam String uuid) {
        return grid.findCar(uuid);
    }
>>>>>>> 02b63a9de11f8faf59a392d0450874723da3b89b

    @GetMapping("api/move-car")
    public Car moveCar(@RequestParam Integer x,
                       @RequestParam Integer y,
                       @RequestParam String direction) {
        AbstractEntity currentRoad = grid.get(x, y);
        log.info("thing at x {} y {}", currentRoad.x, currentRoad.y);
        log.info("it is is {}", grid.grid[currentRoad.x][currentRoad.y]);

        Car currentCar = null;
        if (currentRoad instanceof Road) {
            Road r = (Road) currentRoad;
            int newX = currentRoad.x;
            int newY = currentRoad.y;
            log.info("old x={}, old y={}", currentRoad.x, currentRoad.y);
            if (r.currentCar != null) {
                currentCar = r.currentCar;
                switch (direction) {
                    case "up":
                        log.info("up");
                        newY++;
                        break;
                    case "down":
                        log.info("down");
                        newY--;
                        break;
                    case "left":
                        log.info("left");
                        newX--;
                        break;
                    case "right":
                        log.info("right");
                        newX++;
                        break;
                }
                log.info("new x={}, new y={}", newX, newY);
                if (grid.grid[newX][newY] instanceof Road) {
                    Road newRoad = (Road) grid.grid[newX][newY];
                    if (newRoad.currentCar == null) {
                        r.currentCar = null;
                        newRoad.currentCar = currentCar;
                        currentRoad.x = newX;
                        currentRoad.y = newY;

                        currentCar.x = newX;
                        currentCar.y = newY;
                        log.info("car now has motion");
                    }
                }
            }
        }
        return currentCar;
    }


    @GetMapping("api/get-new-car")
    public Car getNewCar() {
        Car car = new Car();
        car.uuid = new Random().nextInt() + "";
        grid.addCar(car);
        return car;
    }

    @GetMapping("api/get-new-ER")
    public ERvehicle getNewER() {
        ERvehicle ervehicle = new ERvehicle();
        ervehicle.uuid = new Random().nextInt() + "";
        grid.addCar(ervehicle);
        return ervehicle;
    }


}
