package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.WeatherConditions;

public class Flower extends Plants {
    public Flower(int coorX, int coorY){
        super(coorX, coorY);
    };

    public void evalWeatherImpact(WeatherConditions weather) {
        double frost = -0.6*weather.getFrost();
        double wind = -0.2*weather.getWind();
        double sun = 0.8*weather.getSun();
        double rain = 0.6*weather.getRain();

        currentLife += (int) (frost + wind + sun + rain);
    }


    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
    }

    @Override
    public String toString() {
        return "Flower[ coors: (" + coordinates.X + ", " + coordinates.Y + "); currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
