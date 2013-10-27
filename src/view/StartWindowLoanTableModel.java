package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Book;
import domain.Copy;
import domain.Library;
import domain.Loan;

public class StartWindowLoanTableModel extends AbstractTableModel {
	
		Library library;
		List<Loan> list;
		
	
		public StartWindowLoanTableModel(Library library){
			
			this.library = library;
			this.list = library.getLoans();
			
		}
	
	

	    private String[] columnNames = {"Status", "Exemplar-ID", "Titel", "Ausgeliehen bis", "Ausgeliehn an"};
	    
	    
	    public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return list.size();
	    }
	    
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    
	        Loan column = list.get(rowIndex);
	        
	        switch (columnIndex){
	            case 0 : 
	            	
	            	
	            	if (column.isOverdue()){
	            		return "fällig";
	            	}else{
	            		return "ok";
	            	}
	                            
	            case 1:
	                return column.getCopy().getInventoryNumber();
	                            
	            case 2:
	                return column.getCopy().getTitle();
	                              
	            case 3:
	            	return column.getFormattedExpectedReturnDate();
	                
	             
	            case 4: 
	            	return column.getCustomer().getSurname() + " " + column.getCustomer().getName();
	                          
	            default:
	                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");
	                
	        }
	    }    

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }

}