import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Component> inventory = new ArrayList<>();
        BuildAdvisorAI ai = new BuildAdvisorAI();

        // CPUs
        inventory.add(new Processor("AMD Ryzen 9 9750X3D", 450.0, 12, "AM5", "AMD"));
        inventory.add(new Processor("AMD Ryzen 7 7800X3D", 400.0, 8, "AM5", "AMD"));
        inventory.add(new Processor("AMD Ryzen 7 5800X", 250.0, 8, "AM4", "AMD"));
        inventory.add(new Processor("AMD Ryzen 5 7600X", 220.0, 6, "AM5", "AMD"));
        inventory.add(new Processor("AMD Ryzen 5 5600X", 150.0, 6, "AM4", "AMD"));
        inventory.add(new Processor("AMD Ryzen 3 3600", 75.0, 4, "AM4", "AMD"));
        inventory.add(new Processor("AMD Athlon 3000G", 50.0, 2, "AM4", "AMD"));
        inventory.add(new Processor("Intel Core i9", 550.0, 24, "LGA1700", "Intel"));
        inventory.add(new Processor("Intel Core i7", 400.0, 16, "LGA1700", "Intel"));
        inventory.add(new Processor("Intel Core i5-12400F", 150.0, 6, "LGA1700", "Intel"));
        inventory.add(new Processor("Intel Core i5-10400F", 110.0, 6, "LGA1200", "Intel"));
        inventory.add(new Processor("Intel Core i3-12400F", 70.0, 4, "LGA1700", "Intel"));
        inventory.add(new Processor("Intel Core i3-10400F", 45.0, 4, "LGA1200", "Intel"));
        inventory.add(new Processor("Intel Celeron G5905", 35.0, 2, "LGA1200", "Intel"));

        // GPUs
        inventory.add(new GraphicsCard("NVIDIA RTX 5090", 4000, 24));
        inventory.add(new GraphicsCard("AMD RX 7900 XTX", 900.0, 24));
        inventory.add(new GraphicsCard("NVIDIA RTX 4080 ", 800.0, 16));
        inventory.add(new GraphicsCard("NVIDIA RTX 5070 ", 700.0, 12));
        inventory.add(new GraphicsCard("NVIDIA RTX 5060 ", 600.0, 8));
        inventory.add(new GraphicsCard("NVIDIA RTX 3060ti ", 500.0, 8));
        inventory.add(new GraphicsCard("NVIDIA RTX 4060", 450.0, 8));
        inventory.add(new GraphicsCard("NVIDIA RTX 3060 ", 400.0, 12));
        inventory.add(new GraphicsCard("NVIDIA RTX 3060 ", 300.0, 6));
        inventory.add(new GraphicsCard("NVIDIA RTX 2060 Super", 250.0, 8));
        inventory.add(new GraphicsCard("NVIDIA RTX 2060 ", 200.0, 6));
        inventory.add(new GraphicsCard("NVIDIA GTX 1650", 150.0, 4));

        // RAM
        inventory.add(new RAM("Corsair Vengeance", 80.0, 32, 6000, "DDR5"));
        inventory.add(new RAM("Corsair Vengeance", 50.0, 16, 6000, "DDR5"));
        inventory.add(new RAM("Corsair Vengeance", 40.0, 8, 6000, "DDR5"));
        inventory.add(new RAM("Crucial Basics", 50.0, 32, 3200, "DDR4"));
        inventory.add(new RAM("Crucial Basics", 35.0, 16, 3200, "DDR4"));
        inventory.add(new RAM("Crucial Basics", 25.0, 8, 3200, "DDR4"));
        inventory.add(new RAM("Crucial Basics 8GB", 15.0, 8, 2666, "DDR4"));

        // Motherboards
        inventory.add(new Motherboard("MSI B650 Tomahawk", 180.0, "ATX", "AM5", "DDR5"));
        inventory.add(new Motherboard("Gigabyte A520M", 75.0, "Micro-ATX", "AM4", "DDR4"));
        inventory.add(new Motherboard("ASUS Prime H610M", 85.0, "Micro-ATX", "LGA1700", "DDR4"));
        inventory.add(new Motherboard("ASRock H410M", 40.0, "Micro-ATX", "LGA1200", "DDR4"));
        inventory.add(new Motherboard("ASUS ROG Strix Z790", 300.0, "ATX", "LGA1700", "DDR5"));

        // Storage
        inventory.add(new Storage("Samsung 990 Pro", 130.0, 2000, "NVMe SSD"));
        inventory.add(new Storage("WD Blue", 50.0, 1000, "SATA SSD"));
        inventory.add(new Storage("WD Green 240GB", 18.0, 240, "SATA SSD"));

        // PSUs
        inventory.add(new PSU("Corsair RM850x", 120.0, 850, "80+ Gold"));
        inventory.add(new PSU("EVGA 500 W1", 45.0, 500, "80+ White"));
        inventory.add(new PSU("Thermaltake Smart 430W", 25.0, 430, "80+ White"));


        System.out.println("🖥️ Welcome to the Custom PC Builder!");
        System.out.print("Enter your total budget ($): ");
        double budget = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("What is your main use case? (Type 'gaming' or 'office'): ");
        String useCase = scanner.nextLine();

        System.out.print("Do you prefer AMD or Intel? (Type 'AMD', 'Intel', or 'Any'): ");
        String brandPref = scanner.nextLine();

        ai.recommendBuild(budget, useCase, brandPref, inventory);

        scanner.close();
    }
}