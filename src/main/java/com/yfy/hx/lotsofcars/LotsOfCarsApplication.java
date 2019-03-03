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

    @Bean 
    public Grid return_grid_orientation() {
        Grid road_orientation = new Grid();
        for (int i = 0; i < Grid.gridWidth; i++) {
            for (int j = 0; j < Grid.gridHeight; j++) {
                String orientation;
                orientation = Grid.return_road_orientation(j, i);       // make sure (j, i) and not (i, j)!!!
                road_orientation.addThing(orientation, i, j);
            }
        }

        return road_orientation;    
    }

    private AbstractEntity generateRandom(int i, int j) {
        double val = r.nextDouble();

        // if (val < 0.5) {
        if ((i%5)!=0 && (j%5)!=0){
            return new Building();
        } else {
            Road road = new Road();
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

        public static String return_road_orientation(int x, int y){
        /** Function returns road orientation based on x and y coordinates
        */

        // based on a 5x5 block system
        if((x%10)==0 && (y%5)!=0){
            return "down";
        }

        else if((x%10)==5 && (y%5)!=0){
            return "up";
        }

        else if((x%5)!=0 && (y%10)==0){
            return "left";
        }

        else if((x%5)!=0 && (y%10)==5){
            return "right";
        }

        else if((x%5)==0 && (y%5)==0){
            return "intersection";
        }

        else{
            return "building";
        }

    }


}
