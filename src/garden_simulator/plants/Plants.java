package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.Coordinates;
import garden_simulator.WeatherConditions;

/*TODO: in fact Plants + subclasses should be in package*/
public abstract class Plants {
    protected Coordinates coordinates;
    protected int currentLife;
    protected int growthPhase;

    public Plants(int x, int y){
        coordinates = new Coordinates(x, y);
        currentLife = 50;
        growthPhase = 0;
    }

    public void evalWeatherImpact(WeatherConditions weather) {
        //to override, depends on class
    }

    public void evalAnimalImpact(Animal animal) {
        //to override, depends on class
    }

    public void updateGrowthPhase() {
        if(currentLife >= 100){
            growthPhase++;
        }
    }

    public boolean canReproduce(){
        return (growthPhase == 5 && currentLife == 100);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}