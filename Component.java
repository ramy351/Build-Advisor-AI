public abstract class Component {
    private String name;
    private double price;
    private String category;

    public Component() {
        this("Unknown", 0.0, "Unknown");
    }

    public Component(String name, double price) {
        this(name, price, "Unknown");
    }

    public Component(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public abstract void displayInfo();
}