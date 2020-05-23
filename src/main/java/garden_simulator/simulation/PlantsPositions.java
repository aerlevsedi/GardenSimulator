package garden_simulator.simulation;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.weather.WeatherConditions;
import garden_simulator.animals.Animal;
import garden_simulator.plants.Flower;
import garden_simulator.plants.Fruit;
import garden_simulator.plants.Plants;
import garden_simulator.plants.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlantsPositions {
    public GardenProperties gardenProperties;
    public Plants[][] plantsGarden;
    public List<Plants> plantsArray;

    public PlantsPositions(GardenProperties gardenProp) {
        gardenProperties = gardenProp;
        int gardenWidth = gardenProperties.getGardenWidth();
        int gardenHeight = gardenProperties.getGardenHeight();
        int plantsNumber = gardenProperties.getPlantsStartingNumberNumber();

        plantsGarden = new Plants[gardenWidth][gardenHeight];
        plantsArray = new ArrayList<Plants>(plantsNumber);

        for (int i = 0; i < plantsNumber; i++) {
            Random coor = new Random();

            int X = coor.nextInt(gardenWidth);
            int Y = coor.nextInt(gardenHeight);

            Coordinates coors = new Coordinates(X, Y);

            while (plantsGarden[X][Y] != null) {
                X = coor.nextInt(gardenWidth);
                Y = coor.nextInt(gardenHeight);
            }

            Plants plant;

            Random kindRand = new Random();
            int kind = kindRand.nextInt(3);
            switch (kind) {
                case 0:
                    plant = new Flower(coors);
                    break;
                case 1:
                    plant = new Vegetable(coors);
                    break;
                case 2:
                    plant = new Fruit(coors);
                    break;
                default:
                    plant = new Flower(coors);
            }

            plantsArray.add(plant);
            plantsGarden[X][Y] = plant;
        }
    }

    public void animalImpact(AnimalsPositions animalsPositions) {

        for(Animal animal : animalsPositions.animalsArray){
            int X = animal.getCoordinates().getX();
            int Y = animal.getCoordinates().getY();

            if (X >= 0 && X < gardenProperties.getGardenWidth() && Y >= 0 && Y < gardenProperties.getGardenHeight()) {
                if (plantsGarden[X][Y] != null) {
                    plantsGarden[X][Y].evalAnimalImpact(animal);
                }
            }
        }

    }

    public void weatherImpact(WeatherConditions weatherConditions) {

        for(Plants plant : plantsArray) {
            plant.evalWeatherImpact(weatherConditions);
        }

    }

    public void killPlants() {

        for (int i = 0; i < gardenProperties.getGardenHeight(); i++) {
            for (int j = 0; j < gardenProperties.getGardenWidth(); j++) {
                boolean shouldDie;
                if(plantsGarden[j][i]!=null) {
                    shouldDie = plantsGarden[j][i].shouldDie();

                    if (shouldDie) {
                        plantsArray.remove(plantsGarden[j][i]);
                        plantsGarden[j][i] = null;
                    }
                }
            }
        }
    }

    public void reproduce() {

        //TODO plants dying after they reproduce
        for (int i = 0; i < gardenProperties.getGardenHeight(); i++) {
            for (int j = 0; j < gardenProperties.getGardenWidth(); j++) {
                Plants plant; //TODO maybe try to do this without "empty" object

                if(plantsArray.size() >= gardenProperties.getMaxPlantsNumber())
                    break;

                if (plantsGarden[j][i] != null) {
                    boolean canReproduce = plantsGarden[j][i].canReproduce();
                    if (canReproduce) {
                        //TODO put this into functions

                        for (int m = j - 1; m >= 0; m--) {

                            if(plantsArray.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            if (plantsGarden[m][i] == null) {
                                Coordinates coors =  new Coordinates(m,i);

                                if (plantsGarden[j][i] instanceof Flower) {
                                    plant = new Flower(coors);
                                    plantsGarden[m][i] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Vegetable) {
                                    plant = new Vegetable(coors);
                                    plantsGarden[m][i] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Fruit) {
                                    plant = new Fruit(coors);
                                    plantsGarden[m][i] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                            }
                        }

                        for (int m = j + 1; m <= gardenProperties.getGardenWidth() - 1; m++) {

                            if(plantsArray.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            if (plantsGarden[m][i] == null) {
                                Coordinates coors =  new Coordinates(m,i);
                                if (plantsGarden[j][i] instanceof Flower) {
                                    plant = new Flower(coors);
                                    plantsGarden[m][i] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Vegetable) {
                                    plant = new Vegetable(coors);
                                    plantsGarden[m][i] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Fruit) {
                                    plant = new Fruit(coors);
                                    plantsGarden[m][i] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                            }

                        }

                        for (int m = i - 1; m >= 0; m--) {

                            if(plantsArray.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            if (plantsGarden[j][m] == null) {
                                Coordinates coors =  new Coordinates(m,i);
                                if (plantsGarden[j][i] instanceof Flower) {
                                    plant = new Flower(coors);
                                    plantsGarden[j][m] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Vegetable) {
                                    plant = new Vegetable(coors);
                                    plantsGarden[j][m] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Fruit) { ;
                                    plant = new Fruit(coors);
                                    plantsGarden[j][m] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                            }

                        }

                        for (int m = i + 1; m <= gardenProperties.getGardenHeight() - 1; m++) {

                            if(plantsArray.size() >= gardenProperties.getMaxPlantsNumber())
                                break;

                            if (plantsGarden[j][m] == null) {
                                Coordinates coors =  new Coordinates(m,i);
                                if (plantsGarden[j][i] instanceof Flower) {
                                    plant = new Flower(coors);
                                    plantsGarden[j][m] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Vegetable) {
                                    plant = new Vegetable(coors);
                                    plantsGarden[j][m] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                                if (plantsGarden[j][i] instanceof Fruit) {
                                    plant = new Fruit(coors);
                                    plantsGarden[j][m] = plant;
                                    plantsArray.add(plant);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int getPlantsNumber(){
        return plantsArray.size();
    }

    public boolean isEmpty(){
        return plantsArray.isEmpty();
    }

    public boolean isFull(){
        return (plantsArray.size() == gardenProperties.getMaxPlantsNumber());
    }

    public void draw() {
        //TODO colors?
        int gardenHeight = gardenProperties.getGardenHeight();
        int gardenWidth = gardenProperties.getGardenWidth();

        System.out.println("\nplantsGarden drawing:");
        for (int i = 0; i < gardenHeight; i++) {
            for (int j = 0; j < gardenWidth; j++) {
                if (plantsGarden[j][i] == null) {
                    //System.out.print("O");
                    System.out.print("(X,Y)");
                } else {
                    System.out.print(plantsGarden[j][i].getCoordinates().toString());
                }
            }
            System.out.println();
        }
    }

    public void list(){
        int gardenHeight = gardenProperties.getGardenHeight();
        int gardenWidth = gardenProperties.getGardenWidth();

        System.out.println("\nplantsArray:");
        for (Plants item : plantsArray) {
            System.out.println(item.toString());
        }

        System.out.println("\nplantsGarden:");
        for (int i = 0; i < gardenHeight; i++) {
            for (int j = 0; j < gardenWidth; j++) {
                try {
                    System.out.println(plantsGarden[j][i].toString());
                } catch (NullPointerException e) {
                    System.out.println("none");
                }
            }
        }
    }
}
