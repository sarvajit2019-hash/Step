import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int borrowingDays();

        LocalDate dueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(borrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int borrowingDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        int borrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int borrowingDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrowed items: ");
        int n = sc.nextInt();
        sc.nextLine();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1];

            if (title.startsWith(""") && title.endsWith("""))
                title = title.substring(1, title.length() - 1);

            if (type.equals("BOOK"))
                items[i] = new Book(title);
            else if (type.equals("DVD"))
                items[i] = new DVD(title);
            else
                items[i] = new Magazine(title);
        }

        for (LibraryItem item : items)
            System.out.println(item.title + ": " + item.dueDate());
    }
}