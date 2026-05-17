package com.parkinglot.slot;

import com.parkinglot.enums.SlotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.vehicle.Vehicle;

public class ParkingSlot {

    private int slotNumber;
    private  SlotType slotType;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber , SlotType slotType){
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.occupied = false;

    }

    public synchronized boolean canPark(Vehicle vehicle){
        if (occupied){
            return false;
        }
        if (vehicle.getVehicleType() == VehicleType.BIKE && slotType == SlotType.SMALL){
            return true;
        }
        if (vehicle.getVehicleType() == VehicleType.CAR && slotType == SlotType.MEDIUM){
            return true;
        }
        if (vehicle.getVehicleType() == VehicleType.TRUCK && slotType == SlotType.LARGE){
            return false;
        }
        return false;
    }
    public synchronized void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.occupied = true;

    }
    public synchronized void removeVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.occupied = false;
    }
    public int getSlotNumber(){
        return slotNumber;
    }
    public SlotType getSlottype(){
        return slotType;
    }
    public boolean isOccupied(){
        return occupied;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
}
