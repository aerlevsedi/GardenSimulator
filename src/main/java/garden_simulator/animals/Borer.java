package garden_simulator.animals;

import garden_simulator.Coordinates;

public class Borer extends Animal{
    public Borer(Coordinates coors){
        super(coors);

        impact = -10;
        range = (int)(0.1*width*height);
        if(range<1)
            range=1;
    }

    @Override
    public String toString() {
        return "Borer[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + ");]";
    }
}
