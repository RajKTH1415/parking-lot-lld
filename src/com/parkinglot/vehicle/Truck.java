package com.parkinglot.vehicle;

import com.parkinglot.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber){
        super(vehicleNumber, VehicleType.TRUCK);
    }
}
