import java.util.Scanner;

public class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        color = "RED";
    }

    public void next() {
        if (color.equals("RED"))
            color = "GREEN";
        else if (color.equals("GREEN"))
            color = "YELLOW";
        else
            color = "RED";
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic light ID: ");
        String id = sc.nextLine();

        TrafficLight t = new TrafficLight(id);

        System.out.println("Current color: " + t.getColor());

        System.out.print("Enter number of next() calls: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t.next();
            System.out.println("Color: " + t.getColor());
        }
    }
}