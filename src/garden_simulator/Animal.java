package garden_simulator;

public abstract class Animal {
    protected Coordinates coordinates;
    protected int impact;
    protected int range;

    public void move(){

    };

    public int getImpact() {
        return impact;
    }

    public int getRange() {
        return range;
    }
}
