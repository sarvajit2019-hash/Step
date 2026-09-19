import java.util.Scanner;

public class ReverseCustomerName {
    static String reverseCustomerName(String customerName) {
        char[] name = customerName.toCharArray();

        for (int i = 0, j = name.length - 1; i < j; i++, j--) {
            char temp = name[i];
            name[i] = name[j];
            name[j] = temp;
        }

        return new String(name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}