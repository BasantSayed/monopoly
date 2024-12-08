package monopoly.gui;

import javax.swing.JOptionPane;
import monopoly.*;

/**
 * The Main class serves as the entry point for the Monopoly game.
 * It initializes the main controller, sets up the game board, handles player inputs,
 * and starts the game.
 */
public class Main {

    // The main controller responsible for managing the game logic.
    private static final MainController MAIN_CONTROLLER = new MainController();

    /**
     * Prompts the user to input the number of players for the game.
     * Ensures the number is within the valid range.
     * 
     * @param window The main window of the game used for dialog prompts.
     * @return The number of players input by the user.
     */
    private static int inputNumberOfPlayers(MainWindow window) {
        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > BoardController.MAX_PLAYER) {
            String numberOfPlayers = JOptionPane.showInputDialog(
                window, 
                "How many players?"
            );
            if (numberOfPlayers == null) {
                System.exit(0); // Exit the program if the input is canceled.
            }
            try {
                numPlayers = Integer.parseInt(numberOfPlayers);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    window, 
                    "Please input a valid number."
                );
                continue;
            }
            if (numPlayers < 2 || numPlayers > BoardController.MAX_PLAYER) {
                JOptionPane.showMessageDialog(
                    window, 
                    "Please input a number between 2 and " + BoardController.MAX_PLAYER + "."
                );
            } else {
                MAIN_CONTROLLER.setNumberOfPlayers(numPlayers);
            }
        }
        return numPlayers;
    }

    /**
     * The main method is the starting point of the application.
     * It initializes the GUI, prompts the user for input, and starts the game.
     * 
     * @param args Optional command-line arguments. 
     *             If provided, the second argument specifies a custom game board class.
     */
    public static void main(String[] args) {
        MainWindow window = new MainWindow(MAIN_CONTROLLER);

        // Load a custom game board if specified in command-line arguments.
        if (args.length > 0) {
            try {
                GameBoard board = (GameBoard) Class.forName(args[1]).newInstance();
                MAIN_CONTROLLER.setGameBoard(board);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(
                    window, 
                    "Class Not Found. Program will exit."
                );
                System.exit(0);
            } catch (IllegalAccessException e) {
                JOptionPane.showMessageDialog(
                    window, 
                    "Illegal Access of Class. Program will exit."
                );
                System.exit(0);
            } catch (InstantiationException e) {
                JOptionPane.showMessageDialog(
                    window, 
                    "Class Cannot be Instantiated. Program will exit."
                );
                System.exit(0);
            }
        }

        // Prompt for the number of players and their names.
        int numPlayers = inputNumberOfPlayers(window);
        for (int i = 0; i < numPlayers; i++) {
            String name = JOptionPane.showInputDialog(
                window, 
                "Please input name for Player " + (i + 1) + ":"
            );
            if (name == null || name.trim().isEmpty()) {
                // Default to "Player X" if no name is provided.
                MAIN_CONTROLLER.getPlayer(i).setName("Player " + (i + 1));
            } else {
                MAIN_CONTROLLER.getPlayer(i).setName(name.trim());
            }
        }

        // Set up the game board and start the game.
        window.setupGameBoard(MAIN_CONTROLLER.getGameBoard());
        window.setVisible(true);
        MAIN_CONTROLLER.setGUI(window);
        MAIN_CONTROLLER.startGame();
    }
}
