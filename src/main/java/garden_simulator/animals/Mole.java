package garden_simulator.animals;

/**
 * Sets impact and range for Mole
 */
public class Mole extends Animal {

    public Mole() {
        impact = -10;
        range = (int) (0.2 * width * height);
        if (range < 1)
            range = 1;
    }

    @Override
    public String toString() {
        return "Mole";
    }
}