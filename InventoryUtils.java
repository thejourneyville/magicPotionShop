import java.util.Map;

public class InventoryUtils {

    public static boolean checkItemExistence(String itemName, Map<String, Map<String, Integer>> shopInventory) {
        String itemNameLowercase = itemName.toLowerCase();
        if (!shopInventory.containsKey(itemNameLowercase)) {
            System.out.println("Sorry, we only have what you see.");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkTravellerHasItem(String itemName, Map<String, Integer> travellerInventory) {
        String itemNameLowercase = itemName.toLowerCase();
        if (!travellerInventory.containsKey(itemNameLowercase) || travellerInventory.get(itemNameLowercase) == 0) {
            String potionNameFormatted = itemNameLowercase
                    .transform(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
            System.out.println("You don't have any " + potionNameFormatted + "!");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkTravellerAffordItem(String itemName, int travellerMeseta, int shopPrice) {
        System.out.printf("Traveller Meseta: %d, Shop Price: %d%n", travellerMeseta, shopPrice);
        String itemNameLowercase = itemName.toLowerCase();
        String potionNameFormatted = itemNameLowercase
            .transform(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
        if (travellerMeseta < shopPrice) {
            System.out.println("You don't have enough meseta to buy " + potionNameFormatted + "!");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkUserBackpackLimit(Map<String, Integer> travellerInventory) {
        int totalItems = 0;
        for (int potionQuantity : travellerInventory.values()) {
            totalItems += potionQuantity;
        }

        if (totalItems >= 5) {
            System.out.println("You can't put any more items in your backpack!");
            return false;
        } else {
            return true;
        }
    }

}