// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {

        Traveller traveller = new Traveller();

        PotionShop potionShop = new PotionShop();
        potionShop.addItem("monomate", 10, 1);
        potionShop.addItem("dimate", 20, 25);
        potionShop.addItem("trimate", 301, 12);

        // tests
        // System.out.println("Initial Inventory: " + traveller.inventory);
        // traveller.addItem("monomate");
        // System.out.println("Inventory: " + traveller.inventory);
        // traveller.removeItem("Dimate");
        // System.out.println("Inventory: " + traveller.inventory);
        // System.out.println(traveller.meseta);
        // traveller.addMeseta(1234);
        // System.out.println(traveller.meseta);
        // traveller.removeMeseta(100);
        // System.out.println(traveller.meseta);
        // traveller.printBackpack();
        // Map<String, Integer> result = traveller.backpackInventory();
        // System.out.println(result);
        // System.out.println("POTION SHOP");
        // System.out.println(potionShop.inventory);

        // System.out.println(potionShop.inventory);
        // potionShop.sellItem("monomate");
        // potionShop.sellItem("dimate");
        // potionShop.sellItem("oogabooga");
        // System.out.println(potionShop.inventory);
        // potionShop.buyItem("oogabooga");
        // potionShop.buyItem("monomate");
        // System.out.println(potionShop.inventory);
        // System.out.println(potionShop.priceCheck("dimate"));
        // System.out.println(potionShop.quantityCheck("dimate"));
        // System.out.println(potionShop.quantityCheck("monomate"));
        // System.out.println(potionShop.quantityCheck("dimatefjdklfsjd"));
        // potionShop.printInventory();
        // System.out.println(InventoryUtils.checkItemExistence("MoNomAte",
        // potionShop.inventory));
        // System.out.println(InventoryUtils.checkItemExistence("",
        // potionShop.inventory));
        boolean exitShop = false;
        while (!exitShop) {
            String userInput = MenuHandler.mainMenu();
            switch (userInput) {
                case "B":
                    String potionToBuy = MenuHandler.buyMenu(traveller.meseta, potionShop.inventory);
                    if (potionToBuy != "" &&
                            InventoryUtils.checkItemExistence(potionToBuy, potionShop.inventory) &&
                            InventoryUtils.checkTravellerAffordItem(potionToBuy, traveller.meseta,
                                    potionShop.priceCheck(potionToBuy))
                            &&
                            InventoryUtils.checkUserBackpackLimit(traveller.inventory) &&
                            potionShop.sellItem(potionToBuy)) {
                        traveller.removeMeseta(potionShop.priceCheck(potionToBuy));
                        traveller.addItem(potionToBuy);
                    }
                    break;
                case "S":
                    String potionToSell = MenuHandler.sellMenu(traveller.meseta, traveller.inventory);
                    if (potionToSell != "" &&
                            InventoryUtils.checkTravellerHasItem(potionToSell, traveller.inventory) &&
                            potionShop.buyItem(potionToSell)) {
                        traveller.removeItem(potionToSell);
                        traveller.addMeseta(potionShop.priceCheck(potionToSell));
                    }
                    break;
                case "C":
                    traveller.printBackpack();
                    break;
                case "I":
                    potionShop.printInventory();
                    break;
                case "X":
                    exitShop = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        // tests
        // System.out.println("travller inventory: " + traveller.inventory);
        // System.out.println(InventoryUtils.checkTravellerHasItem("Monomate",
        // traveller.backpackInventory()));
        // System.out.println(InventoryUtils.checkTravellerHasItem("poopy",
        // traveller.backpackInventory()));
        // System.out.println(InventoryUtils.checkTravellerAffordItem("Trimate", 42,
        // potionShop.priceCheck("Trimate")));
        // InventoryUtils.checkUserBackpackLimit(traveller.backpackInventory());
        // MenuHandler.buyMenu(traveller.meseta, potionShop.inventory);
        // MenuHandler.sellMenu(traveller.meseta, traveller.inventory);

    }

}