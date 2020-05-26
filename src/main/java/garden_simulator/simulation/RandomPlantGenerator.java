package garden_simulator.simulation;

import garden_simulator.plants.Flower;
import garden_simulator.plants.Fruit;
import garden_simulator.plants.Plants;
import garden_simulator.plants.Vegetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

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
