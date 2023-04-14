import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
    private static InventoryImpl instance;
    private List<Product> products;

    private InventoryImpl() {
        products = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of the InventoryImpl class.
     */
    public static synchronized InventoryImpl getInstance() {
        if (instance == null) {
            instance = new InventoryImpl();
        }

        return instance;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        // Find the product with the same ID as the updated product
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                // Update the product
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int productId) {
        // Find the product with the specified ID
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                // Remove the product from the list
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public Product getProduct(int productId) {
        // Find the product with the specified ID
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
