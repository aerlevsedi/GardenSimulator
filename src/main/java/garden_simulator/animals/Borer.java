package garden_simulator.animals;

import garden_simulator.coordinates.Coordinates;

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
