package monopoly;

/**
 * Interface TradeDialog: Represents a dialog used for handling trade negotiations between players.
 * It provides functionality to retrieve trade details based on user interactions.
 */
public interface TradeDialog {

    /**
     * Retrieves the trade deal created through the dialog.
     *
     * @param mainController The main controller of the game to provide necessary context for the trade.
     * @return A {@link TradeDeal} object containing details of the trade agreed upon by the players.
     */
    TradeDeal getTradeDeal(MainController mainController);
}
