package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class JailCellInfoFormatter: Description of its purpose.
 */
public class JailCellInfoFormatter implements CellInfoFormatter {

    public static final String JAIL_CELL_LABEL = "<html><b>Jail</b></html>";

    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
        return JAIL_CELL_LABEL;
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        return JAIL_CELL_LABEL;
    }

}
