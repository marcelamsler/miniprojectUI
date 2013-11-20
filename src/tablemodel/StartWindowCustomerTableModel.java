package tablemodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Customer;
import domain.Library;

public class StartWindowCustomerTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 309455542608279764L;
	
	private Library library;
	private List<Customer> list;
	
	public StartWindowCustomerTableModel(Library library) {
		this.library = library;
		this.list = library.getCustomers();	
	}

    private String[] columnNames = {"Name", "Vorname", "Strasse", "Plz", "Ort"};
    
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return list.size();
    }
	
	@Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

        Customer column = list.get(rowIndex);
        
        switch (columnIndex){
            case 0 : 
                return column.getName();
                            
            case 1:
                return column.getSurname();
                            
            case 2:
                return column.getStreet();
                              
            case 3:
                return column.getZip();
                
            case 4:
            	return column.getCity();
                          
            default:
                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");
        }  
	}
}
