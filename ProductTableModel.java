import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"ID", "Name", "Brand", "Category", "Location", "Stock"};

    private List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getBrand();
            case 3:
                return product.getCategory();
            case 4:
                return product.getLocation();
            case 5:
                return product.getStock();
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);

        switch (columnIndex) {
            case 0:
                product.setId((int) value);
                break;
            case 1:
                product.setName((String) value);
                break;
            case 2:
                product.setBrand((String) value);
                break;
            case 3:
                product.setCategory((String) value);
                break;
            case 4:
                product.setLocation((String) value);
                break;
            case 5:
                product.setStock((int) value);
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Allow editing of the stock column, but not the ID column
        return columnIndex == 5;
    }
}
