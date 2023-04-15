import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;

public class CustomerUI extends JFrame {
    private Inventory inventory;
    private JTable productTable;
    private JButton purchaseButton;
    private JLabel quantityLabel;
    private JSpinner quantitySpinner;

    public CustomerUI(Inventory inventory) {
        this.inventory = inventory;

        setTitle("Inventory Management System - Customer");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create the purchase button
        purchaseButton = new JButton("Purchase");
//        purchaseButton.setEnabled(false);

        // Create the product table
        productTable = new JTable();
        refreshTable();

        // Set the table cell renderer for the stock column
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        productTable.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);


        // Add an action listener to the purchase button
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(CustomerUI.this, "Please select a product to purchase", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int productId = (int) productTable.getModel().getValueAt(selectedRow, 0);
                int quantity = (int) quantitySpinner.getValue();
                Product product = inventory.getProduct(productId);

                if (product.getStock() < quantity) {
                    JOptionPane.showMessageDialog(CustomerUI.this, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                product.setStock(product.getStock() - quantity);
                inventory.updateProduct(product);
                refreshTable();
            }
        });

        // Create the quantity label and spinner
        quantityLabel = new JLabel("Quantity:");
        SpinnerNumberModel quantityModel = new SpinnerNumberModel(1, 1, 999, 1);
        quantitySpinner = new JSpinner(quantityModel);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());

        // Add the product table to the content pane
        JScrollPane scrollPane = new JScrollPane(productTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Create a button panel and add the purchase button to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(purchaseButton);

        // Add the button panel to the content pane
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Create a quantity panel and add the quantity label and spinner to it
        JPanel quantityPanel = new JPanel();
        quantityPanel.add(quantityLabel);
        quantityPanel.add(quantitySpinner);

        // Add the quantity panel to the content pane
        contentPane.add(quantityPanel, BorderLayout.NORTH);

        setContentPane(contentPane);
    }

    /**
     * Refreshes the product table with the latest data from the inventory.
     */
    public void refreshTable() {
        List<Product> products = inventory.getAllProducts();
        ProductTableModel model = new ProductTableModel(products);
        productTable.setModel(model);

        // Set the row to visible if the row is selected
        if (productTable.getSelectedRow() != -1) {
            purchaseButton.setEnabled(true);
        }
    }
}
