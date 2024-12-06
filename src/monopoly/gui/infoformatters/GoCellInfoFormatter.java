package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class GoCellInfoFormatter: Description of its purpose.
 */
public class GoCellInfoFormatter implements CellInfoFormatter {
    
    public static final String GO_CELL_LABEL = "<html><b>Go</b></html>";
    
    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
        return GO_CELL_LABEL;
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        return GO_CELL_LABEL;
    }
}
