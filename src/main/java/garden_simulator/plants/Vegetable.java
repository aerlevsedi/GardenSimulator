package garden_simulator.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

public class Vegetable extends Plants {
    public Vegetable() {
    }

    public void evalWeatherImpact(WeatherConditions weather) {

        double frost = -1 * weather.getFrost();
        double wind = -0.2 * weather.getWind();
        double sun = 1 * weather.getSun();
        double rain = 0.2 * weather.getRain();

        currentLife += (int) (frost + wind + sun + rain);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Vegetable[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
