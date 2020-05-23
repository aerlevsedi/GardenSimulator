package garden_simulator.animals;

import garden_simulator.coordinates.Coordinates;

public class Bee extends Animal {
    public Bee(Coordinates coors) {
        super(coors);

        impact = 20;
        range = (int) (0.3 * width * height);
        if (range < 1)
            range = 1;

    }

    @Override
    public String toString() { //can it be in superclass?
        return "Bee[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + ");]";
    }
}
