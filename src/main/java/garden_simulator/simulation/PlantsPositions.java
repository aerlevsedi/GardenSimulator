package garden_simulator.simulation;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.weather.WeatherConditions;
import garden_simulator.animals.Animal;
import garden_simulator.plants.Flower;
import garden_simulator.plants.Fruit;
import garden_simulator.plants.Plants;
import garden_simulator.plants.Vegetable;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class PlantsPositions {
    private final GardenProperties gardenProperties;

    private final Map<Coordinates, Plants> plantsByCoordinates;
    private final Random randomGenerator = new Random();

    public PlantsPositions(GardenProperties gardenProperties, Map<Coordinates, Plants> plantsByCoordinates) {
        this.gardenProperties = gardenProperties;
        this.plantsByCoordinates = plantsByCoordinates;
    }

    public void animalImpact(AnimalsPositions animalsPositions) {

        for (Animal animal : animalsPositions.animalsArray) {
            int X = animal.getCoordinates().getX();
            int Y = animal.getCoordinates().getY();

            boolean isAnimalInGarden = (X >= 0 && X < gardenProperties.getGardenWidth() && Y >= 0 && Y < gardenProperties.getGardenHeight());
            if (isAnimalInGarden) {
                Coordinates coors = new Coordinates(X, Y);
                if(plantsByCoordinates.containsKey(coors)){
                    plantsByCoordinates.get(coors).evalAnimalImpact(animal);
                }
            }
        }
    }

    public void weatherImpact(WeatherConditions weatherConditions) {

        for (Plants plant : plantsByCoordinates.values()) {
            plant.evalWeatherImpact(weatherConditions);
        }

    }

    public void killPlants() {

        for (int i = 0; i < gardenProperties.getGardenHeight(); i++) {
            for (int j = 0; j < gardenProperties.getGardenWidth(); j++) {

                boolean shouldDie;
                Coordinates coors = new Coordinates(j, i);

                if (plantsByCoordinates.containsKey(coors)) {
                    shouldDie = plantsByCoordinates.get(coors).shouldDie();

                    if (shouldDie) {
                        plantsByCoordinates.remove(coors);
                    }
                }
            }
        }
    }

    public void reproduce() {

        //TODO plants dying after they reproduce
        for (int i = 0; i < gardenProperties.getGardenHeight(); i++) {
            for (int j = 0; j < gardenProperties.getGardenWidth(); j++) {

                if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                    break;

                Coordinates coors = new Coordinates(j, i);

                if (plantsByCoordinates.containsKey(coors)) {

                    boolean canReproduce = plantsByCoordinates.get(coors).canReproduce();

                    if (canReproduce) {
                        //TODO put this into functions
                        Plants reproducingPlant = plantsByCoordinates.get(coors);

                        for (int m = j - 1; m >= 0; m--) {

                            if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            Coordinates newCoors = new Coordinates(m, i);
                            boolean isPlaceAvailable = (!plantsByCoordinates.containsKey(newCoors));

                            if (isPlaceAvailable) {

                                if (reproducingPlant instanceof Flower) {
                                    Plants plant = new Flower();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Vegetable) {
                                    Plants plant = new Vegetable();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Fruit) {
                                    Plants plant = new Fruit();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                            }
                        }

                        for (int m = j + 1; m <= gardenProperties.getGardenWidth() - 1; m++) {

                            if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            Coordinates newCoors = new Coordinates(m, i);
                            boolean isPlaceAvailable = (!plantsByCoordinates.containsKey(newCoors));

                            if (isPlaceAvailable) {

                                if (reproducingPlant instanceof Flower) {
                                    Plants plant = new Flower();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Vegetable) {
                                    Plants plant = new Vegetable();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Fruit) {
                                    Plants plant = new Fruit();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                            }

                        }

                        for (int m = i - 1; m >= 0; m--) {

                            if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            Coordinates newCoors = new Coordinates(j, m);
                            boolean isPlaceAvailable = (!plantsByCoordinates.containsKey(newCoors));

                            if (isPlaceAvailable) {

                                if (reproducingPlant instanceof Flower) {
                                    Plants plant = new Flower();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Vegetable) {
                                    Plants plant = new Vegetable();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Fruit) {
                                    Plants plant = new Fruit();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                            }

                        }

                        for (int m = i + 1; m <= gardenProperties.getGardenHeight() - 1; m++) {

                            if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            Coordinates newCoors = new Coordinates(j, m);
                            boolean isPlaceAvailable = (!plantsByCoordinates.containsKey(newCoors));

                            if (isPlaceAvailable) {

                                if (reproducingPlant instanceof Flower) {
                                    Plants plant = new Flower();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Vegetable) {
                                    Plants plant = new Vegetable();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                                if (reproducingPlant instanceof Fruit) {
                                    Plants plant = new Fruit();
                                    plantsByCoordinates.put(coors, plant);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int getPlantsNumber() {
        return plantsByCoordinates.size();
    }

    public boolean isEmpty() {
        return plantsByCoordinates.isEmpty();
    }

    public boolean isFull() {
        return (plantsByCoordinates.size() == gardenProperties.getMaxPlantsNumber());
    }

    public void draw() {
        //TODO colors?
        int gardenHeight = gardenProperties.getGardenHeight();
        int gardenWidth = gardenProperties.getGardenWidth();

        System.out.println("\nplantsGarden drawing:");
        for (int i = 0; i < gardenHeight; i++) {
            for (int j = 0; j < gardenWidth; j++) {

                Coordinates coors = new Coordinates(j, i);
                if (!plantsByCoordinates.containsKey(coors)) {
                    //System.out.print("O");
                    System.out.print("(X,Y)");
                } else {
                    System.out.print(coors.toString());
                }
            }
            System.out.println();
        }
    }

    public void list() {
        int gardenHeight = gardenProperties.getGardenHeight();
        int gardenWidth = gardenProperties.getGardenWidth();

        System.out.println("\nplantsArray:");
        for (Plants item : plantsByCoordinates.values()) {
            System.out.println(item.toString());
        }

        System.out.println("\nplantsGarden:");
        for (int i = 0; i < gardenHeight; i++) {
            for (int j = 0; j < gardenWidth; j++) {
                try {
                    System.out.println(plantsByCoordinates.get(new Coordinates(j, i)).toString());
                } catch (NullPointerException e) {
                    System.out.println("none");
                }
            }
        }
    }
}
