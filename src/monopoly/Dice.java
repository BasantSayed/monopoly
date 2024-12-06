package monopoly;

import java.util.Arrays;

/**
 * Class Dice: Description of its purpose.
 */
public class Dice {
    private static final int DICE_SIDES = 6;
    private final int[] dice;
    
/**
 * Method Dice: Description of its purpose.
 */
    public Dice(int diceAmount) {
        dice = new int[diceAmount];
        roll();
    }

/**
 * Method getRoll: Description of its purpose.
 */
    public int[] getRoll() {
        roll();
        return dice;
    }
    
/**
 * Method getSingleDice: Description of its purpose.
 */
    public int getSingleDice(int diceNumber) {
        return dice[diceNumber];
    }
    
/**
 * Method getTotal: Description of its purpose.
 */
    public int getTotal() {
        return Arrays.stream(dice).sum();
    }
    
/**
 * Method roll: Description of its purpose.
 */
    public final void roll() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = (int)(Math.random() * DICE_SIDES) + 1;
        }
    }

/**
 * Method setDice: Description of its purpose.
 */
    public void setDice(int diceNumber, int value) {
        dice[diceNumber] = value;
    }
    
    
}
