package garden_simulator.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

public class Flower extends Plants {
    public Flower(Coordinates coors) {
        super(coors);
    }

    public void evalWeatherImpact(WeatherConditions weather) {
        double frost = -0.8 * weather.getFrost();
        double wind = -0.2 * weather.getWind();
        double sun = 3 * weather.getSun();
        double rain = 0.3 * weather.getRain();

        currentLife += (int) (frost + wind + sun + rain);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Flower[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + "); currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
