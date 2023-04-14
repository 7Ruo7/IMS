public class Product {
    private int id;
    private String name;
    private String brand;
    private String category;
    private String location;
    private int stock;

    public Product(int id, String name, String brand, String category, String location, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.location = location;
        this.stock = stock;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", stock=" + stock +
                '}';
    }
}
