package monopoly;

/**
 * Interface RespondDialog: Represents a dialog that requires a response from the user.
 * Used in scenarios where confirmation or interaction is needed.
 */
public interface RespondDialog {

    /**
     * Gets the user's response from the dialog.
     *
     * @return True if the user responded affirmatively, false otherwise.
     */
    boolean getResponse();
}
