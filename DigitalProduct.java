public class DigitalProduct extends Product{
    public final Float size;

    public DigitalProduct(String name, Float price, Float size) {
        super(name, price);
        this.size = size;
    }

    public Float getDownloadSize() {
        return size;
    }
}
