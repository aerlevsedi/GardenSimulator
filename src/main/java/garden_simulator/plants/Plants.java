package garden_simulator.plants;

import garden_simulator.animals.Animal;
import garden_simulator.Coordinates;
import garden_simulator.WeatherConditions;

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
        updateGrowthPhase();
    }

    public void updateGrowthPhase() {
        if(currentLife >= 70 && growthPhase<5 ){
            currentLife = 50;
            growthPhase++;
        }
        if(currentLife<50 && growthPhase>0) {
            growthPhase--;
            currentLife = 50;
        }


    }
    //TODO Removing an object
    /*
    public boolean shouldDie() {

        boolean t=false;
        if(growthPhase==0 && currentLife<50)
            t=true;

        return t;

    }
    */

    public boolean canReproduce(){

        boolean t=false;
        if(growthPhase == 5 && currentLife >= 70)
                t=true;

        return t;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}