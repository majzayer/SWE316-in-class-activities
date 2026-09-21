class VacationApp {
    private String packageName;
    private double basePrice;
    
    public VacationApp(String packageName, double basePrice) {
        this.packageName = packageName;
        this.basePrice = basePrice;
    }
    
    public double calculateTotalCost(String packageType) {
        double totalCost = basePrice;
        
        // Adding package-specific surcharges
        if (packageType.equals("BeachHoliday")) {
            totalCost += 100; // Additional charge for beach holidays
        } else if (packageType.equals("MountainTrek")) {
            totalCost += 200; // Additional charge for mountain treks
        } else if (packageType.equals("CityTour")) {
            totalCost += 50;  // Additional charge for city tours
        }
        
        // Adding package-specific discounts
        if (packageType.equals("BeachHoliday")) {
            totalCost -= basePrice * 0.10; // 10% discount for beach holidays
        } else if (packageType.equals("MountainTrek")) {
            totalCost -= basePrice * 0.05; // 5% discount for mountain treks
        } else if (packageType.equals("CityTour")) {
            totalCost -= basePrice * 0.15; // 15% discount for city tours
        }
        
        // Applying special seasonal surcharge
        if (isHighSeason()) {
            totalCost += 150; // Flat surcharge for high season
        }
        
        return totalCost;
    }
    
    private boolean isHighSeason() {
        // Simulate a check for high season (this could be based on dates)
        return true; // Assume it's always high season for simplicity
    }
}
