public class GraphicsCard extends Component {
    private int vram;

    public GraphicsCard(String name, double price, int vram) {
        super(name, price, "Graphics Card");
        this.vram = vram;
    }

    @Override
    public void displayInfo() {
        System.out.println("GPU: " + getName() + " | VRAM: " + vram + "GB | Price: $" + getPrice());
    }
}