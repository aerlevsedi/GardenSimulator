package garden_simulator.simulation;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.animals.Bee;
import garden_simulator.animals.Borer;
import garden_simulator.animals.Mole;

import java.util.Random;

public class AnimalsPositions {
    public Animal[] animalsArray;

    public AnimalsPositions(GardenProperties gardenProperties) {
        int animalsNumber = gardenProperties.getMaxPlantsNumber();
        animalsArray = new Animal[animalsNumber];
        for (int i = 0; i < animalsNumber; i++) {
            Random coor = new Random();

            int X = coor.nextInt(gardenProperties.getGardenWidth());
            int Y = coor.nextInt(gardenProperties.getGardenHeight());

            Coordinates coors = new Coordinates(X, Y);
            Animal animal;

            Random kindRand = new Random();
            int kind = kindRand.nextInt(3);
            switch(kind) {
                case 0:
                    animal = new Bee(coors);
                    break;
                case 1:
                    animal = new Borer(coors);
                    break;
                case 2:
                    animal = new Mole(coors);
                    break;
                default:
                    animal = new Bee(coors);
            }

            animalsArray[i] = animal;
        }
    }

    public void list() {
        System.out.println("\nanimalsArray:");
        for(Animal animal : animalsArray) {
            System.out.println(animal.toString());
        }
    }

    public void move() {
        for(Animal animal : animalsArray){
            animal.move();
        }
    }
}
