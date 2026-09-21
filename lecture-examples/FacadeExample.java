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
    public void setTemperature(int temp) {
        System.out.println("Temperature is set to " + temp + "°C");
    }
}

class EntertainmentSystem {
    public void playMusic() {
        System.out.println("Playing music in the living room");
    }
}

class HomeAutomationFacade {
    private static final int MORNING_TEMP = 22;
    private static final int NIGHT_TEMP = 20;

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
        climateControl.setTemperature(MORNING_TEMP);
    }

    public void activateNightRoutine() {
        System.out.println("\nNight Routine Activated ----");
        security.armSecurity();
        lighting.turnOnLights();
        climateControl.setTemperature(NIGHT_TEMP);
        entertainment.playMusic();
    }
}

public class MainApp {
    public static void main(String[] args) {
        HomeAutomationFacade homeFacade = new HomeAutomationFacade();

        homeFacade.activateMorningRoutine();
        homeFacade.activateNightRoutine();
    }
}
