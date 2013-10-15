package view;

public class StartWindowTableModel extends AbstractTableModel {
	    private String[] columnNames = {"Verfügbar", "Titel", "Author", "Verlag"};
	    //private Object[][] data = ...//same as before...

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
