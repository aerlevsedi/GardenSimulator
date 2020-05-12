package garden_simulator.animals;
import garden_simulator.Coordinates;

import java.util.Random;

public abstract class Animal {
    protected Coordinates coordinates;
    protected int impact;
    protected int range;

    public Animal(int x, int y){
        coordinates = new Coordinates(x, y);
    }

    public void move(){

        Random rand_direction = new Random();
        Random rand_length = new Random();

        int newX = coordinates.getX() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range+1));
        int newY = coordinates.getY() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range+1));
        coordinates.setCoors(newX, newY);
        //TODO: how to get size of the garden? - need it to check new coors or they will go out
    };

    public int getImpact() {
        return impact;
    }

    public int getRange() {
        return range;
    } //probably not needed

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
