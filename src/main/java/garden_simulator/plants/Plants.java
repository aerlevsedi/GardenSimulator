package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

/**
 * Keeps information about Plant,
 * its life and growth phase status and upgrades them.
 * Evaluates impacts of Weather and Animals
 */
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
    }

    public void evalAnimalImpact(Animal animal) {
        updateGrowthPhase();
    }

    public void updateGrowthPhase() {
        if (currentLife >= 70 && growthPhase < 5) {
            currentLife = 50;
            growthPhase++;
        }
    }

    public boolean shouldDie() {
        return ((growthPhase == 5 && currentLife >= 100) || currentLife <= 0);

    }

    public boolean canReproduce() {
        return (growthPhase == 5 && currentLife >= 70);
    }

}
