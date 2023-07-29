public class Product {
    private final String name;
    private Float price;

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public void changePrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

}
