import java.util.Scanner;

public class HostelMessWalletManagement {

    static class MessWallet {
        private double balance;

        public MessWallet(double balance) {
            if (balance < 0) {
                System.out.println("Warning: negative opening balance. Starting at 0.");
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0)
                System.out.println("Top-up rejected: amount must be positive");
            else
                balance += amount;
        }

        public void deduct(double amount) {
            if (amount > balance)
                System.out.println("Deduct rejected: insufficient balance");
            else if (amount <= 0)
                System.out.println("Deduct rejected: amount must be positive");
            else
                balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter opening balance: ");
        double opening = sc.nextDouble();
        MessWallet wallet = new MessWallet(opening);

        System.out.print("Enter top-up amount: ");
        wallet.topUp(sc.nextDouble());

        System.out.print("Enter deduction amount: ");
        wallet.deduct(sc.nextDouble());

        System.out.println("Final balance: " + wallet.getBalance());
    }
}