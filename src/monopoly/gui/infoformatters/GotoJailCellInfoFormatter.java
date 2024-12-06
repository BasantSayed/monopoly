package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class GotoJailCellInfoFormatter: Description of its purpose.
 */
public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
    	return GOTO_JAIL_LABEL;
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        return GOTO_JAIL_LABEL;
    }
}
