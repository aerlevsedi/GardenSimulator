package garden_simulator;

public abstract class Plant {
    protected Coordinates coordinates;
    protected int currentLife;
    protected int growthPhase;

    public void evalWeatherImpact(WeatherConditions weather) {
        
    };

    public void evalAnimalImpact(Animal animal) {

    };

    public void updateGrowthPhase() {

    };

    public boolean canReproduce(){
        return true;
    };

    public Coordinates getCoordinates() {
        return coordinates;
    }
}

