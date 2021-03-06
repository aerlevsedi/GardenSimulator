package garden_simulator.simulation.plants;

import garden_simulator.plants.Flower;
import garden_simulator.plants.Fruit;
import garden_simulator.plants.Plants;
import garden_simulator.plants.Vegetable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Generates random Plant out of
 * Flower, Fruit and Vegetable
 */
public class RandomPlantGenerator {

    private static final List<Supplier<Plants>> availablePlants = Arrays.asList(
            Flower::new,
            Fruit::new,
            Vegetable::new
    );

    private final Random randomGenerator = new Random();

    public Plants getRandomPlant() {
        int randomListIndex = randomGenerator.nextInt(availablePlants.size());
        Plants randomPlant = availablePlants.get(randomListIndex).get();
        return randomPlant;
    }
}
