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
                AbstractEntity ae = generateRandom(i, j);
                grid.addThing(ae, i, j);
            }
        }

        // randomly generate cars
        grid = generateCars(grid, 10);

        return grid;
    }

    // @Bean 
    // public String[][] return_grid_orientation_LotsOfCarsApplication() {
    //     OrientationGrid road_orientation = new OrientationGrid(20, 40);
    //     return road_orientation.return_orientation_grid_complete(5);    
    // }

    private AbstractEntity generateRandom(int i, int j) {
        double val = r.nextDouble();

        // if (val < 0.5) {
        if ((i%5)!=0 && (j%5)!=0){
            return new Building();
        } else {
            String road_orientation = Road.return_road_orientation(j, i, 5);

            Road road = new Road(road_orientation);
//            if (r.nextDouble() < 0.2) {
//                road.currentCar = new Car(Car.Facing.NORTH);
//                road.currentCar.facing = Car.Facing.NORTH;
//            }
            return road;
        }
    }

    private Grid generateCars(Grid grid, int number_of_random_cars){
    /* Function that randomly generates cars
    */

        for(int iteration=0; iteration<number_of_random_cars; iteration++){
            Car car = new Car();
            car.uuid = new Random().nextInt() + "";
            grid.addCar(car);            
        }

        return grid;
    }



}
