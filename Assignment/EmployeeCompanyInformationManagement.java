import java.util.Scanner;

public class EmployeeCompanyInformationManagement {

    static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[3];

        for (int i = 0; i < employees.length; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees[i] = new Employee(name, salary);
        }

        Employee.printCompanyInfo();
    }
}