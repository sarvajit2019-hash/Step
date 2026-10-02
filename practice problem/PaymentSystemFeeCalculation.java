import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    static abstract class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }

        double finalAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();
        sc.nextLine();

        Payment[] payments = new Payment[n];
        String[] types = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            types[i] = type;

            if (type.equals("CARD"))
                payments[i] = new CardPayment(amount);
            else if (type.equals("WALLET"))
                payments[i] = new WalletPayment(amount);
            else
                payments[i] = new BankTransfer(amount);
        }

        for (int i = 0; i < n; i++) {
            double adjusted = payments[i].finalAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", types[i], adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}