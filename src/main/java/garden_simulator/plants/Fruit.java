package garden_simulator.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

public class Fruit extends Plants {
    public Fruit() {
    }

    public void evalWeatherImpact(WeatherConditions weather) {

        double frost = -0.1 * weather.getFrost();
        double wind = -0.3 * weather.getWind();
        double sun = 2.2 * weather.getSun();
        double rain = 2.0 * weather.getRain();
        double temperature = 0.3 * weather.getTemperature();
        currentLife += (int) (frost + wind + sun + rain + temperature);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Fruit[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
