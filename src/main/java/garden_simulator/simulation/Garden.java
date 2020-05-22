package garden_simulator.simulation;

import garden_simulator.WeatherConditions;

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
        weatherConditions.changeWeather();
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
        return plantsPositions.plantsArray.isEmpty();
    }

    public boolean isFull(){
        return (plantsPositions.plantsArray.size() == gardenProperties.getMaxPlantsNumber());
    }

}
