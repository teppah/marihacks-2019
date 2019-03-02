package com.yfy.hx.lotsofcars;


import com.yfy.hx.lotsofcars.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Random;

@SpringBootApplication

public class LotsOfCarsApplication {
    private Random r = new Random();


    public static void main(String[] args) {
        SpringApplication.run(LotsOfCarsApplication.class, args);
    }

    @Bean
    public Grid grid() {
        Grid grid = new Grid();
        for (int i = 0; i < Grid.gridWidth; i++) {
            for (int j = 0; j < Grid.gridHeight; j++) {
                AbstractEntity ae = generateRandom();
                grid.addThing(ae, i, j);
            }
        }

        return grid;
    }

    private AbstractEntity generateRandom() {
        double val = r.nextDouble();

        if (val < 0.33) {
            return new Building();
        } else if (val >= 0.33 && val < 0.67) {
            return new Road();
        } else {
            return new Car();
        }
    }


}
