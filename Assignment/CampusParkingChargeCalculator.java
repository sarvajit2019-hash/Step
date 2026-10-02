import java.util.Scanner;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return 10 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return 30 + 20 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        double calculateCharge() {
            return Math.max(100, 50 * hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Vehicle[] vehicles = new Vehicle[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            types[i] = type;

            if (type.equals("BIKE"))
                vehicles[i] = new Bike(hours);
            else if (type.equals("CAR"))
                vehicles[i] = new Car(hours);
            else
                vehicles[i] = new Truck(hours);
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double charge = vehicles[i].calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", types[i], charge);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}