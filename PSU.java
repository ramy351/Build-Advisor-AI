public class PSU extends Component {
    private int wattage;
    private String efficiencyRating;

    public PSU(String name, double price, int wattage, String efficiencyRating) {
        super(name, price, "Power Supply");
        this.wattage = wattage;
        this.efficiencyRating = efficiencyRating;
    }

    @Override
    public void displayInfo() {
        System.out.println("PSU: " + getName() + " | " + wattage + "W (" + efficiencyRating + ") | Price: $" + getPrice());
    }
}