package garden_simulator.simulation;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.weather.WeatherConditions;
import garden_simulator.animals.Animal;
import garden_simulator.plants.Flower;
import garden_simulator.plants.Fruit;
import garden_simulator.plants.Plants;
import garden_simulator.plants.Vegetable;

import java.util.Map;
import java.util.Random;

public class PlantsPositions {
    private final GardenProperties gardenProperties;

    private final Map<Coordinates, Plants> plantsByCoordinates;
    private final Random randomGenerator = new Random();

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public PlantsPositions(GardenProperties gardenProperties, Map<Coordinates, Plants> plantsByCoordinates) {
        this.gardenProperties = gardenProperties;
        this.plantsByCoordinates = plantsByCoordinates;
    }

    public void animalImpact(AnimalsPositions animalsPositions) {
        for (int i=0; i<animalsPositions.animalsNumber; i++){
            AnimalLocation animalLocation = animalsPositions.getAnimalLocation(i);
            Animal animal = animalLocation.getAnimal();
            Coordinates coordinates = animalLocation.getCoors();

            int X = coordinates.getX();
            int Y = coordinates.getY();

            boolean isAnimalInGarden = animalsPositions.isAnimalInGarden(coordinates);

            if (isAnimalInGarden) {
                if (plantsByCoordinates.containsKey(coordinates)) {
                    plantsByCoordinates.get(coordinates).evalAnimalImpact(animal);
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

        for (int i = 0; i < gardenProperties.getGardenHeight(); i++) {
            for (int j = 0; j < gardenProperties.getGardenWidth(); j++) {

                if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                    break;

                Coordinates coors = new Coordinates(j, i);

                if (plantsByCoordinates.containsKey(coors)) {

                    boolean canReproduce = plantsByCoordinates.get(coors).canReproduce();

                    if (canReproduce) {

                        Plants reproducingPlant = plantsByCoordinates.get(coors);
                        if (plantsByCoordinates.size() >= gardenProperties.getMaxPlantsNumber())
                            break;

                        for (int m = j - 1; m >= 0; m--) {

                            Coordinates newCoors = new Coordinates(m, i);
                            if (reproductionCheck(reproducingPlant, newCoors)) ;
                            break;

                        }

                        for (int m = j + 1; m <= gardenProperties.getGardenWidth() - 1; m++) {

                            Coordinates newCoors = new Coordinates(m, i);
                            if (reproductionCheck(reproducingPlant, newCoors)) ;
                            break;
                        }

                        for (int m = i - 1; m >= 0; m--) {
                            Coordinates newCoors = new Coordinates(j, m);
                            if (reproductionCheck(reproducingPlant, newCoors)) ;
                            break;
                        }

                        for (int m = i + 1; m <= gardenProperties.getGardenHeight() - 1; m++) {

                            Coordinates newCoors = new Coordinates(j, m);
                            if (reproductionCheck(reproducingPlant, newCoors)) ;
                            break;

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

                    Plants item = plantsByCoordinates.get(coors);
                    if (item instanceof Fruit) {
                        System.out.print(ANSI_BLUE + coors.toString() + ANSI_RESET);
                    } else {
                        if (item instanceof Vegetable) {
                            System.out.print(ANSI_PURPLE + coors.toString() + ANSI_RESET);
                        } else if (item instanceof Flower)
                            System.out.print(ANSI_YELLOW + coors.toString() + ANSI_RESET);
                    }
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
    }

    public boolean reproductionCheck(Plants reproducingPlant, Coordinates newCoors) {
        boolean isPlaceAvailable = (!plantsByCoordinates.containsKey(newCoors));

        if (isPlaceAvailable) {
            if (reproducingPlant instanceof Flower) {
                Plants plant = new Flower();
                plantsByCoordinates.put(newCoors, plant);

                return true;

            } else {
                if (reproducingPlant instanceof Vegetable) {
                    Plants plant = new Vegetable();
                    plantsByCoordinates.put(newCoors, plant);
                    return true;

                } else {
                    if (reproducingPlant instanceof Fruit) {
                        Plants plant = new Fruit();
                        plantsByCoordinates.put(newCoors, plant);
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public void countPlants() {
        int countFlowers = 0, countFruits = 0, countVegetables = 0, phase1 = 0, phase2 = 0, phase3 = 0, phase4 = 0, phase5 = 0, phase0 = 0;
        for (Plants item : plantsByCoordinates.values()) {
            if (item instanceof Flower)
                countFlowers++;

            if (item instanceof Fruit)
                countFruits++;

            if (item instanceof Vegetable)
                countVegetables++;
                /*
            int Phase=item.getGrowthPhase();

            /
            if(Phase==0)
                phase0++;
            if(Phase==1)
               phase1++;
            if(Phase==2)
                phase2++;
            if(Phase==3)
                phase3++;
            if(Phase==4)
                phase4++;
            if(Phase==5)
                phase5++;

             */


        }


        System.out.println(ANSI_YELLOW + "Current number of flowers " + countFlowers + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Current number of fruits " + countFruits + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "Current number of vegetables " + countVegetables + ANSI_RESET);
        /*
        System.out.println("Number of plants in Phase 0: "+phase0);
        System.out.println("Number of plants in Phase 1: "+phase1);
        System.out.println("Number of plants in Phase 2: "+phase2);
        System.out.println("Number of plants in Phase 3: "+phase3);
        System.out.println("Number of plants in Phase 4: "+phase4);
        System.out.println("Number of plants in Phase 5: "+phase5);

         */

        /*System.out.println("Number of plants in Phase 1: "+phase1);
        System.out.println("Number of plants in Phase 2: "+phase2);
        System.out.println("Number of plants in Phase 3: "+phase3);
        System.out.println("Number of plants in Phase 4: "+phase4);
        System.out.println("Number of plants in Phase 5: "+phase5);

         */

    }
}
