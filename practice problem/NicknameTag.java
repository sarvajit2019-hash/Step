import java.util.Scanner;

public class NicknameTag {
    private final String firstName;
    private final String lastName;

    public NicknameTag(String fullName) {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        NicknameTag tag = new NicknameTag(fullName);
        System.out.println("Nickname: " + tag.getNickname());
    }
}