package monopoly;

import monopoly.enums.CardType;

/**
 * Represents an abstract base class for different types of cards in the Monopoly game.
 * Each card must implement actions specific to its type and define its card type.
 */
public abstract class Card {

    /**
     * Executes the action associated with this card.
     *
     * @param mainController the main controller that manages the game state.
     */
    public abstract void applyAction(MainController mainController);

    /**
     * Gets the type of this card.
     *
     * @return the {@link CardType} of this card.
     */
    public abstract CardType getCardType();
}
