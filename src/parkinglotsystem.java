import com.parkinglot.enums.SlotType;
import com.parkinglot.floor.ParkingFloor;
import com.parkinglot.parking.ParkingLot;
import com.parkinglot.slot.ParkingSlot;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.vehicle.Bike;
import com.parkinglot.vehicle.Car;
import com.parkinglot.vehicle.Truck;
import com.parkinglot.vehicle.Vehicle;

public class parkinglotsystem {

    public static void main(String[] args) {

        System.out.println("==========parking-lot-system========");

        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor(1);

        floor1.addSlot(new ParkingSlot(1, SlotType.SMALL));
        floor1.addSlot(new ParkingSlot(2, SlotType.MEDIUM));
        floor1.addSlot(new ParkingSlot(3, SlotType.LARGE));

        ParkingFloor floor2 = new ParkingFloor(2);

        floor2.addSlot(new ParkingSlot(4, SlotType.SMALL));
        floor2.addSlot(new ParkingSlot(5, SlotType.MEDIUM));
        floor2.addSlot(new ParkingSlot(6, SlotType.LARGE));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        Vehicle car = new Car("KA01AB1234");
        Vehicle bike = new Bike("KA02XY5678");
        Vehicle truck = new Truck("KA03TR9999");

        Ticket carTicket = parkingLot.parkVehicle(car);
        Ticket bikeTicket = parkingLot.parkVehicle(bike);
        Ticket truckTicket = parkingLot.parkVehicle(truck);

        System.out.println();

        // SAFE EXIT FOR ALL VEHICLES
        if (carTicket != null) {
            parkingLot.exitVehicle(carTicket.getTicketId());
        } else {
            System.out.println("Car parking failed");
        }

        if (bikeTicket != null) {
            parkingLot.exitVehicle(bikeTicket.getTicketId());
        } else {
            System.out.println("Bike parking failed");
        }

        if (truckTicket != null) {
            parkingLot.exitVehicle(truckTicket.getTicketId());
        } else {
            System.out.println("Truck parking failed (No available LARGE slot)");
        }

        System.out.println();

        parkingLot.displayAvailability();
    }
}