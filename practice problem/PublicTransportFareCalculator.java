import java.util.Scanner;

public class PublicTransportFareCalculator {

    static abstract class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of journeys: ");
        int n = sc.nextInt();

        Transport[] journeys = new Transport[n];
        String[] types = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            types[i] = type;

            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                journeys[i] = new Metro(distance, factor);
            }
        }

        for (int i = 0; i < n; i++) {
            double fare = journeys[i].calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", types[i], fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}