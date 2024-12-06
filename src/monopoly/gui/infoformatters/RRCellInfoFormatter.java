package monopoly.gui.infoformatters;

import monopoly.Cell;
import monopoly.Player;
import monopoly.cells.RailRoadCell;
import monopoly.gui.CellInfoFormatter;

/**
 * Class RRCellInfoFormatter: Description of its purpose.
 */
public class RRCellInfoFormatter implements CellInfoFormatter {
    @Override
/**
 * Method format: Description of its purpose.
 */
    public String format(Cell cell) {
        StringBuilder buf = new StringBuilder();
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font>")
                .append("</html>");
        return buf.toString();
    }
    
    @Override
/**
 * Method formatToolTip: Description of its purpose.
 */
    public String formatToolTip(Cell cell) {
        RailRoadCell c = (RailRoadCell)cell;
        StringBuilder buf = new StringBuilder();
        Player owner = cell.getOwner();
        String ownerName = "";
        if(owner != null) {
            ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("Property price: $")
                .append(c.getPrice())
                .append("<br>Rent price: $")
                .append(c.getRent())
                .append("<br><br>Owner: ")
                .append(ownerName)
                .append("</html>");
        return buf.toString();
    }
}
