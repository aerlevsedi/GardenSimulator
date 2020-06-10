package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

/**
 * Defines how to evaluate impacts of
 * Weather and Animals for vegetables
 */
public class Vegetable extends Plants {
    public Vegetable() {
    }

    public void evalWeatherImpact(WeatherConditions weather) {

        double frost = -0.3 * weather.getFrost();
        double wind = -0.3 * weather.getWind();
        double sun = 2.2 * weather.getSun();
        double rain = 1.8 * weather.getRain();
        double temperature = 0.5 * weather.getTemperature();
        currentLife += (int) (frost + wind + sun + rain + temperature);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += (int)(1.1 * animal.getImpact());
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Vegetable[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
