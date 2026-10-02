import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 0.90;
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 0.95;
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Customer[] customers = new Customer[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            types[i] = type;

            if (type.equals("STUDENT"))
                customers[i] = new Student(amount);
            else if (type.equals("STAFF"))
                customers[i] = new Staff(amount);
            else
                customers[i] = new Guest(amount);
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double finalAmount = customers[i].finalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", types[i], finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}