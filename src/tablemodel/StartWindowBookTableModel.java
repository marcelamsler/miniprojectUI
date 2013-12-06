package tablemodel;

import domain.Book;
import domain.Library;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

//stupid comment

public class StartWindowBookTableModel extends AbstractTableModel implements Observer {

    Library library;
    List<Book> list;


    public StartWindowBookTableModel(Library library) {

        this.library = library;
        this.list = library.getBooks();
        
        library.addObserver(this);

    }
    
    @Override
    public void update(Observable o, Object arg) {
    	fireTableDataChanged();	
    	System.out.println("StartWindowBookTableModel");
    }


    private String[] columnNames = {"Verfügbar", "Titel", "Author", "Verlag"};


    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Book column = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return library.getNoOfAvailableCopiesOfBook(column);

            case 1:
                return column.getName();

            case 2:
                return column.getAuthor();

            case 3:
                return column.getPublisher();

            default:
                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");

        }
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

}
