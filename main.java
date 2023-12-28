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
        MenuHandler.closeScanner();

    }

}