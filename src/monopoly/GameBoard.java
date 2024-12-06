package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import monopoly.cells.GoCell;
import monopoly.cells.PropertyCell;
import monopoly.enums.CardType;
import monopoly.enums.ColorGroup;

/**
 * Class GameBoard: Description of its purpose.
 */
public class GameBoard {

    private final List<Cell> cells = new ArrayList<>();
    private final List<Card> chanceCards = new ArrayList<>();
    private final List<Card> communityChestCards = new ArrayList<>();
    //the key of propertyColors is the name of the color group.
    private final Map<ColorGroup, Integer> propertyColors = new HashMap<>();

/**
 * Method GameBoard: Description of its purpose.
 */
    public GameBoard() {
        Cell go = new GoCell();
        addCell(go);
    }

/**
 * Method addCard: Description of its purpose.
 */
    public void addCard(Card card) {
        if (card.getCardType() == CardType.CC)
            communityChestCards.add(card);
        else
            chanceCards.add(card);
    }

/**
 * Method addCell: Description of its purpose.
 */
    public final void addCell(Cell cell) {
        cells.add(cell);
    }
	
/**
 * Method addCell: Description of its purpose.
 */
    public void addCell(PropertyCell cell) {
        int propertyNumber = getPropertyNumberForColor(cell.getColorGroup());
        propertyColors.put(cell.getColorGroup(), propertyNumber + 1);
        cells.add(cell);
    }

/**
 * Method drawCCCard: Description of its purpose.
 */
    public Card drawCCCard() {
        Card card = communityChestCards.remove(0);
        addCard(card);
        return card;
    }

/**
 * Method drawChanceCard: Description of its purpose.
 */
    public Card drawChanceCard() {
        Card card = chanceCards.remove(0);
        addCard(card);
        return card;
    }

/**
 * Method getCell: Description of its purpose.
 */
    public Cell getCell(int index) {
        return cells.get(index);
    }
	
/**
 * Method getCellSize: Description of its purpose.
 */
    public int getCellSize() {
        return cells.size();
    }
	
/**
 * Method getPropertiesInMonopoly: Description of its purpose.
 */
    public List<PropertyCell> getPropertiesInMonopoly(ColorGroup color) {
        List<PropertyCell> monopolyCells = new ArrayList<>();
        cells.stream().filter((cell) 
                            -> (cell instanceof PropertyCell)).map((cell)
                            -> (PropertyCell)cell).filter((pc) 
                            -> (pc.getColorGroup().equals(color))).forEach((pc) -> {
                                monopolyCells.add(pc);
                            });
        return monopolyCells;
    }
	
/**
 * Method getPropertyNumberForColor: Description of its purpose.
 */
    public int getPropertyNumberForColor(ColorGroup colorGroup) {
        Integer number = propertyColors.get(colorGroup);
        if (number != null)
            return number;
        return 0;
    }

/**
 * Method queryCell: Description of its purpose.
 */
    public Cell queryCell(String string) {
        for (Cell cell : cells) {
            if (cell.getName().equals(string))
                return cell;
        }
        return null;
    }
	
/**
 * Method queryCellIndex: Description of its purpose.
 */
    public int queryCellIndex(String string){
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).getName().equals(string))
                return i;
        }
        return -1;
    }

/**
 * Method removeCards: Description of its purpose.
 */
    public void removeCards() {
        communityChestCards.clear();
    }
    
/**
 * Method shuffleCards: Description of its purpose.
 */
    public final void shuffleCards() {
        Collections.shuffle(communityChestCards);
        Collections.shuffle(chanceCards);
    }
}
