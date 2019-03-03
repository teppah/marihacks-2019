package com.yfy.hx.lotsofcars.web;

import com.yfy.hx.lotsofcars.core.AbstractEntity;
import com.yfy.hx.lotsofcars.core.Car;
import com.yfy.hx.lotsofcars.core.Grid;
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

    @GetMapping("api/get-new")
    public Car getNewCar() {
        Car car = new Car();
        car.uuid = new Random().nextInt() + "";
        grid.addCar(car);
        return car;
    }



}
