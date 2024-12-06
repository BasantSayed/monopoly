package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class ChanceCellInfoFormatter: Description of its purpose.
 */
public class ChanceCellInfoFormatter implements CellInfoFormatter {
    
    public static final String CHANCE_CELL_LABEL = "<html><font color='teal'><b>Chance</b></font></html>";
    
    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
        return CHANCE_CELL_LABEL;
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        return CHANCE_CELL_LABEL;
    }
}
