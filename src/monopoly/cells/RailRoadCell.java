package monopoly.cells;

import monopoly.Cell;
import monopoly.MainController;
import monopoly.Player;

/**
 * Class RailRoadCell: Description of its purpose.
 */
public class RailRoadCell extends Cell {
    public static String COLOR_GROUP = "RAILROAD";
    private int baseRent = 0;
    private int price;
    private int rent;
    
/**
 * Method getBaseRent: Description of its purpose.
 */
    public int getBaseRent() {
        return baseRent;
    }

/**
 * Method getRent: Description of its purpose.
 */
    public int getRent() {
        return rent;
    }

/**
 * Method setBaseRent: Description of its purpose.
 */
    public void setBaseRent(int baseRent) {
        this.baseRent = baseRent;
        this.rent = baseRent;
    }

/**
 * Method setPrice: Description of its purpose.
 */
    public void setPrice(int price) {
        this.price = price;
    }

/**
 * Method setRent: Description of its purpose.
 */
    public void setRent(int rent) {
        if (baseRent == 0) {
            baseRent = rent;
        }
        this.rent = rent;
    }
    
    @Override
/**
 * Method getPrice: Description of its purpose.
 */
    public int getPrice() {
        return price;
    }
    
    @Override
/**
 * Method playAction: Description of its purpose.
 */
    public void playAction(MainController mainController) {
        Player currentPlayer;
        if (isAvailable())
            return;
        currentPlayer = mainController.getCurrentPlayer();
        if (player != currentPlayer)
            mainController.payRentTo(player, getRent());
    }
}
