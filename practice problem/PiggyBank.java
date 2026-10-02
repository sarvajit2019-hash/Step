import java.util.Scanner;

public class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0)
            savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > savings)
            System.out.println("Withdrawal rejected: insufficient savings");
        else if (amount <= 0)
            System.out.println("Withdrawal rejected: invalid amount");
        else
            savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PiggyBank ID: ");
        String id = sc.nextLine();

        PiggyBank pb = new PiggyBank(id);

        System.out.print("Enter deposit amount: ");
        pb.deposit(sc.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        pb.withdraw(sc.nextDouble());

        System.out.println("Current savings: " + pb.getSavings());
    }
}