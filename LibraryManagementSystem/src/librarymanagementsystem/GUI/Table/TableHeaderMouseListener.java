package librarymanagementsystem.GUI.Table;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.*;

public class TableHeaderMouseListener extends MouseAdapter{
    private JTable table;
    
    public TableHeaderMouseListener(JTable table){
        this.table = table;
    }
    
    public void mouseClicked(MouseEvent event){
        if (SwingUtilities.isRightMouseButton(event)){ // Right Click
            Point point = event.getPoint();
            int column = table.columnAtPoint(point);

            //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
            System.out.println("Column header #" + column + " is clicked.");
        }
    }
}
