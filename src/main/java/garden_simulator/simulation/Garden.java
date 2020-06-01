package garden_simulator.simulation;

import garden_simulator.weather.WeatherConditions;

public class Garden {
    private final GardenProperties gardenProperties; //need it?

    private final PlantsPositions plantsPositions;
    private final AnimalsPositions animalsPositions;

    public WeatherConditions weatherConditions;

    public Garden(GardenProperties properties, PlantsPositions plantsPositions) {
        gardenProperties = properties;
        this.plantsPositions = plantsPositions;
        animalsPositions = new AnimalsPositions(gardenProperties);
        weatherConditions = new WeatherConditions();
    }

    public void impact() {
        plantsPositions.animalImpact(animalsPositions);
        plantsPositions.weatherImpact(weatherConditions);
    }

    public void update() {
        plantsPositions.reproduce();
        plantsPositions.killPlants();
        animalsPositions.move();
        weatherConditions = new WeatherConditions();
        impact();
    }

    public void draw() {
        plantsPositions.draw();
    }

    public void listPlants() {
        plantsPositions.list();
    }

    public void listAnimals() {
        animalsPositions.list();
    }

    public boolean isEmpty() {
        return plantsPositions.isEmpty();
    }

    public boolean isFull() {
        return plantsPositions.isFull();
    }

    public void stats() {
        //TODO finish stats
        plantsPositions.countPlants();

    }
}
