import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminUI extends JFrame {
    private Inventory inventory;
    private JTable productTable;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;

    public AdminUI(Inventory inventory) {
        this.inventory = inventory;

        setTitle("Inventory Management System - Administrator");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create the product table
        productTable = new JTable();
        refreshTable();

        // Create the buttons
        addButton = new JButton("Add Product");
        deleteButton = new JButton("Delete Product");
        updateButton = new JButton("Update Product");
        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProductDialog dialog = new AddProductDialog(AdminUI.this, inventory);
                dialog.setVisible(true);
                refreshTable();
            }

        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(AdminUI.this, "Please select a product to delete", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int productId = (int) productTable.getModel().getValueAt(selectedRow, 0);
                inventory.deleteProduct(productId);
                refreshTable();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(AdminUI.this, "Please select a product to update", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int productId = (int) productTable.getModel().getValueAt(selectedRow, 0);
                Product product = inventory.getProduct(productId);
                UpdateProductDialog dialog = new UpdateProductDialog(AdminUI.this, inventory, product);
                dialog.setVisible(true);
                refreshTable();
            }
        });

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());

        // Add the product table to the content pane
        JScrollPane scrollPane = new JScrollPane(productTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Create a button panel and add the buttons to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        // Add the button panel to the content pane
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }

    /**
     * Refreshes the product table with the latest data from the inventory.
     */
    private void refreshTable() {
        List<Product> products = inventory.getAllProducts();
        ProductTableModel model = new ProductTableModel(products);
        productTable.setModel(model);
    }
}
