public class Storage extends Component {
    private int capacityGB;
    private String type;

    public Storage(String name, double price, int capacityGB, String type) {
        super(name, price, "Storage");
        this.capacityGB = capacityGB;
        this.type = type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Storage: " + getName() + " | " + capacityGB + "GB " + type + " | Price: $" + getPrice());
    }
}