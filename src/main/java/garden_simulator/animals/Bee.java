package garden_simulator.animals;

/**
 * Sets impact and range for Bee
 */
public class Bee extends Animal {

    public Bee() {
        impact = 20;
        range = (int) (0.3 * width * height);
        if (range < 1)
            range = 1;
    }

    @Override
    public String toString() {
        return "Bee ";
    }
}