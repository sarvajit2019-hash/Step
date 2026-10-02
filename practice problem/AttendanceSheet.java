import java.util.Scanner;

public class AttendanceSheet {
    private String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum class size: ");
        int max = sc.nextInt();
        sc.nextLine();

        AttendanceSheet sheet = new AttendanceSheet(max);

        System.out.print("Enter number of students to mark present: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            sheet.markPresent(sc.nextLine());
        }

        System.out.print("Enter name to check: ");
        String name = sc.nextLine();

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println(name + " present: " + sheet.isPresent(name));
    }
}