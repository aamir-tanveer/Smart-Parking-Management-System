
import java.util.Scanner;

abstract class Vehicle {
    private String number;

    Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public abstract int getRate();

    public abstract String getType();
}

class Car extends Vehicle {
    Car(String number) {
        super(number);
    }

    public int getRate() {
        return 100;
    }

    public String getType() {
        return "Car";
    }
}

class Bike extends Vehicle {
    Bike(String number) {
        super(number);
    }

    public int getRate() {
        return 50;
    }

    public String getType() {
        return "Bike";
    }
}

class ParkingSlot {
    private int slotNumber;
    private Vehicle vehicle;

    ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isEmpty() {
        return vehicle == null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void remove() {
        vehicle = null;
    }
}

class ParkingManager {
    private ParkingSlot[] slots = new ParkingSlot[5];

    ParkingManager() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new ParkingSlot(i + 1);
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (!slot.isEmpty() &&
                slot.getVehicle().getNumber().equalsIgnoreCase(vehicle.getNumber())) {
                System.out.println("This vehicle is already parked.");
                return;
            }
        }

        for (ParkingSlot slot : slots) {
            if (slot.isEmpty()) {
                slot.park(vehicle);
                System.out.println("Vehicle parked in slot " + slot.getSlotNumber());
                return;
            }
        }

        System.out.println("Sorry, parking is full.");
    }

    public void removeVehicle(String number, int hours) {
        for (ParkingSlot slot : slots) {
            if (!slot.isEmpty() &&
                slot.getVehicle().getNumber().equalsIgnoreCase(number)) {
                Vehicle vehicle = slot.getVehicle();
                int fee = vehicle.getRate() * hours;

                System.out.println("Vehicle: " + vehicle.getNumber());
                System.out.println("Type: " + vehicle.getType());
                System.out.println("Parking hours: " + hours);
                System.out.println("Total fee: Rs. " + fee);
                slot.remove();
                System.out.println("Vehicle removed successfully.");
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    public void showSlots() {
        for (ParkingSlot slot : slots) {
            if (slot.isEmpty()) {
                System.out.println("Slot " + slot.getSlotNumber() + ": Available");
            } else {
                System.out.println("Slot " + slot.getSlotNumber() + ": Occupied");
            }
        }
    }

    public void showVehicles() {
        boolean found = false;

        for (ParkingSlot slot : slots) {
            if (!slot.isEmpty()) {
                Vehicle vehicle = slot.getVehicle();
                System.out.println("Slot " + slot.getSlotNumber() + " - " +
                    vehicle.getType() + " - " + vehicle.getNumber());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles are parked.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingManager parking = new ParkingManager();

        while (true) {
            System.out.println("\n=== SMART PARKING SYSTEM ===");
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle and calculate fee");
            System.out.println("3. View parking slots");
            System.out.println("4. View parked vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter vehicle number: ");
                String number = sc.nextLine().trim();

                if (number.isEmpty()) {
                    System.out.println("Vehicle number cannot be empty.");
                    continue;
                }

                System.out.println("1. Car");
                System.out.println("2. Bike");
                System.out.print("Choose vehicle type: ");
                String type = sc.nextLine().trim();

                if (type.equals("1")) {
                    parking.parkVehicle(new Car(number));
                } else if (type.equals("2")) {
                    parking.parkVehicle(new Bike(number));
                } else {
                    System.out.println("Invalid vehicle type.");
                }

            } else if (choice.equals("2")) {
                System.out.print("Enter vehicle number: ");
                String number = sc.nextLine().trim();

                System.out.print("Enter parking hours: ");
                String input = sc.nextLine().trim();

                try {
                    int hours = Integer.parseInt(input);

                    if (hours <= 0) {
                        System.out.println("Hours must be greater than zero.");
                    } else {
                        parking.removeVehicle(number, hours);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number of hours.");
                }

            } else if (choice.equals("3")) {
                parking.showSlots();

            } else if (choice.equals("4")) {
                parking.showVehicles();

            } else if (choice.equals("5")) {
                System.out.println("Thank you for using the parking system!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
