package monopoly;

public abstract class Cell {
    private boolean available = true;
    private String name;
    protected Player player;

/**
 * Method getName: Description of its purpose.
 */
    public String getName() {
        return name;
    }

/**
 * Method getOwner: Description of its purpose.
 */
    public Player getOwner() {
        return player;
    }
	
/**
 * Method getPrice: Description of its purpose.
 */
    public int getPrice() {
        return 0;
    }

/**
 * Method isAvailable: Description of its purpose.
 */
    public boolean isAvailable() {
        return available;
    }
	
/**
 * Method playAction: Description of its purpose.
 */
    public void playAction(MainController mainCtl) {};

/**
 * Method setAvailable: Description of its purpose.
 */
    public void setAvailable(boolean available) {
        this.available = available;
    }
	
/**
 * Method setName: Description of its purpose.
 */
    public void setName(String name) {
        this.name = name;
    }

/**
 * Method setPlayer: Description of its purpose.
 */
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    @Override
/**
 * Method toString: Description of its purpose.
 */
    public String toString() {
        return name;
    }
}
