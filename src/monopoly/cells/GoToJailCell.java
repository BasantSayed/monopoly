package monopoly.cells;

import monopoly.Cell;
import monopoly.MainController;
import monopoly.Player;

/**
 * Class GoToJailCell: Description of its purpose.
 */
public class GoToJailCell extends Cell {
	
/**
 * Method GoToJailCell: Description of its purpose.
 */
    public GoToJailCell() {
        super.setName("Go to Jail");
    }

    @Override
/**
 * Method playAction: Description of its purpose.
 */
    public void playAction(MainController mainController) {
        Player currentPlayer = mainController.getCurrentPlayer();
        mainController.sendToJail(currentPlayer);
    }
}
