package com.parkinglot.ticket;

import com.parkinglot.slot.ParkingSlot;
import com.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;



    public Ticket(Vehicle vehicle , ParkingSlot parkingSlot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.slot = parkingSlot;
        this.entryTime = LocalDateTime.now();
    }
    public String getTicketId(){
        return ticketId;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public ParkingSlot getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }
}
