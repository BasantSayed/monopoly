package monopoly;

/**
 * Class TradeDeal: Represents the details of a trade transaction between two players in the game.
 * A trade deal includes the buyer, seller, property involved, and the amount offered.
 */
public class TradeDeal {
    private final int amount; // The monetary amount offered for the trade
    private final Player buyer; // The player who is offering to buy the property
    private final Cell property; // The property being traded
    private final String propertyName; // The name of the property being traded
    private final Player seller; // The current owner of the property
    
    /**
     * Constructor TradeDeal: Initializes the details of a trade deal.
     *
     * @param property The property involved in the trade.
     * @param buyer The player who wishes to purchase the property.
     * @param amount The amount of money offered for the property.
     */
    public TradeDeal(Cell property, Player buyer, int amount) {
        this.propertyName = property.getName();
        this.seller = property.getOwner();
        this.buyer = buyer;
        this.amount = amount;
        this.property = property;
    }
    
    /**
     * Retrieves the amount offered for the trade.
     *
     * @return The monetary amount offered in the trade deal.
     */
    public int getAmount() {
        return amount;
    }
    
    /**
     * Retrieves the buyer in the trade deal.
     *
     * @return The player who is offering to buy the property.
     */
    public Player getBuyer() {
        return this.buyer;
    }
    
    /**
     * Retrieves the property involved in the trade deal.
     *
     * @return The property being traded.
     */
    public Cell getProperty() {
        return property;
    }
    
    /**
     * Retrieves the name of the property involved in the trade deal.
     *
     * @return The name of the property being traded.
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Retrieves the seller in the trade deal.
     *
     * @return The player who currently owns the property.
     */
    public Player getSeller() {
        return this.seller;
    }
    
    /**
     * Creates a message summarizing the trade deal for presentation to the seller.
     *
     * @return A string describing the trade deal, including buyer, property name, and offered amount.
     */
    public String makeMessage() {
        String message =
                this.buyer + " wishes to purchase " + propertyName +
                " from you for $" + this.amount +
                ". Do you wish to trade your property?";
        return message;
    }
}
