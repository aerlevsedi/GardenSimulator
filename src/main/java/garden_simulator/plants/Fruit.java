package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

/**
 * Defines how to evaluate impacts of
 * Weather and Animals for fruits
 */
public class Fruit extends Plants {
    public Fruit() {
    }

    public void evalWeatherImpact(WeatherConditions weather) {

        double frost = -0.1 * weather.getFrost();
        double wind = -0.5 * weather.getWind();
        double sun = 2.2 * weather.getSun();
        double rain = 1.8 * weather.getRain();
        double storm =-0.15*weather.getStorm();
        double temperature = 0.5 * weather.getTemperature();
        currentLife += (int) (frost + wind + sun + rain + storm + temperature);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += (int)(1.1 * animal.getImpact());
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Fruit[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
