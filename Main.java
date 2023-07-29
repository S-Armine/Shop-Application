import java.util.*;

public class Main {
    public static void main(String[] args) {
        Warehouse wh = new Warehouse();
        Product pen = new PhysicalProduct("Pen", 200F, 0.1F);
        Product notebook = new PhysicalProduct("Notebook", 500F, 0.2F);
        wh.addProduct(pen,1000);
        wh.addProduct(notebook, 200);
        Product soap = new PhysicalProduct("Soap", 700F, 0.3F);
        Product napkin = new PhysicalProduct("Napkin", 300F, 0.05F);
        wh.addProduct(soap, 100);
        wh.addProduct(napkin, 600);
        Shop stationeryStore = new Shop(wh, 14);
        Shop superMarket = new Shop(wh, 7);
        stationeryStore.addProduct(pen, 500);
        //stationeryStore.addProduct(notebook,300);
        stationeryStore.addProduct(notebook,50);
        superMarket.addProduct(soap,50);
        superMarket.addProduct(napkin,500);
        superMarket.addProduct(pen,300);
        superMarket.addProduct(notebook,20);
        System.out.println("Currrent amount of items in warehouse.");
        for (Product product : wh.getProducts().keySet()) {
            System.out.println(product.getName() + ": "+ wh.getProducts().get(product));
        }
        System.out.println();
        Customer customer1 = new Customer(200_000F);
        customer1.getNewShoppingCart(stationeryStore);
        System.out.println("Currrent amount of items in stationary shop.");
        for (Product product : stationeryStore.getProducts().keySet()) {
            System.out.println(product.getName() + ": " + stationeryStore.getProducts().get(product));
        }
        System.out.println();
        //customer1.addProductToCart(soap);
        customer1.addProductToCart(pen);
        for (int i = 0; i < 80; i++) {
            customer1.addProductToCart(notebook);
        }
        customer1.viewShoppingCart();
        System.out.println();
        System.out.println("Current amount of items in warehouse.");
        for (Product product : wh.getProducts().keySet()) {
            System.out.println(product.getName() + ": " + wh.getProducts().get(product));
        }
        System.out.println();
        customer1.viewCurrentPrice();
        customer1.purchase();
        System.out.println("Currrent amount of items in stationary shop.");
        for (Product product : stationeryStore.getProducts().keySet()) {
            System.out.println(product.getName() + ": " + stationeryStore.getProducts().get(product));
        }
        System.out.println("Currrent amount of items in superMarket.");
        for (Product product : superMarket.getProducts().keySet()) {
            System.out.println(product.getName() + ": " + superMarket.getProducts().get(product));
        }
        System.out.println();
        customer1.getNewShoppingCart(superMarket);
        for (int i = 0; i < 12; i++) {
            customer1.addProductToCart(soap);
            customer1.addProductToCart(pen);
        }
        customer1.viewShoppingCart();
        customer1.purchase();
        System.out.println("Currrent amount of items in superMarket.");
        for (Product product : superMarket.getProducts().keySet()) {
            System.out.println(product.getName() + ": " + superMarket.getProducts().get(product));
        }
        System.out.println();
        customer1.returnProduct(notebook);
        System.out.println();
        System.out.println("Currrent amount of items in stationary shop.");
        for (Product product : stationeryStore.getProducts().keySet()) {
            System.out.println(product.getName() + ": " + stationeryStore.getProducts().get(product));
        }
        System.out.println();
        System.out.println(superMarket.getProduct("Napkin").getName());
        //System.out.println(superMarket.getProduct("Book").getName());

    }
}