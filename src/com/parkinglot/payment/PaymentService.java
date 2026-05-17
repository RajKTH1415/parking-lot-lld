package com.parkinglot.payment;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.ticket.Ticket;

import java.time.LocalDateTime;

public class PaymentService {

    public double calculateFee(Ticket ticket){

        LocalDateTime existTime = LocalDateTime.now();

        long hours = java.time.Duration.between(ticket.getEntryTime(), existTime).toHours();
        if (hours == 0){
            hours = 1;
        }

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        switch (vehicleType){

            case BIKE :
                return hours * 10;
            case CAR:
                return hours * 20;
            case TRUCK:
                return hours * 30;
            default:
                return 0;
        }

    }
}
