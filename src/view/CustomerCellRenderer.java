package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomerCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            if(table.getValueAt(row, 2).toString().equals("überfällig")){
                cellComponent.setBackground(Color.YELLOW);
            } else if(table.getValueAt(row, 2).toString().equals("zu viel ausgeliehene Bücher")){
                cellComponent.setBackground(Color.YELLOW);
            } else if(table.getValueAt(row, 2).toString().equals("überfällig und zu viel ausgeliehene Bücher")){
                cellComponent.setBackground(Color.RED);
            } else {
                cellComponent.setBackground(Color.GREEN);
            }
            return this;
        } else {
            return this;
        }
    }

}
