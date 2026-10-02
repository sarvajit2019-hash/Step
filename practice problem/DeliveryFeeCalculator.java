import java.util.Scanner;

public class DeliveryFeeCalculator {

    static abstract class Delivery {
        double weight;
        double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        double calculateFee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of deliveries: ");
        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];
        String[] types = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            types[i] = type;

            if (type.equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = sc.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }

        for (int i = 0; i < n; i++) {
            double fee = deliveries[i].calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", types[i], fee);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}