package com.parkinglot.parking;

import com.parkinglot.floor.ParkingFloor;
import com.parkinglot.payment.PaymentService;
import com.parkinglot.slot.ParkingSlot;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingLot {

    private static ParkingLot instance;

    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;

    private ParkingLot() {
        floors = new ArrayList<>();
        activeTickets = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance() {

        if (instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        for (ParkingFloor floor : floors) {

            ParkingSlot slot = floor.getAvailableSlot(vehicle);

            if (slot != null) {

                slot.parkVehicle(vehicle);

                Ticket ticket = new Ticket(vehicle, slot);

                activeTickets.put(
                        ticket.getTicketId(),
                        ticket
                );

                System.out.println("Vehicle Parked Successfully");
                System.out.println(
                        "Ticket ID : " + ticket.getTicketId()
                );

                System.out.println(
                        "Vehicle Number : "
                                + vehicle.getVehicleNumber()
                );

                System.out.println(
                        "Floor : " + floor.getFloorNumber()
                );

                System.out.println(
                        "Slot : " + slot.getSlotNumber()
                );

                return ticket;
            }
        }

        System.out.println("Parking Full");

        return null;
    }

    public void exitVehicle(String ticketId) {

        Ticket ticket = activeTickets.get(ticketId);

        if (ticket == null) {

            System.out.println("Invalid Ticket");

            return;
        }

        ParkingSlot slot = ticket.getSlot();

        slot.removeVehicle();

        PaymentService paymentService =
                new PaymentService();

        double fee = paymentService.calculateFee(ticket);

        activeTickets.remove(ticketId);

        System.out.println("Vehicle Exited");
        System.out.println("Total Fee : " + fee);
    }

    public void displayAvailability() {

        for (ParkingFloor floor : floors) {
            floor.displayAvailableSlots();
        }
    }
}
