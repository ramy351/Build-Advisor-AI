public class Motherboard extends Component {
    private String formFactor;
    private String socketType;
    private String supportedRam;

    public Motherboard(String name, double price, String formFactor, String socketType, String supportedRam) {
        super(name, price, "Motherboard");
        this.formFactor = formFactor;
        this.socketType = socketType;
        this.supportedRam = supportedRam;
    }

    public String getSocketType() { return socketType; }
    public String getSupportedRam() { return supportedRam; }

    @Override
    public void displayInfo() {
        System.out.println("Mobo: " + getName() + " | " + formFactor + " (" + socketType + ") | RAM Type: " + supportedRam + " | Price: $" + getPrice());
    }
}