package monopoly;

/**
 * Class TradeDeal: Description of its purpose.
 */
public class TradeDeal {
    private final int amount;
    private final Player buyer;
    private final Cell property;
    private final String propertyName;
    private final Player seller;
    
/**
 * Method TradeDeal: Description of its purpose.
 */
    public TradeDeal(Cell property, Player buyer, int amount) {
        this.propertyName = property.getName();
        this.seller = property.getOwner();
        this.buyer = buyer;
        this.amount = amount;
        this.property = property;
    }
    
/**
 * Method getAmount: Description of its purpose.
 */
    public int getAmount() {
        return amount;
    }
    
/**
 * Method getBuyer: Description of its purpose.
 */
    public Player getBuyer() {
        return this.buyer;
    }
    
/**
 * Method getProperty: Description of its purpose.
 */
    public Cell getProperty() {
        return property;
    }
    
/**
 * Method getPropertyName: Description of its purpose.
 */
    public String getPropertyName() {
        return propertyName;
    }

/**
 * Method getSeller: Description of its purpose.
 */
    public Player getSeller() {
        return this.seller;
    }
    
/**
 * Method makeMessage: Description of its purpose.
 */
    public String makeMessage() {
        String message =
                this.buyer + " wishes to purchase " + propertyName +
                " from you for $" + this.amount +
                ". Do you wish to trade your property?";
        return message;
    }
}
