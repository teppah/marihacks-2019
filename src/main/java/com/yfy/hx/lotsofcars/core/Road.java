package com.yfy.hx.lotsofcars.core;

public class Road extends AbstractEntity {
    public Car currentCar = null;
    public ERvehicle currentER = null;
    public Road() {
        super("road");
    }
}
