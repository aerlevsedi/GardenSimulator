package garden_simulator.simulation.animals;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.simulation.GardenProperties;

import java.util.*;

/**
 * Generates random position for Animals.
 */
public class RandomAnimalsPositionGenerator {
    private final GardenProperties gardenProperties;
    private final RandomAnimalGenerator randomAnimalGenerator;

    public RandomAnimalsPositionGenerator(GardenProperties gardenProperties, RandomAnimalGenerator randomAnimalGenerator) {
        this.gardenProperties = gardenProperties;
        this.randomAnimalGenerator = randomAnimalGenerator;
    }

    private Coordinates getRandomCoordinates() {
        Random coor = new Random();

        int X = coor.nextInt(gardenProperties.getGardenWidth());
        int Y = coor.nextInt(gardenProperties.getGardenHeight());

        Coordinates coors = new Coordinates(X, Y);

        return coors;
    }

    public AnimalsPositions generate() {

        List<AnimalLocation> animalsList = new ArrayList<>();

        int animalsNumber = gardenProperties.getMaxPlantsNumber();

        for (int i = 0; i < animalsNumber; i++) {
            Coordinates coordinate = getRandomCoordinates();
            Animal animal = randomAnimalGenerator.getRandomAnimal();

            AnimalLocation animalLocation = new AnimalLocation(coordinate, animal);

            animalsList.add(animalLocation);
        }

        return new AnimalsPositions(gardenProperties, animalsList);
    }
}