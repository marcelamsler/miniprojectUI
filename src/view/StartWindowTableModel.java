package view;

import javax.swing.table.AbstractTableModel;

public class StartWindowTableModel extends AbstractTableModel {
	    private String[] columnNames = {"Verfügbar", "Titel", "Author", "Verlag"};
	    private Object[][] data = {
		    {"Kathy", "Smith",
		        "Snowboarding", new Integer(5), new Boolean(false)},
		       {"John", "Doe",
		        "Rowing", new Integer(3), new Boolean(true)},
		       {"Sue", "Black",
		        "Knitting", new Integer(2), new Boolean(false)},
		       {"Jane", "White",
		        "Speed reading", new Integer(20), new Boolean(true)},
		       {"Joe", "Brown",
		        "Pool", new Integer(10), new Boolean(false)}
		   };
	    
	    public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }

}
