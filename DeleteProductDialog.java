import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductDialog extends JDialog {
    private int productId;

    public DeleteProductDialog(JFrame parent, int productId) {
        super(parent, "Delete Product", true);

        this.productId = productId;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());

        // Create the message label
        JLabel messageLabel = new JLabel("Are you sure you want to delete this product?");
        contentPane.add(messageLabel, BorderLayout.CENTER);

        // Create the OK and Cancel buttons
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete the product from the inventory
                InventoryImpl.getInstance().deleteProduct(productId);

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
