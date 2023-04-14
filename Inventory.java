import java.util.List;

public interface Inventory {
    /**
     * Adds a new product to the inventory.
     *
     * @param product The product to add.
     */
    void addProduct(Product product);

    /**
     * Deletes a product from the inventory.
     *
     * @param productId The ID of the product to delete.
     */
    void deleteProduct(int productId);

    /**
     * Updates an existing product in the inventory.
     *
     * @param product The updated product.
     */
    void updateProduct(Product product);

    /**
     * Gets a product from the inventory.
     *
     * @param productId The ID of the product to get.
     * @return The product with the given ID, or null if the product does not exist.
     */
    Product getProduct(int productId);

    /**
     * Gets a list of all products in the inventory.
     *
     * @return A list of all products in the inventory.
     */
    List<Product> getAllProducts();
}
