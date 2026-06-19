# 🖥️ BuildAdvisorAI — Custom PC Builder

A Java console application that uses an AI advisor system to recommend optimized PC builds based on your **budget**, **use case**, and **brand preference**. Built with core Object-Oriented Programming principles including inheritance, polymorphism, and abstraction.

---

## ✨ Features

- 🤖 **AI Build Advisor** — Intelligently selects compatible components from a live inventory
- 💰 **Budget-Aware** — Automatically allocates spending across CPU, GPU, RAM, Motherboard, Storage, and PSU
- 🎮 **Use Case Optimization** — Gaming builds prioritize GPU; office builds focus on CPU and efficiency
- 🔌 **Compatibility Checking** — Ensures CPU socket and motherboard socket match, and RAM type is supported
- 🏷️ **Brand Preference** — Filter CPUs by AMD or Intel (or go with Any)
- 📦 **Real Inventory** — 30+ real-world parts pre-loaded including latest AMD Ryzen and Intel Core lineups
- 🧱 **OOP Architecture** — Abstract base class with 6 specialized component subclasses

---

## 🗂️ Project Structure

```
BuildAdvisorAI/
│
├── Main.java               # Entry point — inventory setup & user input
├── BuildAdvisorAI.java     # Core recommendation engine / AI logic
├── Component.java          # Abstract base class for all parts
├── Processor.java          # CPU subclass (socket, brand, cores)
├── GraphicsCard.java       # GPU subclass (VRAM)
├── Motherboard.java        # Motherboard subclass (socket, RAM type, form factor)
├── RAM.java                # RAM subclass (capacity, speed, DDR type)
├── Storage.java            # Storage subclass (capacity, NVMe/SATA)
└── PSU.java                # PSU subclass (wattage, efficiency rating)
```

---

## 🧠 How the AI Advisor Works

The `BuildAdvisorAI` class follows a multi-step decision engine:

1. **Budget Allocation** — Splits the budget proportionally across component categories
2. **GPU Decision** — Only includes a dedicated GPU for gaming builds with budget ≥ $400
3. **CPU + Motherboard Combo** — Finds the best compatible CPU/Mobo pair by socket type within budget
4. **Brand Filtering** — Skips CPUs that don't match the user's AMD/Intel preference
5. **RAM Matching** — Picks RAM that matches the selected motherboard's supported DDR type
6. **PSU & Storage** — Fills remaining budget slots with the best available options
7. **Validation** — Only outputs a build if all 5 required components are found

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line



### Example Interaction

```
🖥️ Welcome to the Custom PC Builder!
Enter your total budget ($): 800
What is your main use case? (Type 'gaming' or 'office'): gaming
Do you prefer AMD or Intel? (Type 'AMD', 'Intel', or 'Any'): AMD

🤖 AI is analyzing inventory data for a full build...
✅ AI Complete Build Recommendation for 'gaming':
CPU: AMD Ryzen 5 5600X | AMD | Cores: 6 (AM4) | Price: $150.0
GPU: NVIDIA RTX 2060 Super | VRAM: 8GB | Price: $250.0
Mobo: Gigabyte A520M | Micro-ATX (AM4) | RAM Type: DDR4 | Price: $75.0
RAM: Crucial Basics | 32GB DDR4 @ 3200MHz | Price: $50.0
Storage: WD Blue | 1000GB SATA SSD | Price: $50.0
PSU: EVGA 500 W1 | 500W (80+ White) | Price: $45.0
💰 Estimated Total: $620.0
```

---

## 🏗️ OOP Design

| Concept | Implementation |
|---|---|
| **Abstraction** | `Component` is an abstract class with `displayInfo()` as an abstract method |
| **Inheritance** | All 6 parts extend `Component` and inherit `name`, `price`, and `category` |
| **Polymorphism** | `displayInfo()` is overridden in each subclass and called polymorphically |
| **Encapsulation** | All fields are `private` with public getters/setters |
| **instanceof** | Used in `BuildAdvisorAI` to safely cast and filter component types |

---

## 📋 Inventory Snapshot

| Category | Count | Price Range |
|---|---|---|
| Processors (CPU) | 14 | $35 – $550 |
| Graphics Cards (GPU) | 12 | $150 – $4,000 |
| RAM | 7 | $15 – $80 |
| Motherboards | 5 | $40 – $300 |
| Storage | 3 | $18 – $130 |
| PSU | 3 | $25 – $120 |

---

## 🛠️ Possible Improvements

- [ ] Add cooling (CPU cooler, case fans) as a component type
- [ ] Export recommended build to a `.txt` or `.pdf` file
- [ ] Add a manual part-picker mode alongside the AI advisor
- [ ] Implement a GUI using JavaFX or Swing
- [ ] Add PCIe generation compatibility checks between GPU and Motherboard



---

> Built as a Java OOP learning project demonstrating real-world design patterns with a practical use case.
