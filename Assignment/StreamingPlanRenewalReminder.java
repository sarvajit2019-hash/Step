import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class Basic extends Plan {
        Basic(String name, LocalDate date) {
            super(name, date);
        }

        int validityDays() {
            return 30;
        }
    }

    static class Standard extends Plan {
        Standard(String name, LocalDate date) {
            super(name, date);
        }

        int validityDays() {
            return 90;
        }
    }

    static class Premium extends Plan {
        Premium(String name, LocalDate date) {
            super(name, date);
        }

        int validityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plan[] plans = new Plan[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            if (type.equals("BASIC"))
                plans[i] = new Basic(name, date);
            else if (type.equals("STANDARD"))
                plans[i] = new Standard(name, date);
            else
                plans[i] = new Premium(name, date);
        }

        for (Plan plan : plans)
            System.out.println(plan.name + ": " + plan.renewalDate());
    }
}