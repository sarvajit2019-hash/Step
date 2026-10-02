import java.util.Scanner;

public class LockerCode {
    private String combination;
    private final int lockerNumber;

    public LockerCode(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public void changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            System.out.println("Code change successful");
        } else {
            System.out.println("Code change rejected");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter initial code: ");
        String code = sc.nextLine();

        LockerCode locker = new LockerCode(number, code);

        System.out.print("Enter current code: ");
        String current = sc.nextLine();
        System.out.print("Enter new code: ");
        String newCode = sc.nextLine();

        locker.changeCode(current, newCode);
    }
}