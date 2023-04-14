public interface CustomerInventory extends Inventory {
    void updateStock(int productId, int newStock);
}
