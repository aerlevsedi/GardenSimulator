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

    static int width;
    static int height;
    public static void getSize (int gardenWidth, int gardenHeight)
    {
        width=gardenWidth;
        height=gardenHeight;
    }


    public void move(){


        Random rand_direction = new Random();
        Random rand_length = new Random();

        int newX = coordinates.getX() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range+1));
        int newY = coordinates.getY() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range+1));

        coordinates.setCoors(newX, newY);


      while(newX>width+3 || newX<-3)
        {
            newX = coordinates.getX() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range+1));
        }

        while(newY>height+3 || newY<-3)
        {
            newY = coordinates.getY() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range+1));
        }

        coordinates.setCoors(newX, newY);

        }



    public int getImpact() {
        return impact;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}