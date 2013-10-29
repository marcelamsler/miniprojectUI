package tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Book;
import domain.Copy;
import domain.Customer;
import domain.Library;

public class AddLoanWindowCustomerTableModel extends AbstractTableModel {
	Library library;
	
	public AddLoanWindowCustomerTableModel(Library library){
		this.library = library;		
		
	}
	
    private String[] columnNames = {"Kunden-Nr.", "Name", "Status"};
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
    	return 5;
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        Customer column  = library.getCustomers().get(rowIndex);
        
        switch (columnIndex){
            case 0 :
                return column.getId();
                            
            case 1:
            	return column.getSurname() + " " +column.getName();
                            
            case 2:
            	return library.getCustomerStatus(column);
                              
            default:
                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");
                
        }
	}

	public String getColumnName(int col) {
        return columnNames[col];
    }
	
}

