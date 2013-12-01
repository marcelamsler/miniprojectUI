package tablemodel;

import domain.Customer;
import domain.Library;

import javax.swing.table.AbstractTableModel;
import java.util.List;

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

    private String[] columnNames = {"Status", "Name", "Vorname", "Strasse", "Ort"};


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

        switch (columnIndex) {

            case 0:
                return library.getCustomerStatus(column);
            case 1:
                return column.getName();

            case 2:
                return column.getSurname();

            case 3:
                return column.getStreet();

            case 4:
                return column.getCity();

            default:
                throw new UnsupportedOperationException("Da ist wohl was Schiefgelaufen beim laden der Daten in die Tabelle");
        }
    }
}
