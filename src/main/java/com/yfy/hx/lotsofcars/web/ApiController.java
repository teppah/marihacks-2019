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


    @GetMapping("api/get-car")
    public Car getCar(@RequestParam String uuid) {
        return grid.findCar(uuid);
    }

    @GetMapping("api/move-car")
    public Car moveCar(@RequestParam String uuid,
                       @RequestParam String direction) {
        Car car = grid.findCar(uuid);
        if (grid.grid[car.x][car.y] instanceof Road) {
            Road r = (Road) grid.grid[car.x][car.y];
            if (r.currentCar != null) {
                r.currentCar = null;
                switch (direction) {

                }
            }
        }
        return null;
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
