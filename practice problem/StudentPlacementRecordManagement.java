import java.util.Scanner;

public class StudentPlacementRecordManagement {

    static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlacementRecord[] records = new PlacementRecord[3];

        for (int i = 0; i < records.length; i++) {
            System.out.println("Enter student " + (i + 1) + " details:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Company: ");
            String company = sc.nextLine();
            System.out.print("Package LPA: ");
            double packageLpa = sc.nextDouble();
            sc.nextLine();

            records[i] = new PlacementRecord(name, company, packageLpa);
        }

        System.out.println("Placement Records:");
        for (PlacementRecord record : records)
            record.printRecord();
    }
}