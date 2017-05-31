package creditsuisse.shopping;

public class Item {
    private final String sku;
    private final double price;

    public Item(String sku, double price) {
        this.sku = sku;
        this.price = price;
    }

    public double getPrice() { return price; }

    public String getSku() {
        return sku;
    }
}
