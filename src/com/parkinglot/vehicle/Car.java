package com.parkinglot.vehicle;

import com.parkinglot.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
