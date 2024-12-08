package monopoly;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The BoardController class manages the state and flow of the Monopoly game,
 * including players, their positions, and turns.
 */
public class BoardController {
    /** Maximum number of players allowed in the game. */
    public static final int MAX_PLAYER = 8;
    
    /** The game board containing all the cells. */
    private GameBoard gameBoard;
    
    /** Colors assigned to players for identification. */
    private final List<Color> playerColors = new ArrayList<>(Arrays.asList(
            new Color(255, 249, 102), /* Player 1 */
            new Color(66, 134, 244),  /* Player 2 */
            new Color(143, 99, 158),  /* Player 3 */
            new Color(209, 155, 20),  /* Player 4 */
            new Color(209, 96, 20),   /* Player 5 */
            new Color(120, 230, 30),  /* Player 6 */
            new Color(206, 57, 72),   /* Player 7 */
            new Color(72, 196, 188)   /* Player 8 */
    ));
    
    /** Number of players who are out of the game. */
    private int outOfGamePlayers = 0;
    
    /** Index of the current player's turn. */
    private int playerTurnIndex = 0;
    
    /** List of all players in the game. */
    private final List<Player> players = new ArrayList<>();

    /**
     * Constructor for BoardController.
     * 
     * @param gameBoard The game board used for the game.
     */
    public BoardController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    /**
     * Gets the current player whose turn it is.
     * 
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return getPlayer(playerTurnIndex);
    }

    /**
     * Gets the index of the current position of a player.
     * 
     * @param player The player whose position index is requested.
     * @return The index of the player's current position on the board.
     */
    public int getCurrentPositionIndex(Player player) {
        Cell currentPosition = player.getPosition();
        return gameBoard.queryCellIndex(currentPosition.getName());
    }

    /**
     * Gets the game board associated with this controller.
     * 
     * @return The game board.
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Calculates the new position index after a dice roll.
     * 
     * @param positionIndex The player's current position index.
     * @param diceValue The value rolled on the dice.
     * @return The new position index after the move.
     */
    public int getNewPositionIndex(int positionIndex, int diceValue) {
        return (positionIndex + diceValue) % gameBoard.getCellSize();    
    }

    /**
     * Gets the total number of players in the game.
     * 
     * @return The total number of players.
     */
    public int getNumberOfPlayers() {
        return players.size();
    }

    /**
     * Gets the number of players who are out of the game.
     * 
     * @return The count of out-of-game players.
     */
    public int getOutOfGamePlayersNumber() {
        return outOfGamePlayers;
    }
    
    /**
     * Gets a player by their index.
     * 
     * @param index The index of the player.
     * @return The player at the specified index.
     */
    public Player getPlayer(int index) {
        return players.get(index);
    }
    
    /**
     * Gets the index of a specific player.
     * 
     * @param player The player whose index is needed.
     * @return The index of the player.
     */
    public int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }
    
    /**
     * Gets the list of all players.
     * 
     * @return The list of players.
     */
    public List<Player> getPlayers() {
        return players;
    }
    
    /**
     * Gets the index of the current turn.
     * 
     * @return The current turn index.
     */
    public int getTurn() {
        return playerTurnIndex;
    }
    
    /**
     * Moves a player based on the dice value rolled.
     * 
     * @param player The player to move.
     * @param diceValue The value rolled on the dice.
     */
    public void movePlayer(Player player, int diceValue) {
        int positionIndex = getCurrentPositionIndex(player);
        int newIndex = getNewPositionIndex(positionIndex, diceValue);
        if (newIndex <= positionIndex || diceValue > gameBoard.getCellSize())
            player.setMoney(player.getMoney() + 200); // Passing Go bonus.
        player.setPosition(gameBoard.getCell(newIndex));
    }
    
    /**
     * Removes a player from the game.
     */
    public void removePlayer() {
        outOfGamePlayers++;
    }
    
    /**
     * Resets the board and player positions.
     */
    public void reset() {    
        for (int i = 0; i < getNumberOfPlayers(); i++) {
            Player player = players.get(i);
            player.setPosition(gameBoard.getCell(0));
        }
        playerTurnIndex = 0;
    }
    
    /**
     * Sets a new game board for the game.
     * 
     * @param board The new game board.
     */
    public void setGameBoard(GameBoard board) {
        this.gameBoard = board;
    }
    
    /**
     * Sets the number of players in the game.
     * 
     * @param number The number of players to set.
     */
    public void setNumberOfPlayers(int number) {
        players.clear();
        for (int i = 0; i < number; i++) {
            Player player = new Player(gameBoard.getCell(0));
            player.setPlayerColor(playerColors.get(i));
            players.add(player);
        }
    }
    
    /**
     * Switches the turn to the next player.
     */
    public void switchTurn() {
        playerTurnIndex = (playerTurnIndex + 1) % getNumberOfPlayers();
    }
}
