package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class FreeParkingCellInfoFormatter: Description of its purpose.
 */
public class FreeParkingCellInfoFormatter implements CellInfoFormatter {
    
    public static final String FP_CELL_LABEL = "<html><b>Free Parking</b></html>";
    
    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
        return FP_CELL_LABEL;
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        return FP_CELL_LABEL;
    }
}
