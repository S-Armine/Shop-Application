import java.util.*;

public class Warehouse {
    private Map<Product, Integer> productCount;

    public Warehouse() {
        productCount = new HashMap<>();
    }
    public Warehouse(Map<Product, Integer> productCount) {
        this.productCount = productCount;
    }

    public Map<Product, Integer> getProducts() {
        return productCount;
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity == null) throw new NullPointerException();
        productCount.put(product, quantity);
    }

    public void removeProduct(Product product, Integer quantity) {
        int count = productCount.get(product);
        if (quantity < count) {
            productCount.replace(product, count - quantity);
        } else if (quantity == count) {
            productCount.remove(product);
        }
        else {
            throw new IllegalActionException("Not enough samples of " + product.getName());
        }
    }

    public Integer getProductQuantity(Product product) {
        return productCount.get(product);
    }
}