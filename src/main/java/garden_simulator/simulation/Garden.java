package garden_simulator.simulation;

import garden_simulator.weather.WeatherConditions;

public class Garden {
    private GardenProperties gardenProperties;

    public PlantsPositions plantsPositions;
    public AnimalsPositions animalsPositions;

    public WeatherConditions weatherConditions;

    public Garden(GardenProperties properties){
        gardenProperties = properties;
        plantsPositions = new PlantsPositions(gardenProperties);
        animalsPositions = new AnimalsPositions(gardenProperties);
        weatherConditions = new WeatherConditions();
    }

    public void impact(){
        plantsPositions.animalImpact(animalsPositions);
        plantsPositions.weatherImpact(weatherConditions);
    }

    public void update(){
        plantsPositions.killPlants();
        plantsPositions.reproduce();
        animalsPositions.move();
        weatherConditions = new WeatherConditions();
        impact();
    }


    public void draw(){
        plantsPositions.draw();
    }

    public void listPlants(){
        plantsPositions.list();
    }

    public void listAnimals(){
        animalsPositions.list();
    }

    public boolean isEmpty(){
        return plantsPositions.isEmpty();
    }

    public boolean isFull(){
        return plantsPositions.isFull();
    }

    public void stats() {
        //TODO nice stats with number of plants, number of plants in each phase, max, etc
    }
}
