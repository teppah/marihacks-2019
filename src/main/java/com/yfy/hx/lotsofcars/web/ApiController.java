package com.yfy.hx.lotsofcars.web;

import com.yfy.hx.lotsofcars.core.AbstractEntity;
import com.yfy.hx.lotsofcars.core.Car;
import com.yfy.hx.lotsofcars.core.ERvehicle;
import com.yfy.hx.lotsofcars.core.Grid;
import com.yfy.hx.lotsofcars.core.Road;
import com.yfy.hx.lotsofcars.core.Building;
import lombok.Synchronized;
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

    boolean alerted = false;

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


    @GetMapping("api/get-car")
    public Car getCar(@RequestParam String uuid) {
        return grid.findCar(uuid);
    }

    @GetMapping("api/move-car")
    @Synchronized
    public Car moveCar(@RequestParam Integer x,
                       @RequestParam Integer y,
                       @RequestParam String direction) {
        AbstractEntity currentRoad = grid.get(x, y);
//        log.info("thing at x {} y {}", currentRoad.x, currentRoad.y);
//        log.info("it is is {}", grid.grid[currentRoad.x][currentRoad.y]);

        Car currentCar = null;
        if (currentRoad instanceof Road) {
            Road r = (Road) currentRoad;
            int newX = currentRoad.x;
            int newY = currentRoad.y;
//            log.info("old x={}, old y={}", currentRoad.x, currentRoad.y);
            if (r.currentCar != null) {
                currentCar = r.currentCar;
                switch (direction) {
                    case "up":
                        log.info("up");
                        newY--;
                        break;
                    case "down":
                        log.info("down");
                        newY++;
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
//                log.info("new x={}, new y={}", newX, newY);
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
                    } else {
                        log.info("there is already a car there: {}", newRoad.currentCar.type);
                    }
                }
            } else {
                log.info("there is no car at location x={} y={}", r.x, r.y);
            }
        } else {
            log.info("not a road; it is a {}", currentRoad.type);
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

    @GetMapping("api/reset-grid")
    public void resetGrid() {
        grid.reset();
        log.info("reset grid");
    }

    @GetMapping("api/send-alert")
    public void sendAlert() {
        this.alerted = true;
    }

    @GetMapping("api/reset-alert")
    public void resetAlert() {
        this.alerted = false;
    }

    @GetMapping("api/listen-alert")
    public boolean isAlert() {
        return alerted;
    }


}
