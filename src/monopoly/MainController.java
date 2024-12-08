package monopoly;

import java.util.List;
import monopoly.cells.CardCell;
import monopoly.cells.JailCell;
import monopoly.enums.CardType;
import monopoly.enums.ColorGroup;
import monopoly.gameboards.GameBoardDefault;
import monopoly.gui.MonopolyGUI;
import monopoly.gui.PlayerPanel;

/**
 * Main controller for the Monopoly game, managing game logic, player actions, 
 * and interactions between GUI, game board, and players.
 */
public class MainController {

    private final BoardController boardController; /**< Manages player positions and board logic. */
    private final Dice dice; /**< Dice used for player movement. */
    private GameBoard gameBoard; /**< Represents the current game board configuration. */
    private MonopolyGUI gui; /**< GUI instance for interacting with the user. */
    private final PropertyController propertyController; /**< Handles property-related logic. */
    private int utilityDiceRoll; /**< Stores the result of a utility dice roll. */

    /**
     * Initializes the main controller with default settings, including the game board, 
     * board controller, property controller, and dice.
     */
    public MainController() {
        gameBoard = new GameBoardDefault();
        boardController = new BoardController(gameBoard);
        propertyController = new PropertyController(boardController);
        dice = new Dice(2);
    }

    /**
     * Handles the event when the "Buy House" button is clicked.
     */
    public void buttonBuyHouseClicked() {
        gui.showBuyHouseDialog(getCurrentPlayer());
    }

/**
 * Method buttonDrawCardClicked: Description of its purpose.
 */
    public Card buttonDrawCardClicked() {
        gui.setDrawCardEnabled(false);
        CardCell cell = (CardCell)getCurrentPlayer().getPosition();
        Card card;
        if (cell.getType() == CardType.CC) {
            card = getGameBoard().drawCCCard();
            card.applyAction(this);
        } else {
            card = getGameBoard().drawChanceCard();
            card.applyAction(this);
        }
        gui.setEndTurnEnabled(true);
        return card;
    }

/**
 * Method buttonEndTurnClicked: Description of its purpose.
 */
    public void buttonEndTurnClicked() {
        setAllButtonEnabled(false);
        getCurrentPlayer().getPosition().playAction(this);
        
        if (getCurrentPlayer().isBankrupt()) {
            getCurrentPlayer().setOutOfGame();
            boardController.removePlayer();
        }
        switchTurn();
        gui.update();
    }

/**
 * Method buttonGetOutOfJailClicked: Description of its purpose.
 */
    public void buttonGetOutOfJailClicked() {
        getOutOfJail();
        if (getCurrentPlayer().isBankrupt()) {
            setAllButtonEnabled(false);
            getCurrentPlayer().setOutOfGame();
            int positionIndex = boardController.getCurrentPositionIndex(getCurrentPlayer());
            gui.removePlayer(getPlayerIndex(getCurrentPlayer()), positionIndex);
            boardController.removePlayer();
            switchTurn();
            gui.update();
        } else {
            gui.setRollDiceEnabled(true);
            gui.setBuyHouseEnabled(propertyController.canBuyHouse());
            gui.setGetOutOfJailEnabled(getCurrentPlayer().isInJail());
            gui.setTradeEnabled(getTurn(), true);
        }
    }

/**
 * Method buttonPurchasePropertyClicked: Description of its purpose.
 */
    public void buttonPurchasePropertyClicked() {
        purchase();
        gui.setPurchasePropertyEnabled(false);
        gui.update();
    }
    
/**
 * Method buttonRollDiceClicked: Description of its purpose.
 */
    public void buttonRollDiceClicked(PlayerPanel panel) {
        dice.roll();
        if ((dice.getTotal()) > 0) {
            Player player = getCurrentPlayer();
            gui.setRollDiceEnabled(false);
            StringBuilder msg = new StringBuilder();
            msg.append("You rolled ")
                    .append(dice.getSingleDice(0))
                    .append(" and ")
                    .append(dice.getSingleDice(1));
            gui.showMessage(msg.toString(), panel);
            movePlayer(player, dice.getTotal());
            gui.setBuyHouseEnabled(false);
        }
    }

/**
 * Method buttonTradeClicked: Description of its purpose.
 */
    public void buttonTradeClicked() {
        TradeDialog dialog = gui.openTradeDialog();
        TradeDeal deal = dialog.getTradeDeal(this);
        if (deal != null) {
            RespondDialog respondDialog = gui.openRespondDialog(deal);
            if (respondDialog.getResponse()) {
                completeTrade(deal);
                gui.update();
            }
        }
    }
    
/**
 * Method canBuyHouse: Description of its purpose.
 */
    public boolean canBuyHouse() {
        return propertyController.canBuyHouse();
    }

/**
 * Method completeTrade: Description of its purpose.
 */
    public void completeTrade(TradeDeal deal) {
        propertyController.sellProperty(deal);
        propertyController.buyProperty(deal);
    }

/**
 * Method drawCCCard: Description of its purpose.
 */
    public Card drawCCCard() {
        return gameBoard.drawCCCard();
    }

/**
 * Method drawChanceCard: Description of its purpose.
 */
    public Card drawChanceCard() {
        return gameBoard.drawChanceCard();
    }
    
/**
 * Method finishPlayerMove: Description of its purpose.
 */
    private void finishPlayerMove(Player player) {
        Cell cell = player.getPosition();
        int playerIndex = getPlayerIndex(player);
        if (cell instanceof CardCell) {
            gui.setDrawCardEnabled(true);
        } else {
            if (cell.isAvailable()) {
                int price = cell.getPrice();
                if (price <= player.getMoney() && price > 0)
                    gui.enablePurchaseButton(playerIndex);
            }
            gui.enableEndTurnButton(playerIndex);
        }
        gui.setTradeEnabled(boardController.getTurn(), false);
    }

/**
 * Method getCurrentPlayer: Description of its purpose.
 */
    public Player getCurrentPlayer() {
        return boardController.getCurrentPlayer();
    }
    
/**
 * Method getDice: Description of its purpose.
 */
    public Dice getDice() {
        return dice;
    }

/**
 * Method getGUI: Description of its purpose.
 */
    public MonopolyGUI getGUI() {
        return gui;
    }
    
/**
 * Method getGameBoard: Description of its purpose.
 */
    public GameBoard getGameBoard() {
        return gameBoard;
    }
    
/**
 * Method getMonopolies: Description of its purpose.
 */
    public List<ColorGroup> getMonopolies(Player player) {
        return propertyController.getMonopolies(player);
    }

/**
 * Method getNumberOfPlayers: Description of its purpose.
 */
    public int getNumberOfPlayers() {
        return boardController.getNumberOfPlayers();
    }
    
/**
 * Method getOutOfJail: Description of its purpose.
 */
    private void getOutOfJail() {
        Player currentPlayer = boardController.getCurrentPlayer();
        currentPlayer.subtractMoney(JailCell.BAIL);
        if (currentPlayer.isBankrupt()) {
            currentPlayer.setMoney(0);
            giveAllProperties(currentPlayer, null);
        }
        currentPlayer.setInJail(false);
        gui.update();
    }

/**
 * Method getPlayer: Description of its purpose.
 */
    public Player getPlayer(int index) {
        return boardController.getPlayer(index);
    }

/**
 * Method getPlayerIndex: Description of its purpose.
 */
    public int getPlayerIndex(Player player) {
        return boardController.getPlayerIndex(player);
    }

/**
 * Method getSellerList: Description of its purpose.
 */
    public List<Player> getSellerList() {
        return propertyController.getSellerList();
    }
    
/**
 * Method getTurn: Description of its purpose.
 */
    public int getTurn() {
        return boardController.getTurn();
    }

/**
 * Method getUtilityDiceRoll: Description of its purpose.
 */
    public int getUtilityDiceRoll() {
        return this.utilityDiceRoll;
    }
    
/**
 * Method giveAllProperties: Description of its purpose.
 */
    public void giveAllProperties(Player fromPlayer, Player toPlayer) {
        propertyController.giveAllProperties(fromPlayer, toPlayer);
    }

/**
 * Method movePlayer: Description of its purpose.
 */
    public void movePlayer(Player player, int diceValue) {
        int positionIndex = boardController.getCurrentPositionIndex(player);
        int newIndex = boardController.getNewPositionIndex(positionIndex, diceValue);
        
        boardController.movePlayer(player, diceValue);
        gui.movePlayer(getPlayerIndex(player), positionIndex, newIndex);
        finishPlayerMove(player);

        gui.update();
    }
    
/**
 * Method payRentTo: Description of its purpose.
 */
    public void payRentTo(Player owner, int rent) {
        propertyController.payRentTo(owner, rent);
    }
    
/**
 * Method purchase: Description of its purpose.
 */
    public void purchase() {
        propertyController.purchase();
    }
    
/**
 * Method purchaseHouse: Description of its purpose.
 */
    public void purchaseHouse(ColorGroup selectedMonopoly, int houses) {
        if (propertyController.purchaseHouse(selectedMonopoly, houses) <= 5)
            gui.update();
    }

/**
 * Method reset: Description of its purpose.
 */
    public void reset() {
        boardController.reset();
        if (gameBoard != null)
            gameBoard.removeCards();
    }
	
/**
 * Method sendToJail: Description of its purpose.
 */
    public void sendToJail(Player player) {
        String currentPlayerName = getCurrentPlayer().getPosition().getName();
        int oldPosition = gameBoard.queryCellIndex(currentPlayerName);
        player.setPosition(gameBoard.queryCell("Jail"));
        player.setInJail(true);
        int jailIndex = gameBoard.queryCellIndex("Jail");
        gui.movePlayer(getPlayerIndex(player), oldPosition, jailIndex);
    }
    
/**
 * Method setAllButtonEnabled: Description of its purpose.
 */
    private void setAllButtonEnabled(boolean enabled) {
        gui.setRollDiceEnabled(enabled);
        gui.setPurchasePropertyEnabled(enabled);
        gui.setEndTurnEnabled(enabled);
        gui.setTradeEnabled(boardController.getTurn(), enabled);
        gui.setBuyHouseEnabled(enabled);
        gui.setDrawCardEnabled(enabled);
        gui.setGetOutOfJailEnabled(enabled);
    }
    
/**
 * Method setGUI: Description of its purpose.
 */
    public void setGUI(MonopolyGUI gui) {
        this.gui = gui;
    }

/**
 * Method setGameBoard: Description of its purpose.
 */
    public void setGameBoard(GameBoard board) {
        this.gameBoard = board;
        boardController.setGameBoard(board);
    }

/**
 * Method setNumberOfPlayers: Description of its purpose.
 */
    public void setNumberOfPlayers(int number) {
        boardController.setNumberOfPlayers(number);
    }

/**
 * Method startGame: Description of its purpose.
 */
    public void startGame() {
        gui.startGame();
        gui.enablePlayerTurn(0);
        gui.setTradeEnabled(0, true);
    }

/**
 * Method switchTurn: Description of its purpose.
 */
    public void switchTurn() {
        boardController.switchTurn();
        
        if (getCurrentPlayer().isOutOfGame()) {
            switchTurn();
            return;
        }
        if (boardController.getOutOfGamePlayersNumber() + 1 >= boardController.getNumberOfPlayers()) {
            setAllButtonEnabled(false);
            return;
        }
        if (!getCurrentPlayer().isInJail()) {
            gui.enablePlayerTurn(boardController.getTurn());
            gui.setBuyHouseEnabled(propertyController.canBuyHouse());
            gui.setTradeEnabled(boardController.getTurn(), true);
        } else {
            gui.setGetOutOfJailEnabled(true);
        }
    }

/**
 * Method utilityRollDice: Description of its purpose.
 */
    public void utilityRollDice() {
        this.utilityDiceRoll = gui.showUtilityDiceRoll();
    }
    
}
