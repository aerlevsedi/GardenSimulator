package garden_simulator.simulation.animals;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.simulation.GardenProperties;

import java.util.List;

/**
 * Keeps all Animals with their positions.
 * Moves each Animal on a new position.
 */
public class AnimalsPositions {
    private final GardenProperties gardenProperties;
    private final List<AnimalLocation> animalsPositions;
    public int animalsNumber;

    public AnimalsPositions(GardenProperties gardenProperties, List<AnimalLocation> animalsPositions) {
        this.gardenProperties = gardenProperties;
        this.animalsNumber = gardenProperties.getMaxPlantsNumber();
        this.animalsPositions = animalsPositions;
    }

    public void list() {
        System.out.println("\nanimalsList:");
        for (AnimalLocation animalLocation : animalsPositions) {
            System.out.println(animalLocation.getAnimal().toString() + " " + animalLocation.getCoors().toString());
        }
    }

    public void move() {
        for (AnimalLocation animalLocation : animalsPositions) {
            Coordinates coors = animalLocation.getCoors();
            Animal animal = animalLocation.getAnimal();
            Coordinates newCoors = new Coordinates(animal.getRange(), gardenProperties, coors);

            animalLocation.setCoors(newCoors);
        }
    }

    public AnimalLocation getAnimalLocation(int i) {
        return animalsPositions.get(i);
    }

    public boolean isAnimalInGarden(Coordinates coors) {
        boolean isInWidth = (coors.getX() >= 0 && coors.getX() < gardenProperties.getGardenWidth());
        boolean isInHeight = (coors.getY() >= 0 && coors.getY() < gardenProperties.getGardenHeight());
        return (isInWidth && isInHeight);
    }
}