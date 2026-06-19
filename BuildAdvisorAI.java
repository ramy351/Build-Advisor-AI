import java.util.ArrayList;

public class BuildAdvisorAI {

    public void recommendBuild(double budget, String useCase, String brandPref, ArrayList<Component> inventory) {
        System.out.println("\n🤖 AI is analyzing inventory data for a full build...");

        if (budget < 100) {
            System.out.println("❌ AI Decision: Budget is too low. The absolute minimum for bare-bones parts is $100.");
            return;
        }

        Processor chosenCpu = null;
        GraphicsCard chosenGpu = null;
        RAM chosenRam = null;
        Motherboard chosenMobo = null;
        PSU chosenPsu = null;
        Storage chosenStorage = null;

        // Rule: Determine if we need a GPU
        boolean includeGpu = budget >= 400 && useCase.equalsIgnoreCase("gaming");

        double gpuMax = includeGpu ? budget * 0.40 : 0.0;
        double remainingBudget = budget - gpuMax;

        // Rule: Budget limits with a safe minimum floor to prevent math errors
        double cpuMax = Math.max(remainingBudget * 0.30, 35.0);
        double moboMax = Math.max(remainingBudget * 0.25, 40.0);
        double otherMax = Math.max(remainingBudget * 0.15, 15.0);

        // Step 1: Pick GPU, PSU, and Storage
        for (Component c : inventory) {
            if (includeGpu && c instanceof GraphicsCard && c.getPrice() <= gpuMax) {
                if (chosenGpu == null || c.getPrice() > chosenGpu.getPrice()) chosenGpu = (GraphicsCard) c;
            } else if (c instanceof PSU && c.getPrice() <= otherMax) {
                if (chosenPsu == null || c.getPrice() > chosenPsu.getPrice()) chosenPsu = (PSU) c;
            } else if (c instanceof Storage && c.getPrice() <= otherMax) {
                if (chosenStorage == null || c.getPrice() > chosenStorage.getPrice()) chosenStorage = (Storage) c;
            }
        }

        // Step 2: Pick CPU and Motherboard as a dependent combo
        double comboMax = cpuMax + moboMax;
        for (Component c1 : inventory) {
            if (c1 instanceof Processor) {
                Processor cpu = (Processor) c1;

                // Rule: Skip CPU if it doesn't match the user's brand preference
                if (!brandPref.equalsIgnoreCase("any") && !cpu.getBrand().equalsIgnoreCase(brandPref)) {
                    continue;
                }

                for (Component c2 : inventory) {
                    if (c2 instanceof Motherboard) {
                        Motherboard mobo = (Motherboard) c2;

                        double currentComboPrice = cpu.getPrice() + mobo.getPrice();
                        if (cpu.getSocketType().equals(mobo.getSocketType()) && currentComboPrice <= comboMax) {

                            double bestComboPrice = (chosenCpu != null && chosenMobo != null) ? (chosenCpu.getPrice() + chosenMobo.getPrice()) : 0.0;
                            if (chosenCpu == null || currentComboPrice > bestComboPrice) {
                                chosenCpu = cpu;
                                chosenMobo = mobo;
                            }
                        }
                    }
                }
            }
        }

        // Step 3: Pick RAM that perfectly matches the chosen Motherboard
        for (Component c : inventory) {
            if (c instanceof RAM && c.getPrice() <= otherMax) {
                RAM ram = (RAM) c;
                if (chosenMobo != null && ram.getType().equals(chosenMobo.getSupportedRam())) {
                    if (chosenRam == null || ram.getPrice() > chosenRam.getPrice()) {
                        chosenRam = ram;
                    }
                }
            }
        }

        // Output the intelligent decision
        if (chosenCpu != null && chosenRam != null && chosenPsu != null && chosenStorage != null && chosenMobo != null) {
            System.out.println("✅ AI Complete Build Recommendation for '" + useCase + "':");
            if (!includeGpu && useCase.equalsIgnoreCase("gaming")) {
                System.out.println("⚠️ Note: Budget too low for a dedicated GPU. Relying on integrated graphics.");
            }

            ArrayList<Component> finalBuild = new ArrayList<>();
            finalBuild.add(chosenCpu);
            if (chosenGpu != null) finalBuild.add(chosenGpu);
            finalBuild.add(chosenMobo);
            finalBuild.add(chosenRam);
            finalBuild.add(chosenStorage);
            finalBuild.add(chosenPsu);

            for (Component part : finalBuild) {
                part.displayInfo(); // polymorphic call based on actual subclass
            }

            double totalCost = chosenCpu.getPrice() + chosenRam.getPrice() + chosenPsu.getPrice() + chosenStorage.getPrice() + chosenMobo.getPrice();
            if (chosenGpu != null) totalCost += chosenGpu.getPrice();

            System.out.println("💰 Estimated Total: $" + totalCost);
        } else {
            System.out.println("❌ AI Decision: Not enough budget parts in inventory to complete a build at $" + budget);
        }
    }
}