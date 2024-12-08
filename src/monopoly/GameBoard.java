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
 * Class GameBoard:
 * Represents the main game board of Monopoly, managing the cells, cards, 
 * and properties within the game.
 */
public class GameBoard {

    private final List<Cell> cells = new ArrayList<>(); // List of cells on the game board
    private final List<Card> chanceCards = new ArrayList<>(); // Deck of Chance cards
    private final List<Card> communityChestCards = new ArrayList<>(); // Deck of Community Chest cards
    private final Map<ColorGroup, Integer> propertyColors = new HashMap<>(); 
    // Map storing the count of properties for each color group

    /**
     * Constructor GameBoard:
     * Initializes the game board with a "Go" cell.
     */
    public GameBoard() {
        Cell go = new GoCell();
        addCell(go);
    }

    /**
     * Adds a card to the appropriate deck (Chance or Community Chest).
     *
     * @param card The card to add.
     */
    public void addCard(Card card) {
        if (card.getCardType() == CardType.CC)
            communityChestCards.add(card);
        else
            chanceCards.add(card);
    }

    /**
     * Adds a generic cell to the board.
     *
     * @param cell The cell to add.
     */
    public final void addCell(Cell cell) {
        cells.add(cell);
    }

    /**
     * Adds a property cell to the board and updates the property color count.
     *
     * @param cell The property cell to add.
     */
    public void addCell(PropertyCell cell) {
        int propertyNumber = getPropertyNumberForColor(cell.getColorGroup());
        propertyColors.put(cell.getColorGroup(), propertyNumber + 1);
        cells.add(cell);
    }

    /**
     * Draws a Community Chest card from the deck.
     *
     * @return The drawn card.
     */
    public Card drawCCCard() {
        Card card = communityChestCards.remove(0);
        addCard(card);
        return card;
    }

    /**
     * Draws a Chance card from the deck.
     *
     * @return The drawn card.
     */
    public Card drawChanceCard() {
        Card card = chanceCards.remove(0);
        addCard(card);
        return card;
    }

    /**
     * Retrieves a cell by its index on the board.
     *
     * @param index The index of the cell.
     * @return The cell at the given index.
     */
    public Cell getCell(int index) {
        return cells.get(index);
    }

    /**
     * Gets the total number of cells on the board.
     *
     * @return The size of the cell list.
     */
    public int getCellSize() {
        return cells.size();
    }

    /**
     * Retrieves all properties in a specified color group.
     *
     * @param color The color group to filter by.
     * @return A list of properties in the given color group.
     */
    public List<PropertyCell> getPropertiesInMonopoly(ColorGroup color) {
        List<PropertyCell> monopolyCells = new ArrayList<>();
        cells.stream()
            .filter(cell -> (cell instanceof PropertyCell))
            .map(cell -> (PropertyCell) cell)
            .filter(pc -> (pc.getColorGroup().equals(color)))
            .forEach(monopolyCells::add);
        return monopolyCells;
    }

    /**
     * Retrieves the number of properties in a given color group.
     *
     * @param colorGroup The color group to query.
     * @return The number of properties in the color group.
     */
    public int getPropertyNumberForColor(ColorGroup colorGroup) {
        Integer number = propertyColors.get(colorGroup);
        return (number != null) ? number : 0;
    }

    /**
     * Searches for a cell by its name.
     *
     * @param name The name of the cell to search for.
     * @return The cell with the given name, or null if not found.
     */
    public Cell queryCell(String name) {
        for (Cell cell : cells) {
            if (cell.getName().equals(name))
                return cell;
        }
        return null;
    }

    /**
     * Searches for the index of a cell by its name.
     *
     * @param name The name of the cell to search for.
     * @return The index of the cell, or -1 if not found.
     */
    public int queryCellIndex(String name) {
        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    /**
     * Removes all cards from the Community Chest deck.
     */
    public void removeCards() {
        communityChestCards.clear();
    }

    /**
     * Shuffles both the Chance and Community Chest card decks.
     */
    public final void shuffleCards() {
        Collections.shuffle(communityChestCards);
        Collections.shuffle(chanceCards);
    }
}
