import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a new inventory
        Inventory inventory = InventoryImpl.getInstance();


        // Create some example products
        inventory.addProduct(new Product(1, "iPhone", "Apple", "Electronics", "A1", 10));
        inventory.addProduct(new Product(2, "Galaxy S21", "Samsung", "Electronics", "B2", 15));
        inventory.addProduct(new Product(3, "MacBook Pro", "Apple", "Computers", "C3", 5));
        inventory.addProduct(new Product(4, "Pixel 6", "Google", "Electronics", "D4", 20));
        inventory.addProduct(new Product(5, "Surface Laptop 4", "Microsoft", "Computers", "E5", 7));

        // Create a login dialog and show it
        LoginDialog loginDialog = new LoginDialog();
        loginDialog.setVisible(true);

        // Check if the login was successful
        if (loginDialog.isSucceeded()) {
            // Get the logged-in user's username
            String username = loginDialog.getUsername();

            // Check if the user is an admin or customer
            if (UserDatabase.isAdmin(username)) {
                // Create and show the admin UI
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        AdminUI adminUI = new AdminUI(inventory);
                        adminUI.setVisible(true);
                    }
                });
            } else {
                // Create and show the customer UI
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        CustomerUI customerUI = new CustomerUI(inventory);
                        customerUI.setVisible(true);
                    }
                });
            }
        }
    }
}
