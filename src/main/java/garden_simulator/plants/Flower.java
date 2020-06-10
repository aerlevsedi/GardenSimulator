package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

/**
 * Defines how to evaluate impacts of
 * Weather and Animals for flowers
 */
public class Flower extends Plants {
    public Flower() {
    }

    public void evalWeatherImpact(WeatherConditions weather) {

        double frost = -0.2 * weather.getFrost();
        double wind = -0.4 * weather.getWind();
        double sun = 2.5 * weather.getSun();
        double rain = 1.5 * weather.getRain();
        double temperature = 0.5 * weather.getTemperature();
        currentLife += (int) (frost + wind + sun + rain + temperature);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Flower[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
