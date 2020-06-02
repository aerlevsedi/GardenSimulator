package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.coordinates.Coordinates;
import garden_simulator.weather.WeatherConditions;

public abstract class Plants {
    protected int currentLife;
    protected int growthPhase;

    public Plants() {
        currentLife = 50;
        growthPhase = 0;
    }


    public int getGrowthPhase() {
        return growthPhase;
    }

    public void evalWeatherImpact(WeatherConditions weather) {
        //to override, depends on class
    }

    public void evalAnimalImpact(Animal animal) {
        //to override, depends on class
        updateGrowthPhase();
    }

    public void updateGrowthPhase() {
        if (currentLife >= 70 && growthPhase < 5) {
            currentLife = 50;
            growthPhase++;
        }
        /*
        if(currentLife<50 && growthPhase>0) {
            growthPhase--;
            currentLife = 50;
        }
        */
    }

    public boolean shouldDie() {

        return ((growthPhase == 5 && currentLife >= 100) || currentLife <= 0);

    }

    public boolean canReproduce() {

        return (growthPhase == 5 && currentLife >= 70);
    }

}
