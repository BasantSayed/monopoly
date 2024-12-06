package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class CCCellInfoFormatter: Description of its purpose.
 */
public class CCCellInfoFormatter implements CellInfoFormatter {
    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
        return "<html><font color='black'><b>" + cell.getName() + "</b></font></html>";
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        return "<html><font color='black'><b>" + cell.getName() + "</b></font></html>";
    }
}
