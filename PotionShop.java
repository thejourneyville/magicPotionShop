import java.util.HashMap;
import java.util.Map;

public class PotionShop {

    // declaring variables
    public Map<String, Map<String, Integer>> inventory;
    public Map<String, Integer> itemDetails;
    public Map<String, Integer> itemPriceAndQuantity;
    public int itemPrice;
    public int itemQuantity;

    // constructor
    public PotionShop() {
        inventory = new HashMap<>();
    }

    // method to add items to the potion shop
    public void addItem(String itemName, int price, int quantity) {

        itemDetails = new HashMap<>();
        itemDetails.put("price", price);
        itemDetails.put("quantity", quantity);

        inventory.put(itemName, itemDetails);
    }

    public Boolean sellItem(String itemName) {
        String itemNameLowerCase = itemName.toLowerCase();
        // check to see if item has existed in the potion shop
        if (!inventory.containsKey(itemNameLowerCase)) {
            System.out.println("We don't carry " + itemName + " here.");
            return false;
        } else {
            // getting quantity and price from itemName and assigning to
            // itemPriceAndQuantity
            itemPriceAndQuantity = inventory.get(itemNameLowerCase);
            // if the quantity is > 0, reduce quantity by 1 and return true
            if (itemPriceAndQuantity.get("quantity") > 0) {
                itemPriceAndQuantity.put("quantity", itemPriceAndQuantity.get("quantity") - 1);
                inventory.put(itemName, itemPriceAndQuantity);
                System.out.println("Thanks, I'm sure you'll find " + itemName + " quite useful!");
                return true;
                // otherwise it's out of stock and return false
            } else {
                System.out.println("We don't have any " + itemName + " in stock.");
                return false;
            }
        }
    }

    public Boolean buyItem(String itemName) {
        String itemNameLowerCase = itemName.toLowerCase();
        // check to see if item has existed in the potion shop
        if (!inventory.containsKey(itemNameLowerCase)) {
            String potionNameFormatted = itemNameLowerCase
                    .transform(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
            System.out.println("Apologies, but we cannot purchase " + potionNameFormatted + " here.");
            return false;
        } else {
            // getting quantity and price from itemName and assigning to
            // itemPriceAndQuantity
            itemPriceAndQuantity = inventory.get(itemNameLowerCase);
            // adding 1 to the item quantity
            itemPriceAndQuantity.put("quantity", itemPriceAndQuantity.get("quantity") + 1);
            // updating inventory and return true
            inventory.put(itemNameLowerCase, itemPriceAndQuantity);
            String potionNameFormatted = itemNameLowerCase
                    .transform(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
            System.out.println("Thanks, I can always use more " + potionNameFormatted + "!");
            return true;
        }
    }

    public Integer priceCheck(String itemName) {
        String itemNameLowerCase = itemName.toLowerCase();
        // if item is not in shop inventory, return -1
        if (!inventory.containsKey(itemNameLowerCase)) {
            return -1;
        } else {
            // otherwise, access price through inventory item name and return price as int
            itemPriceAndQuantity = inventory.get(itemNameLowerCase);
            itemPrice = itemPriceAndQuantity.get("price");

            return itemPrice;
        }
    }

    public Integer quantityCheck(String itemName) {
        String itemNameLowerCase = itemName.toLowerCase();
        // if item is not in shop inventory, return -1
        if (!inventory.containsKey(itemNameLowerCase)) {
            return -1;
        } else {
            // otherwise, access quantity through inventory item name and return quantity as
            // int
            itemPriceAndQuantity = inventory.get(itemNameLowerCase);
            itemQuantity = itemPriceAndQuantity.get("quantity");

            return itemQuantity;
        }
    }

    public void printInventory() {
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
    }
}