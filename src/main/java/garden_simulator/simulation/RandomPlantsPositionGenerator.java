package garden_simulator.simulation;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.plants.Plants;

import java.util.*;

public class RandomPlantsPositionGenerator {
    private final GardenProperties gardenProperties;

    private final RandomPlantGenerator randomPlantGenerator;

    private final Random randomGenerator = new Random();

    public RandomPlantsPositionGenerator(GardenProperties gardenProperties, RandomPlantGenerator randomPlantGenerator) {
        this.gardenProperties = gardenProperties;
        this.randomPlantGenerator = randomPlantGenerator;
    }

    private static Coordinates chooseCoordinateUntilIsNotTaken(
            List<Coordinates> allPossibleCoordinates,
            Map<Coordinates, Plants> plantsByCoordinates) {
        Set<Coordinates> takenCoordinates = plantsByCoordinates.keySet();

        Iterator<Coordinates> allPossibleCoordsIterator = allPossibleCoordinates.iterator();
        Coordinates selectedCoord;
        do {
            selectedCoord = allPossibleCoordsIterator.next();
        } while (takenCoordinates.contains(selectedCoord));

        // this may return null
        return selectedCoord;
    }

    public PlantsPositions generate() {
        List<Coordinates> allPossibleCoordinates = getAllPossibleCoordinates();

        Map<Coordinates, Plants> plantsByCoordinates = new HashMap<>();
        System.out.println("PlantsStartingNumber " + gardenProperties.getPlantsStartingNumber());
        for (int i = 0; i < gardenProperties.getPlantsStartingNumber(); i++) {
            Coordinates coordinate = chooseCoordinateUntilIsNotTaken(allPossibleCoordinates, plantsByCoordinates);
            plantsByCoordinates.put(coordinate, randomPlantGenerator.getRandomPlant());
        }

        return new PlantsPositions(gardenProperties, plantsByCoordinates);
    }

    List<Coordinates> getAllPossibleCoordinates() {
        List<Coordinates> coordinates = new ArrayList<>();
        for (int i = 0; i < gardenProperties.getGardenWidth(); i++) {
            for (int j = 0; j < gardenProperties.getGardenHeight(); j++) {
                coordinates.add(new Coordinates(i, j));
            }
        }
        return coordinates;
    }

}
