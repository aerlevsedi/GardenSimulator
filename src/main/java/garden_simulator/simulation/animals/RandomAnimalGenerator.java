package garden_simulator.simulation.animals;

import garden_simulator.animals.Animal;
import garden_simulator.animals.Bee;
import garden_simulator.animals.Borer;
import garden_simulator.animals.Mole;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class RandomAnimalGenerator {

    private static final List<Supplier<Animal>> availableAnimals = Arrays.asList(
            Bee::new,
            Borer::new,
            Mole::new
    );

    private final Random randomGenerator = new Random();

    public Animal getRandomAnimal() {
        int randomListIndex = randomGenerator.nextInt(availableAnimals.size());
        Animal randomAnimal = availableAnimals.get(randomListIndex).get();
        return randomAnimal;
    }
}
