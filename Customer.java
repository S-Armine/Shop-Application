import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Customer {
    private ShoppingCart shoppingCart;
    private Map<Product, DateAndQuantity> purchasedProducts = new HashMap<>();
    private Float money;

    public Customer(Float money) {
        this.money = money;
    }

    public ShoppingCart getNewShoppingCart(Shop shop) {
        shoppingCart = new ShoppingCart(shop);
        return shoppingCart;
    }

    public void addProductToCart(Product product) {
        shoppingCart.addProduct(product);
    }

    public void removeProductFromCart(Product product) {
        shoppingCart.removeProduct(product);
    }

    public void purchase() {
        Float totalPrice = shoppingCart.getTotalPrice();
        if (money < totalPrice) {
            throw new IllegalActionException("Not enough money to buy products.");
        }
        else {
            money -= totalPrice;
            System.out.println("Congrats, you have purchased new items!!!");
            for (Product product : shoppingCart.getProducts().keySet()) {
                purchasedProducts.put(product, new DateAndQuantity(shoppingCart.getProducts().get(product), shoppingCart.getShop()));
            }
        }
        shoppingCart = null;
    }

    public void viewCurrentPrice() {
        System.out.println("Current amount is: " + shoppingCart.getTotalPrice());
    }

    public void viewShoppingCart() {
        System.out.println("Items in shoppingcart are");
        for (Product product : shoppingCart.getProducts().keySet()) {
            System.out.println(product.getName() + ": price: " + product.getPrice() + ", quantity: " + shoppingCart.getProducts().get(product));
        }
    }
    public void returnProduct(Product product) {
        if (purchasedProducts.containsKey(product)) {
            Shop shop = purchasedProducts.get(product).shop;
            if(ChronoUnit.DAYS.between(LocalDate.now(), purchasedProducts.get(product).purchasedDate) <= shop.getAllowedPeriodToReturn()) {
                shop.addProduct(product, purchasedProducts.get(product).quantity);
                money += product.getPrice() * purchasedProducts.get(product).quantity * 0.9F;
                purchasedProducts.remove(product);
                return;
            }
        }
        throw new IllegalActionException("You can not return " + product.getName());
    }

    private class DateAndQuantity {
        private LocalDate purchasedDate;
        private int quantity;
        private Shop shop;

        public DateAndQuantity(int quantity, Shop shop) {
            this.purchasedDate = LocalDate.now();
            this.quantity = quantity;
            this.shop = shop;
        }
    }
}

