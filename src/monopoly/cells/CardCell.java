package monopoly.cells;

import monopoly.Cell;
import monopoly.enums.CardType;

/**
 * Class CardCell: Description of its purpose.
 */
public class CardCell extends Cell {
    private final CardType type;
    
/**
 * Method CardCell: Description of its purpose.
 */
    public CardCell(CardType type, String name) {
        super.setName(name);
        this.type = type;
    }
    
/**
 * Method getType: Description of its purpose.
 */
    public CardType getType() {
        return type;
    }
}
