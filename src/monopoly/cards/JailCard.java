package monopoly.cards;

import monopoly.Card;
import monopoly.MainController;
import monopoly.Player;
import monopoly.enums.CardType;

/**
 * Class JailCard: Description of its purpose.
 */
public class JailCard extends Card {
    private final CardType type;
    
/**
 * Method JailCard: Description of its purpose.
 */
    public JailCard(CardType cardType) {
        type = cardType;
    }

    @Override
/**
 * Method applyAction: Description of its purpose.
 */
    public void applyAction(MainController mainController) {
        Player currentPlayer = mainController.getCurrentPlayer();
        mainController.sendToJail(currentPlayer);
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
        return "Go directly to Jail without collecting $200 when passing GO";
    }
}
