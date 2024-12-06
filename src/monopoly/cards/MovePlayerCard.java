package monopoly.cards;

import monopoly.Card;
import monopoly.Cell;
import monopoly.MainController;
import monopoly.Player;
import monopoly.enums.CardType;

/**
 * Class MovePlayerCard: Description of its purpose.
 */
public class MovePlayerCard extends Card {
    
    private final String destination;
    private final CardType type;

/**
 * Method MovePlayerCard: Description of its purpose.
 */
    public MovePlayerCard(String destination, CardType cardType) {
        this.destination = destination;
        this.type = cardType;
    }

    @Override
/**
 * Method applyAction: Description of its purpose.
 */
    public void applyAction(MainController mainController) {
        Player currentPlayer = mainController.getCurrentPlayer();
        Cell currentPosition = currentPlayer.getPosition();
        int newCell = mainController.getGameBoard().queryCellIndex(destination);
        int currentCell = mainController.getGameBoard().queryCellIndex(currentPosition.getName());
        int diceValue = 0;
        if (currentCell > newCell) {
            diceValue = (mainController.getGameBoard().getCellSize() + 
                         (newCell - currentCell));
        } else if (currentCell <= newCell) {
            diceValue = newCell - currentCell;
        }
        mainController.movePlayer(currentPlayer, diceValue);
    }

    @Override
/**
 * Method getCardType: Description of its purpose.
 */
    public CardType getCardType() {
        return type;
    }

    @Override
/**
 * Method toString: Description of its purpose.
 */
    public String toString() {
        return "Go to " + destination;
    }
}
