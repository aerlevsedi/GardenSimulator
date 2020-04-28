package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.WeatherConditions;

public class Vegetable extends Plants{
    public Vegetable(int coorX, int coorY){
        super(coorX, coorY);
    }

    public void evalWeatherImpact(WeatherConditions weather) {
        //TODO
    }

    public void evalAnimalImpact(Animal animal) {
        //TODO
    }

    @Override
    public String toString() {
        return "Vegetable[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + "); currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
