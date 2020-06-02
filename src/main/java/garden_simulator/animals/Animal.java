package garden_simulator.animals;

import garden_simulator.coordinates.Coordinates;

import java.util.Random;

public abstract class Animal {
    protected int impact;
    protected int range;

    static int width;
    static int height;

    public Animal() {}

    public int getImpact() {
        return impact;
    }

    public int getRange(){
        return range;
    };
}
