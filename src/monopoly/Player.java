package monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import monopoly.cells.PropertyCell;
import monopoly.cells.RailRoadCell;
import monopoly.cells.UtilityCell;
import monopoly.enums.ColorGroup;

/**
 * Class Player: Description of its purpose.
 */
public class Player {
    private final int INITIAL_MONEY = 1500;
    private boolean inJail;
    private int money;
    private String name;
    private boolean isOutOfGame;
    private Color playerColor;
    private Cell position;
    private List<PropertyCell> properties = new ArrayList<>();
    //the key of propertyColors is the name of the playerColor group.
    private final Map<ColorGroup, Integer> propertyColors = new HashMap<>();
    private List<RailRoadCell> railroads = new ArrayList<>();
    private List<UtilityCell> utilities = new ArrayList<>();
    
/**
 * Method Player: Description of its purpose.
 */
    public Player(Cell position) {
        this.position = position;
        inJail = false;
        isOutOfGame = false;
        playerColor = Color.GREEN;
        money = INITIAL_MONEY;
    }
    
/**
 * Method addMoney: Description of its purpose.
 */
    public void addMoney(int money) {
        this.money += money;
    }

/**
 * Method addProperty: Description of its purpose.
 */
    public void addProperty(PropertyCell property) {
        properties.add(property);
        addPropertyColor(property.getColorGroup());
    }
    
/**
 * Method addPropertyColor: Description of its purpose.
 */
    private void addPropertyColor(ColorGroup colorGroup) {
        propertyColors.put(colorGroup, getPropertyNumberForColor(colorGroup) + 1);
    }
    
/**
 * Method addRailRoad: Description of its purpose.
 */
    public void addRailRoad(RailRoadCell railroad) {
        railroads.add(railroad);
        addPropertyColor(ColorGroup.RAILROAD);
    }
    
/**
 * Method addUtility: Description of its purpose.
 */
    public void addUtility (UtilityCell utility) {
        utilities.add(utility);
        addPropertyColor(ColorGroup.UTILITY);
    }

/**
 * Method checkProperty: Description of its purpose.
 */
    public boolean checkProperty(String property) {
        return properties.stream().map((propertie) -> 
                (Cell) propertie).anyMatch((cell) -> 
                (cell.getName().equals(property)));
    }

/**
 * Method getAllProperties: Description of its purpose.
 */
    public List<Cell> getAllProperties() {
        List<Cell> list = new ArrayList<>();
        list.addAll(properties);
        list.addAll(utilities);
        list.addAll(railroads);
        return list;
    }

/**
 * Method getMoney: Description of its purpose.
 */
    public int getMoney() {
            return this.money;
    }

/**
 * Method getName: Description of its purpose.
 */
    public String getName() {
        return name;
    }
    
/**
 * Method getPlayerColor: Description of its purpose.
 */
    public Color getPlayerColor() {
        return playerColor;
    }

/**
 * Method getPosition: Description of its purpose.
 */
    public Cell getPosition() {
        return this.position;
    }
	
/**
 * Method getProperty: Description of its purpose.
 */
    public PropertyCell getProperty(int index) {
        return properties.get(index);
    }
    
/**
 * Method getPropertyCells: Description of its purpose.
 */
    public List<PropertyCell> getPropertyCells() {
        return properties;
    }
    
/**
 * Method getPropertyColors: Description of its purpose.
 */
    public Map<ColorGroup, Integer> getPropertyColors() {
        return propertyColors;
    }
	
/**
 * Method getPropertyCount: Description of its purpose.
 */
    public int getPropertyCount() {
        return properties.size();
    }
    
/**
 * Method getPropertyNumberForColor: Description of its purpose.
 */
    private int getPropertyNumberForColor(ColorGroup colorGroup) {
        Integer number = propertyColors.get(colorGroup);
        if (number != null) {
            return number;
        }
        return 0;
    }
    
/**
 * Method getRailRoadCells: Description of its purpose.
 */
    public List<RailRoadCell> getRailRoadCells() {
        return railroads;
    }

/**
 * Method getUtilityCells: Description of its purpose.
 */
    public List<UtilityCell> getUtilityCells() {
        return utilities;
    }
    
/**
 * Method isBankrupt: Description of its purpose.
 */
    public boolean isBankrupt() {
        return money <= 0;
    }

/**
 * Method isInJail: Description of its purpose.
 */
    public boolean isInJail() {
        return inJail;
    }

/**
 * Method isOutOfGame: Description of its purpose.
 */
    public boolean isOutOfGame() {
        return isOutOfGame;
    }
    
/**
 * Method numberOfRailroads: Description of its purpose.
 */
    public int numberOfRailroads() {
        return railroads.size();
    }

/**
 * Method numberOfUtilities: Description of its purpose.
 */
    public int numberOfUtilities() {
        return utilities.size();
    }
    
/**
 * Method removePropertyCell: Description of its purpose.
 */
    public void removePropertyCell(PropertyCell property) {
        properties.remove(property);
        removePropertyColor(property.getColorGroup());
    }
    
/**
 * Method removePropertyColor: Description of its purpose.
 */
    private void removePropertyColor(ColorGroup colorGroup) {
        propertyColors.remove(colorGroup);
    }
    
/**
 * Method removeRailroadCell: Description of its purpose.
 */
    public void removeRailroadCell(RailRoadCell railroad) {
        railroads.remove(railroad);
        removePropertyColor(ColorGroup.RAILROAD);
    }
    
/**
 * Method removeUtilityCell: Description of its purpose.
 */
    public void removeUtilityCell(UtilityCell utility) {
        utilities.remove(utility);
        removePropertyColor(ColorGroup.UTILITY);
    }
    
/**
 * Method resetProperties: Description of its purpose.
 */
    public void resetProperties() {
        properties = new ArrayList<>();
        railroads = new ArrayList<>();
        utilities = new ArrayList<>();
    }
    
/**
 * Method setInJail: Description of its purpose.
 */
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

/**
 * Method setMoney: Description of its purpose.
 */
    public void setMoney(int money) {
        this.money = money;
    }

/**
 * Method setName: Description of its purpose.
 */
    public void setName(String name) {
        this.name = name;
    }
    
/**
 * Method setOutOfGame: Description of its purpose.
 */
    public void setOutOfGame() {
        isOutOfGame = true;
    }
    
/**
 * Method setPlayerColor: Description of its purpose.
 */
    public void setPlayerColor(Color color) {
        this.playerColor = color;
    }

/**
 * Method setPosition: Description of its purpose.
 */
    public void setPosition(Cell newPosition) {
        this.position = newPosition;
    }
    
/**
 * Method subtractMoney: Description of its purpose.
 */
    public void subtractMoney(int money) {
        this.money -= money;
    }
  
    @Override
/**
 * Method toString: Description of its purpose.
 */
    public String toString() {
        return name;
    }
}
