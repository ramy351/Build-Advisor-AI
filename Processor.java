public class Processor extends Component {
    private int cores;
    private String socketType;
    private String brand;

    public Processor(String name, double price, int cores, String socketType, String brand) {
        super(name, price, "CPU");
        this.cores = cores;
        this.socketType = socketType;
        this.brand = brand;
    }

    public String getSocketType() { return socketType; }
    public String getBrand() { return brand; }

    @Override
    public void displayInfo() {
        System.out.println("CPU: " + getName() + " | " + brand + " | Cores: " + cores + " (" + socketType + ") | Price: $" + getPrice());
    }
}