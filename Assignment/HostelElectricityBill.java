import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return 8 * units;
        }
    }

    static class SharedRoom extends Room {
        int occupants;

        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double calculateBill() {
            return (6 * units) / (double) occupants;
        }
    }

    static class ACRoom extends Room {
        ACRoom(int units) {
            super(units);
        }

        double calculateBill() {
            return 10 * units + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Room[] rooms = new Room[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            types[i] = type;

            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else {
                rooms[i] = new ACRoom(units);
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", types[i], bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}