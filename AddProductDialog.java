import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductDialog extends JDialog {
    private JTextField idField;
    private JTextField nameField;
    private JTextField brandField;
    private JTextField categoryField;
    private JTextField locationField;
    private JSpinner stockSpinner;

    private Inventory inventory;

    public AddProductDialog(JFrame parent, Inventory inventory) {
        super(parent, "Add Product", true);

        this.inventory = inventory;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());

        // Create the input fields
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        idField = new JTextField();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        nameField = new JTextField();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        brandField = new JTextField();
        inputPanel.add(new JLabel("Brand:"));
        inputPanel.add(brandField);
        categoryField = new JTextField();
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        locationField = new JTextField();
        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(locationField);
        stockSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
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
                // Create a new product with the input values
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String brand = brandField.getText();
                String category = categoryField.getText();
                String location = locationField.getText();
                int stock = (int) stockSpinner.getValue();
                Product product = new Product(id, name, brand, category, location, stock);

                // Add the new product to the inventory
                inventory.addProduct(product);

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
