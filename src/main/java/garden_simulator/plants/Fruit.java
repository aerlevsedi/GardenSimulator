package garden_simulator.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

public class Fruit extends Plants{
    public Fruit(Coordinates coors){
        super(coors);
    }

    public void evalWeatherImpact(WeatherConditions weather) {

        double frost = -1*weather.getFrost();
        double wind = -0.1*weather.getWind();
        double sun = 2*weather.getSun();
        double rain = 0.3*weather.getRain();

        currentLife += (int) (frost + wind + sun + rain);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        //TODO
        currentLife += animal.getImpact();
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Fruit[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + "); currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
