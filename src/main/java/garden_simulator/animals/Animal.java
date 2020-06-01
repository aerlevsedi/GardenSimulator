package garden_simulator.animals;

import garden_simulator.coordinates.Coordinates;

import java.util.Random;

public abstract class Animal {
    protected Coordinates coordinates;
    protected int impact;
    protected int range;

    public Animal(Coordinates coors) {
        coordinates = coors;
    }

    static int width;
    static int height;

    public static void getSize(int gardenWidth, int gardenHeight) {
        width = gardenWidth;
        height = gardenHeight;
    }

    public void move() {

        Random rand_direction = new Random();
        Random rand_length = new Random();

        int newX;
        int newY;
        int checkLopp = 8;

        do{
            newX = coordinates.getX() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range + 1));
            checkLopp--;
        }
        while ((newX > width + 3 || newX < -3) && checkLopp>0);

        if(checkLopp==0){
            newX = coordinates.getX();
        }


        checkLopp=8;
        do{
            newY = coordinates.getY() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range + 1));
            checkLopp--;
        }
        while ((newY > height + 3 || newY < -3) && checkLopp > 0);

        if(checkLopp==0){
            newY = coordinates.getY();
        }


        coordinates = new Coordinates(newX, newY);
    }

    public int getImpact() {
        return impact;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
