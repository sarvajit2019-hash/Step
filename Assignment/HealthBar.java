import java.util.Scanner;

public class HealthBar {
    static class Character {
        private int health;
        private final int maxHealth;

        Character(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = maxHealth;
        }

        void takeDamage(int amount) {
            health -= amount;
            if (health < 0)
                health = 0;
        }

        void heal(int amount) {
            health += amount;
            if (health > maxHealth)
                health = maxHealth;
        }

        int getHealth() {
            return health;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum health: ");
        int maxHealth = sc.nextInt();

        Character c = new Character(maxHealth);

        System.out.print("Enter damage: ");
        c.takeDamage(sc.nextInt());

        System.out.println("Health after damage: " + c.getHealth());

        System.out.print("Enter healing: ");
        c.heal(sc.nextInt());

        System.out.println("Current health: " + c.getHealth());
    }
}