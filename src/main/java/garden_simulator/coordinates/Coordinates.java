package garden_simulator.coordinates;

import garden_simulator.simulation.GardenProperties;

import java.util.Objects;
import java.util.Random;

public class Coordinates {
    private int X;
    private int Y;

    public Coordinates(int coorX, int coorY) {
        X = coorX;
        Y = coorY;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Coordinates(int range, GardenProperties gardenProperties, Coordinates coordinates){
        Random rand_direction = new Random();
        Random rand_length = new Random();

        int newX;
        int newY;
        int checkLoop = 8;

        do{
            newX = coordinates.getX() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range + 1));
            checkLoop--;
        }
        while ((newX > gardenProperties.getGardenWidth() + 3 || newX < -3) && checkLoop>0);

        if(checkLoop==0){
            newX = coordinates.getX();
        }

        checkLoop=8;
        do{
            newY = coordinates.getY() + (rand_direction.nextInt(3) - 1) * (rand_length.nextInt(range + 1));
            checkLoop--;
        }
        while ((newY > gardenProperties.getGardenHeight() + 3 || newY < -3) && checkLoop > 0);

        if(checkLoop==0){
            newY = coordinates.getY();
        }

        this.X = newX;
        this.Y = newY;
    }

    @Override
    public String toString() {
        return "(" + X + "," + Y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return X == that.X &&
                Y == that.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
