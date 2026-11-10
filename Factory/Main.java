package Factory;

import java.util.Scanner;

// Product interface
interface Vehicle {
  void rent(int days);
}

// Concrete product 1
class Car implements Vehicle {

  public void rent(int days) {
    System.out.println("Vehicle: Car");
    System.out.println("Total Rent: Rs." + (2000 * days));
  }
}

// Concrete product 2
class Bike implements Vehicle {

  public void rent(int days) {
    System.out.println("Vehicle: Bike");
    System.out.println("Total Rent: Rs." + (500 * days));
  }
}

// Concrete product 3
class Bus implements Vehicle {

  public void rent(int days) {
    System.out.println("Vehicle: Bus");
    System.out.println("Total Rent: Rs." + (5000 * days));
  }
}

// Creator class
abstract class VehicleFactory {

  abstract Vehicle createVehicle();
}

// Concrete factory for Car
class CarFactory extends VehicleFactory {

  Vehicle createVehicle() {
    return new Car();
  }
}

// Concrete factory for Bike
class BikeFactory extends VehicleFactory {

  Vehicle createVehicle() {
    return new Bike();
  }
}

// Concrete factory for Bus
class BusFactory extends VehicleFactory {

  Vehicle createVehicle() {
    return new Bus();
  }
}

// Main class
public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("VEHICLE RENTAL SYSTEM");
    System.out.println("1. Car");
    System.out.println("2. Bike");
    System.out.println("3. Bus");

    System.out.print("Choose vehicle: ");
    int choice = sc.nextInt();

    System.out.print("Enter rental days: ");
    int days = sc.nextInt();

    if (days <= 0) {
      System.out.println("Invalid rental days");
      sc.close();
      return;
    }

    VehicleFactory factory = null;

    switch (choice) {

      case 1:
        factory = new CarFactory();
        break;

      case 2:
        factory = new BikeFactory();
        break;

      case 3:
        factory = new BusFactory();
        break;

      default:
        System.out.println("Invalid vehicle choice");
        sc.close();
        return;
    }

    // Factory creates the required vehicle
    Vehicle vehicle = factory.createVehicle();

    // Perform rental operation
    vehicle.rent(days);

    sc.close();
  }
}
