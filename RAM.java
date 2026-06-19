public class RAM extends Component {
    private int capacityGB;
    private int speedMHz;
    private String type;

    public RAM(String name, double price, int capacityGB, int speedMHz, String type) {
        super(name, price, "RAM");
        this.capacityGB = capacityGB;
        this.speedMHz = speedMHz;
        this.type = type;
    }

    public String getType() { return type; }

    @Override
    public void displayInfo() {
        System.out.println("RAM: " + getName() + " | " + capacityGB + "GB " + type + " @ " + speedMHz + "MHz | Price: $" + getPrice());
    }
}