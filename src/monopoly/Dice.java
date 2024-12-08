package monopoly;

import java.util.Arrays;

/**
 * The {@code Dice} class simulates the behavior of dice used in the Monopoly game.
 * It supports rolling multiple dice, retrieving individual dice values, 
 * calculating the total sum, and setting specific dice values.
 */
public class Dice {

    /**
     * The number of sides on a standard die.
     */
    private static final int DICE_SIDES = 6;

    /**
     * Array representing the values of each die.
     */
    private final int[] dice;

    /**
     * Creates a new {@code Dice} instance with the specified number of dice.
     * Initializes the dice values by rolling them.
     *
     * @param diceAmount the number of dice to be used.
     */
    public Dice(int diceAmount) {
        dice = new int[diceAmount];
        roll();
    }

    /**
     * Rolls all dice and updates their values.
     *
     * @return the updated array of dice values.
     */
    public int[] getRoll() {
        roll();
        return dice;
    }

    /**
     * Retrieves the value of a single die based on its index.
     *
     * @param diceNumber the index of the die to retrieve (0-based).
     * @return the value of the specified die.
     */
    public int getSingleDice(int diceNumber) {
        return dice[diceNumber];
    }

    /**
     * Calculates the total value of all dice.
     *
     * @return the sum of the values of all dice.
     */
    public int getTotal() {
        return Arrays.stream(dice).sum();
    }

    /**
     * Rolls all dice, randomly assigning values between 1 and {@link #DICE_SIDES}.
     */
    public final void roll() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = (int) (Math.random() * DICE_SIDES) + 1;
        }
    }

    /**
     * Sets the value of a specific die.
     *
     * @param diceNumber the index of the die to set (0-based).
     * @param value      the value to assign to the die.
     */
    public void setDice(int diceNumber, int value) {
        dice[diceNumber] = value;
    }
}
