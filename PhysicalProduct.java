public class PhysicalProduct extends Product{
    private final Float weight;

    public PhysicalProduct(String name, Float price, Float weight) {
        super(name, price);
        this.weight = weight;
    }

    public Float getShippingWeight() {
        return weight;
    }
}
