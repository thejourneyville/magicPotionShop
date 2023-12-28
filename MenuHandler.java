import java.util.Scanner;
import java.util.Map;

public class MenuHandler {

    // opening scanner on top level to share across menu methods
    private static Scanner scanner = new Scanner(System.in);

    // prevents instanciation
    private MenuHandler() {};

    public static String mainMenu() {
        System.out.println("[B]uy Potion");
        System.out.println("[S]ell Potion");
        System.out.println("[C]heck Backpack");
        System.out.println("[I]tems in Shop");
        System.out.println("E[X]it Shop");
        // System.out.println();
        System.out.print("How can I help you?: ");

        String output = scanner.nextLine().toUpperCase();
        return output;
    }

    public static String buyMenu(int meseta, Map<String, Map<String, Integer>> inventory) {
        // if backpack has contents, run an 'enhanced for loop'
        System.out.println("POTION SHOP MENU:");
        for (Map.Entry<String, Map<String, Integer>> potion : inventory.entrySet()) {
            String potionName = potion.getKey();
            Map<String, Integer> stats = potion.getValue();
            // formatting name of potion to be capitalized
            String potionNameFormatted = potionName
                    .transform(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
            // printing shop items with printf to access print specifiers
            System.out.printf("%-10s meseta: %-5d stock: %-3d%n", potionNameFormatted, stats.get("price"),
                    stats.get("quantity"));
        }
        System.out.print("Which potion are you interested in? (" + meseta + "): ");
        String output = scanner.nextLine().toLowerCase();
        if (output == "") {
            System.out.println("Let me know when you're ready.");
        }
        return output;
    }

    public static String sellMenu(int meseta, Map<String, Integer> inventory) {
        // checks to see if backpack is empty using 'size' method
        if (inventory.size() < 1) {
            System.out.println("Your backpack is empty traveller!");
            return "";
        } else {
            // if backpack has contents, run an 'enhanced for loop'
            System.out.println("Current items in backpack:");
            for (Map.Entry<String, Integer> potion : inventory.entrySet()) {
                // extract key and values
                String potionName = potion.getKey();
                int potionQuantity = potion.getValue();
                // print with left justify 10 spaces
                System.out.printf("%-10s %d%n", potionName + ":", potionQuantity);
            }
        }
        System.out.print("Which potion do you want to sell? (" + meseta + "): ");
        String output = scanner.nextLine().toLowerCase();
        if (output == "") {
            System.out.println("Let me know when you're ready.");
        }
        return output;
    }

    // method to close scanner after leaving shop to prevent memory leaks
    public static void closeScanner() {
        scanner.close();
    }
}