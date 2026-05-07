package ro.ase.csie.cts.facade.models;

public class SmartHomeFacade {
    private final SmartHeatingSystem heating = new SmartHeatingSystem();
    private final SmartSecuritySystem security = new SmartSecuritySystem();
    private final SmartLightsSystem lights = new SmartLightsSystem();

    public void leaveHome() {
        lights.turnOffAllLights();
        heating.setTemperature(18);
        security.arm();
    }

    public void comeHome() {
        security.disarm();
        heating.setTemperature(22);
        lights.turnOnAllLights();
    }
}
