package garden_simulator.animals;

import garden_simulator.Coordinates;

public class Mole extends Animal{
    public Mole(Coordinates coors){
        super(coors);

        impact = -10;
        range = (int)(0.2*width*height);
        if(range<1)
            range=1;
    }

    @Override
    public String toString() {
        return "Mole[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + ");]";
    }
}