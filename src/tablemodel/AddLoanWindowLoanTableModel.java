package tablemodel;

import javax.swing.table.AbstractTableModel;

import domain.Customer;
import domain.Library;
import domain.Loan;

public class AddLoanWindowLoanTableModel extends AbstractTableModel{
	Library library;
	Customer customer;
	
	public AddLoanWindowLoanTableModel(Library library, Customer customer){
		this.library = library;		
		this.customer = customer;	
	}
	
    private String[] columnNames = {"Exemplar-Id", "Titel", "bis", "Status"};
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
    	return library.getCustomerLoans(customer).size();
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        Loan column  = library.getCustomerLoans(customer).get(rowIndex);
        
        switch (columnIndex){
            case 0 :
                return column.getCopy().getInventoryNumber();
                            
            case 1:
            	return column.getCopy().getTitle();
                            
            case 2:
            	return column.getFormattedExpectedReturnDate();
            
            case 3:
    	      	if (column.isOverdue()){
            		return "fällig";
            	}else{
            		return "ok";           	}
            	
                              
            default:
                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");
                
        }
	}

	public String getColumnName(int col) {
        return columnNames[col];
    }
	
}
