package garden_simulator.animals;

/**
 * Sets impact and range for Borer
 */
public class Borer extends Animal {

    public Borer() {
        impact = -10;
        range = (int) (0.1 * width * height);
        if (range < 1)
            range = 1;
    }

    @Override
    public String toString() {
        return "Borer ";
    }
}