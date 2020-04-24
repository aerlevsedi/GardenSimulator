package garden_simulator.animals;
import garden_simulator.Coordinates;

import java.util.Random;

public abstract class Animal {
    protected Coordinates coordinates;
    protected int impact;
    protected int range;

    public Animal(int x, int y){
        coordinates.X = x;
        coordinates.Y = y;
    }

    public void move(){
        Random rand_direction = new Random();
        Random rand_length = new Random();

        coordinates.X += (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range));
        coordinates.Y += (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range));

        //TODO: how to get size of the garden? - need it to check new coors
    };

    public int getImpact() {
        return impact;
    }

    public int getRange() {
        return range;
    } //probably not needed
}
