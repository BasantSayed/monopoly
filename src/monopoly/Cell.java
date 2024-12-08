package monopoly;

/**
 * Abstract base class representing a cell on the game board.
 * A cell can be owned by a player, have a name, and be marked as available or unavailable.
 */
public abstract class Cell {
    private boolean available = true; /**< Indicates if the cell is available for purchase or other actions. */
    private String name; /**< The name of the cell. */
    protected Player player; /**< The player who owns this cell, if any. */

    /**
     * Gets the name of the cell.
     *
     * @return The name of the cell.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the owner of the cell.
     *
     * @return The player who owns this cell, or null if no owner.
     */
    public Player getOwner() {
        return player;
    }
    
    /**
     * Gets the price of the cell. Default implementation returns 0.
     * Can be overridden by subclasses to provide specific pricing.
     *
     * @return The price of the cell.
     */
    public int getPrice() {
        return 0;
    }

    /**
     * Checks if the cell is currently available.
     *
     * @return True if the cell is available, false otherwise.
     */
    public boolean isAvailable() {
        return available;
    }
    
    /**
     * Performs an action specific to this cell when a player lands on it.
     * This method is abstract and should be implemented by subclasses.
     *
     * @param mainCtl The main controller managing the game logic.
     */
    public void playAction(MainController mainCtl) {}

    /**
     * Sets the availability of the cell.
     *
     * @param available True to mark the cell as available, false otherwise.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    /**
     * Sets the name of the cell.
     *
     * @param name The name to assign to the cell.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the owner of the cell.
     *
     * @param player The player who owns this cell.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Converts the cell to a string representation.
     *
     * @return The name of the cell as its string representation.
     */
    @Override
    public String toString() {
        return name;
    }
}
