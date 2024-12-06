package monopoly.cells;

import monopoly.Cell;
import monopoly.MainController;
import monopoly.Player;
import monopoly.enums.ColorGroup;

/**
 * Class PropertyCell: Description of its purpose.
 */
public class PropertyCell extends Cell {
    private ColorGroup colorGroup;
    private int housePrice;
    private int numHouses;
    private int originalRent = 0;
    private int rent;
    private int sellPrice;
    
/**
 * Method getColorGroup: Description of its purpose.
 */
    public ColorGroup getColorGroup() {
        return colorGroup;
    }

/**
 * Method getHousePrice: Description of its purpose.
 */
    public int getHousePrice() {
        return housePrice;
    }

/**
 * Method getNumHouses: Description of its purpose.
 */
    public int getNumHouses() {
        return numHouses;
    }
    
/**
 * Method getRent: Description of its purpose.
 */
    public int getRent() {
        return rent;
    }
    
/**
 * Method originalRent: Description of its purpose.
 */
    public int originalRent() {
        return originalRent;
    }

/**
 * Method setColorGroup: Description of its purpose.
 */
    public void setColorGroup(ColorGroup colorGroup) {
        this.colorGroup = colorGroup;
    }

/**
 * Method setHousePrice: Description of its purpose.
 */
    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

/**
 * Method setNumHouses: Description of its purpose.
 */
    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }

/**
 * Method setPrice: Description of its purpose.
 */
    public void setPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

/**
 * Method setRent: Description of its purpose.
 */
    public void setRent(int rent) {
        if (originalRent == 0)
            originalRent = rent;
        this.rent = rent;
    }
    
    @Override
/**
 * Method getPrice: Description of its purpose.
 */
    public int getPrice() {
        return sellPrice;
    }

    @Override
/**
 * Method playAction: Description of its purpose.
 */
    public void playAction(MainController mainController) {
        Player currentPlayer;
        if (!isAvailable()) {
            currentPlayer = mainController.getCurrentPlayer();
            if (player != currentPlayer) {
                mainController.payRentTo(player, rent);
            }
        }
    }
}