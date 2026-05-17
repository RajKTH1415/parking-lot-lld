package com.parkinglot.floor;

import com.parkinglot.parking.ParkingSlot;
import com.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor  {

    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
        this.parkingSlots = new ArrayList<>();
    }

    public void addSlot(ParkingSlot parkingSlot){
        parkingSlots.add(parkingSlot);
    }
    public ParkingSlot getAvailableSlot(Vehicle vehicle){
        for (ParkingSlot slot : parkingSlots){
            if (slot.canPark(vehicle)){
                return slot;
            }
        }
        return null;
    }
    public int getFloorNumber(){
        return floorNumber;
    }
    public void displayAvailableSlots(){
        System.out.println("floor :"+ floorNumber);
        for (ParkingSlot parkingSlot : parkingSlots){
            if (!parkingSlot.isOccupied()){
                System.out.println("Slot Number :"+parkingSlot.getSlotNumber() + ": Type : "+ parkingSlot.getSlottype());
            }
        }
    }
}
