package monopoly.cards;

import monopoly.Card;
import monopoly.MainController;
import monopoly.Player;
import monopoly.enums.CardType;

/**
 * Class MoneyCard: Description of its purpose.
 */
public class MoneyCard extends Card {
    private final int amount;
    private final CardType cardType;
    
    private final String label;
    
/**
 * Method MoneyCard: Description of its purpose.
 */
    public MoneyCard(String label, int amount, CardType cardType){
        this.label = label;
        this.amount = amount;
        this.cardType = cardType;
    }

    @Override
/**
 * Method applyAction: Description of its purpose.
 */
    public void applyAction(MainController mainController) {
        Player currentPlayer = mainController.getCurrentPlayer();
        currentPlayer.setMoney(currentPlayer.getMoney() + amount);
    }

    @Override
/**
 * Method getCardType: Description of its purpose.
 */
    public CardType getCardType() {
        return cardType;
    }

    @Override
/**
 * Method toString: Description of its purpose.
 */
    public String toString() {
        return label;
    }
}
