package com.yfy.hx.lotsofcars.core;

public class Road extends AbstractEntity {
    public Car currentCar = null;
    public ERvehicle currentER = null;
    
    public Road(String orientation) {
        super(orientation);
    }

    public static String return_road_orientation(int x, int y, int block_size){
    /** Function returns road orientation based on x and y coordinates
    */

        // based on a 5x5 block system
        if((x%(block_size*2))==0 && (y%block_size)!=0){
            return "down";
        }

        else if((x%(block_size*2))==5 && (y%(block_size))!=0){
            return "up";
        }

        else if((x%(block_size))!=0 && (y%(block_size*2))==0){
            return "left";
        }

        else if((x%(block_size))!=0 && (y%(block_size*2))==5){
            return "right";
        }

        else if((x%block_size)==0 && (y%block_size)==0){
            return "intersection";
        }

        else{
            return "building";
        }

    }
}
