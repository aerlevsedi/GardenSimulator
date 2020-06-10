package garden_simulator.simulation.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.plants.Plants;
import garden_simulator.simulation.GardenProperties;

import java.util.*;

/**
 * Generates random positions for Plants.
 */
public class RandomPlantsPositionGenerator {
    private final GardenProperties gardenProperties;
    private final RandomPlantGenerator randomPlantGenerator;


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

        Collections.shuffle(allPossibleCoordinates);

        Map<Coordinates, Plants> plantsByCoordinates = new HashMap<>();

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
