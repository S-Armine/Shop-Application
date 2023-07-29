import java.util.*;

public class ShoppingCart {
    private Map<Product, Integer> products = new HashMap<>();
    private Shop shop;

    public ShoppingCart(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        }
        else {
            products.put(product, 1);
        }
        shop.removeProduct(product);
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            int count = products.get(product);
            if (count > 1) {
                products.replace(product, count--);
            } else {
                products.remove(product);
            }
            shop.addProduct(product);
        }
        else {
            System.out.println("Shopping cart does not contain " + product.getName());
        }
    }

    public Float getTotalPrice() {
        Float sum = 0F;
        for (Product product: products.keySet()) {
            sum += product.getPrice() * products.get(product);
        }
        return sum;
    }

}
