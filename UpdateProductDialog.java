import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProductDialog extends JDialog {
    private JTextField idField;
    private JTextField nameField;
    private JTextField brandField;
    private JTextField categoryField;
    private JTextField locationField;
    private JSpinner stockSpinner;

    private Inventory inventory;
    private Product product;

    public UpdateProductDialog(JFrame parent, Inventory inventory, Product product) {
        super(parent, "Update Product", true);

        this.inventory = inventory;
        this.product = product;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());

        // Create the input fields
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        idField = new JTextField(Integer.toString(product.getId()));
        idField.setEditable(false);
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        nameField = new JTextField(product.getName());
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        brandField = new JTextField(product.getBrand());
        inputPanel.add(new JLabel("Brand:"));
        inputPanel.add(brandField);
        categoryField = new JTextField(product.getCategory());
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        locationField = new JTextField(product.getLocation());
        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(locationField);
        stockSpinner = new JSpinner(new SpinnerNumberModel(product.getStock(), 0, 999, 1));
        inputPanel.add(new JLabel("Stock:"));
        inputPanel.add(stockSpinner);

        // Add the input panel to the content pane
        contentPane.add(inputPanel, BorderLayout.CENTER);

        // Create the OK and Cancel buttons
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the product with the input values
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String brand = brandField.getText();
                String category = categoryField.getText();
                String location = locationField.getText();
                int stock = (int) stockSpinner.getValue();
                Product updatedProduct = new Product(id, name, brand, category, location, stock);

                inventory.updateProduct(updatedProduct);

                // Close the dialog box
                dispose();
            }
        });
        buttonPanel.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the dialog box
                dispose();
            }
        });
        buttonPanel.add(cancelButton);

        // Add the button panel to the content pane
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }
}
