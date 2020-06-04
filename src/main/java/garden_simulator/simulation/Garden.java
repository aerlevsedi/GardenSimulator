package garden_simulator.simulation;

import garden_simulator.simulation.animals.AnimalsPositions;
import garden_simulator.simulation.day.Season;
import garden_simulator.simulation.plants.PlantsPositions;
import garden_simulator.weather.WeatherConditions;

public class Garden {
    private final GardenProperties gardenProperties; //need it?

    private final PlantsPositions plantsPositions;
    private final AnimalsPositions animalsPositions;

    public WeatherConditions weatherConditions;

    public Garden(GardenProperties properties, PlantsPositions plantsPositions, AnimalsPositions animalsPositions, Season season) {
        gardenProperties = properties;
        this.plantsPositions = plantsPositions;
        this.animalsPositions = animalsPositions;
        weatherConditions = new WeatherConditions(season);
    }

    public void impact() {
        plantsPositions.animalImpact(animalsPositions);
        plantsPositions.weatherImpact(weatherConditions);
    }

    public void update(Season season) {

        plantsPositions.reproduce();
        plantsPositions.killPlants();
        animalsPositions.move();
        weatherConditions = new WeatherConditions(season);
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
        plantsPositions.countPlants();
    }
}
