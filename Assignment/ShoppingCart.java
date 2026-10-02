import java.util.Scanner;

public class ShoppingCart {
    static class Cart {
        private double[] prices;
        private int itemCount;
        private final String cartId;

        public Cart(String cartId, int maxItems) {
            this.cartId = cartId;
            prices = new double[maxItems];
            itemCount = 0;
        }

        public void addItem(double price) {
            if (itemCount < prices.length && price >= 0)
                prices[itemCount++] = price;
        }

        public double getTotal() {
            double total = 0;

            for (int i = 0; i < itemCount; i++)
                total += prices[i];

            return total;
        }

        public int getItemCount() {
            return itemCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String id = sc.nextLine();

        System.out.print("Enter maximum items: ");
        int max = sc.nextInt();

        Cart cart = new Cart(id, max);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price " + (i + 1) + ": ");
            cart.addItem(sc.nextDouble());
        }

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}