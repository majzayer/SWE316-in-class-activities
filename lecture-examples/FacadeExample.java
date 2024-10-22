class LightingSystem {
    public void turnOnLights() {
        System.out.println("Lights are now ON");
    }

    public void turnOffLights() {
        System.out.println("Lights are now OFF");
    }
}

class SecuritySystem {
    public void armSecurity() {
        System.out.println("Security system is ARMED");
    }

    public void disarmSecurity() {
        System.out.println("Security system is DISARMED");
    }
}

class ClimateControlSystem {
    public void setTemperature() {
        System.out.println("Temperature is set to 22°C");
    }
}

class EntertainmentSystem {
    public void turnOnTV() {
        System.out.println("Turning on the TV");
    }
}

class HomeAutomationFacade {
    private LightingSystem lighting;
    private SecuritySystem security;
    private ClimateControlSystem climateControl;
    private EntertainmentSystem entertainment;

    public HomeAutomationFacade() {
        lighting = new LightingSystem();
        security = new SecuritySystem();
        climateControl = new ClimateControlSystem();
        entertainment = new EntertainmentSystem();
    }

    public void activateMorningRoutine() {
        System.out.println("\nMorning Routine Activated ----");
        lighting.turnOffLights();
        security.disarmSecurity();
        climateControl.setTemperature();
    }

    public void activateNightRoutine() {
        System.out.println("\nNight Routine Activated ----");
        security.armSecurity();
        lighting.turnOnLights();
        entertainment.turnOnTV();
    }
}

public class MainApp {
    public static void main(String[] args) {
        HomeAutomationFacade homeFacade = new HomeAutomationFacade();

        homeFacade.activateMorningRoutine();
        homeFacade.activateNightRoutine();
    }
}
