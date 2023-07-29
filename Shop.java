import java.util.*;

public class Shop {
    private Map<Product, Integer> products;
    private Warehouse wareHouse;
    private int allowedPeriodToReturn;


    public Shop(Warehouse wareHouse, int allowedPeriodToReturn) {
        this.wareHouse = wareHouse;
        this.allowedPeriodToReturn = allowedPeriodToReturn;
        this.products = new HashMap<>();
    }

    public int getAllowedPeriodToReturn() {
        return allowedPeriodToReturn;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        wareHouse.removeProduct(product, quantity);
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + quantity);
        }
        else {
            products.put(product, quantity);
        }
    }

    public void returnToWarehouse(Product product, Integer quantity) {
        if (products.containsKey(product)) {
            if (quantity <= products.get(product)) {
                wareHouse.addProduct(product, quantity);
                return;
            }
        }
        throw new IllegalActionException("Shop does not have enough samples of" + product.getName());
    }

    public void removeProduct(Product product) {
        this.removeProduct(product, 1);
    }

    public void removeProduct(Product product, Integer quantity) {
        if (products.containsKey(product)) {
            int count = products.get(product);
            if (quantity <= count) {
                products.replace(product, count - quantity);
            } else if (quantity > count) {
                this.addProduct(product, quantity - count);
                products.replace(product, 0);
            }
        }
    }

    public Product getProduct(String name) {
        for (Product product : products.keySet()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

}
