import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private boolean success;
    private String username;

    public LoginDialog() {
        super((JFrame) null, "Login", true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Create the content pane
        JPanel contentPane = new JPanel(new BorderLayout());

        // Create the input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        usernameField = new JTextField();
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        passwordField = new JPasswordField();
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        // Set the text fields to editable
        usernameField.setEditable(true);
        passwordField.setEditable(true);

        // Add the input panel to the content pane
        contentPane.add(inputPanel, BorderLayout.CENTER);

        // Create the OK and Cancel buttons
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the username and password are correct
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (checkLogin(username, password)) {
                    success = true;
                    LoginDialog.this.username = username;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginDialog.this, "Invalid username or password");
                }
            }
        });
        buttonPanel.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success = false;
                dispose();
            }
        });
        buttonPanel.add(cancelButton);

        // Add the button panel to the content pane
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }

    public boolean isSucceeded() {
        return success;
    }

    public String getUsername() {
        return username;
    }

    private boolean checkLogin(String username, String password) {
        // Check if the username and password are correct
        // In a real program, this would involve querying a database or some other form of authentication
        // For this example, we'll use some hard-coded values
        if (username.equals("admin") && password.equals("admin123")) {
            return true;
        } else if (username.equals("user1") && password.equals("user1pass")) {
            return true;
        } else if (username.equals("user2") && password.equals("user2pass")) {
            return true;
        } else {
            return false;
        }
    }
}
