package three;

public class Products {
    private String name;
    private String producent;
    private double price;

    public Products(String name, String producent, double price) {
        this.name = name;
        this.producent = producent;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
