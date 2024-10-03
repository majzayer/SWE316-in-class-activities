interface VacationPackage {
    double calculateTotalCost();
}

class BeachHoliday implements VacationPackage {
    private double basePrice;

    public BeachHoliday(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = basePrice + 100; // Beach holiday surcharge
        totalCost -= basePrice * 0.10;      // Beach holiday discount
        if (isHighSeason()) {
            totalCost += 150;               // High season surcharge
        }
        return totalCost;
    }

    private boolean isHighSeason() {
        return true; // Simulate high season check
    }
}

class MountainTrek implements VacationPackage {
    private double basePrice;

    public MountainTrek(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = basePrice + 200; // Mountain trek surcharge
        totalCost -= basePrice * 0.05;      // Mountain trek discount
        if (isHighSeason()) {
            totalCost += 150;               // High season surcharge
        }
        return totalCost;
    }

    private boolean isHighSeason() {
        return true; // Simulate high season check
    }
}

class CityTour implements VacationPackage {
    private double basePrice;

    public CityTour(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = basePrice + 50;  // City tour surcharge
        totalCost -= basePrice * 0.15;      // City tour discount
        if (isHighSeason()) {
            totalCost += 150;               // High season surcharge
        }
        return totalCost;
    }

    private boolean isHighSeason() {
        return true; // Simulate high season check
    }
}

class VacationApp {
    
    // attribute declarations
    ...
    
    public void bookVacation(VacationPackage vacationPackage) {
        
        //some booking logic
        
        double totalCost = vacationPackage.calculateTotalCost();
        
        // some other booking logic
    }
}
