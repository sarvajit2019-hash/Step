import java.util.Scanner;

public class CourseCreditManagement {

    static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Theory-only course:");
        System.out.print("Code: ");
        String code1 = sc.nextLine();
        System.out.print("Title: ");
        String title1 = sc.nextLine();
        System.out.print("Credits: ");
        int credits1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Course with lab:");
        System.out.print("Code: ");
        String code2 = sc.nextLine();
        System.out.print("Title: ");
        String title2 = sc.nextLine();
        System.out.print("Credits: ");
        int credits2 = sc.nextInt();
        System.out.print("Lab credits: ");
        int labCredits = sc.nextInt();

        Course theoryCourse = new Course(code1, title1, credits1);
        Course labCourse = new Course(code2, title2, credits2, labCredits);

        System.out.println(code1 + " total credits: " + theoryCourse.totalCredits());
        System.out.println(code2 + " total credits: " + labCourse.totalCredits());
    }
}