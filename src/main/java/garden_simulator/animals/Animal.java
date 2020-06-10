package garden_simulator.animals;

/**
 * Keeps information about impact on plants
 * and range for moving.
 */
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
