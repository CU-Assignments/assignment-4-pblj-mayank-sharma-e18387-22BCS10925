import java.util.*;

public class CardCollection {
    private static HashMap<String, List<String>> cardMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCards();

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Display All Cards");
            System.out.println("2. Search Cards by Symbol");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: displayAllCards(); break;
                case 2: searchCardsBySymbol(); break;
                case 3: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void initializeCards() {
        String[] symbols = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String symbol : symbols) {
            List<String> cards = new ArrayList<>();
            for (String rank : ranks) {
                cards.add(rank + " of " + symbol);
            }
            cardMap.put(symbol, cards);
        }
    }

    private static void displayAllCards() {
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void searchCardsBySymbol() {
        System.out.print("Enter the symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();

        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards with symbol " + symbol + ": " + cardMap.get(symbol));
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }
}
