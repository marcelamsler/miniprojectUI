package tablemodel;

import domain.Book;
import domain.Copy;
import domain.Library;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DetailBookWindowTableModel extends AbstractTableModel {

    Library library;
    Book book;
    List<Copy> list;

    public DetailBookWindowTableModel(Library library, Book book) {
        this.library = library;
        this.book = book;
        this.list = library.getCopiesOfBook(book);
    }

    private String[] columnNames = {"ID", "Titel", "Zustand", "Status"};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Copy column = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return column.getInventoryNumber();

            case 1:
                return column.getTitle();

            case 2:
                return column.getCondition();
            case 3:
                if (library.isCopyLent(column)) {
                    return "ausgeliehen";
                } else {
                    return "verfügbar";
                }

            default:
                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");

        }
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

}
