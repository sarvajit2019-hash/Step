import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        String name;
        double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double calculateBonus();
    }

    static class FullTime extends Employee {
        FullTime(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTime extends Employee {
        PartTime(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
        }

        double calculateBonus() {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME"))
                employees[i] = new FullTime(name, salary);
            else if (type.equals("PARTTIME"))
                employees[i] = new PartTime(name, salary);
            else
                employees[i] = new Intern(name, salary);
        }

        double total = 0;

        for (Employee employee : employees) {
            double bonus = employee.calculateBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }

        System.out.printf("Total Bonus: %.2f%n", total);
    }
}