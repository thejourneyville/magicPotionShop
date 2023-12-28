import java.util.HashMap;
import java.util.Map;

public class Traveller {

    // declaring variables
    public int meseta;
    public Map<String, Integer> inventory;

    // instance initializer block
    {
        meseta = 300;
        inventory = new HashMap<>();
        inventory.put("monomate", 1);
        inventory.put("gold", 1);
    }

    public void addItem(String itemName) {
        // if the item is already in inventory, add 1
        if (inventory.containsKey(itemName)) {
            inventory.put(itemName, inventory.get(itemName) + 1);
        } else {
            // If the item is not in the inventory, add it with quantity 1
            inventory.put(itemName, 1);
        }
        System.out.println("You place 1 " + itemName + " in your backpack.");
    }

    public void removeItem(String itemName) {
        // checks to see if item does not exist in backpack
        if (!inventory.containsKey(itemName)) {
            System.out.println("You do not have any " + itemName + " in your backpack!");
        } else {
            // reduces inventory of item by 1 if > 0
            if (inventory.get(itemName) > 0) {
                inventory.put(itemName, inventory.get(itemName) - 1);
                System.out.println("You remove 1 " + itemName + " from your backpack.");
            }
            // otherwise removes key/value pair from hashtable if inventory is 0
            if (inventory.get(itemName) == 0) {
                inventory.remove(itemName);
            }
            
        }
    }

    public void addMeseta(Integer amount) {
        // adds given amount of meseta
        meseta += amount;
        System.out.println("You receive " + amount + " meseta.");
    }

    public void removeMeseta(Integer amount) {
        // removes given amount of meseta
        meseta -= amount;
        System.out.println("You pay the shopkeeper " + amount + " meseta.");
    }

    public void printBackpack() {
        // checks to see if backpack is empty using 'size' method
        if (inventory.size() < 1) {
            System.out.println("Your backpack is empty traveller!");
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
    }

    public Map<String, Integer> backpackInventory() {
        // returns hashmap
        return inventory;
    }
}