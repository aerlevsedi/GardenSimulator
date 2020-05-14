package garden_simulator.animals;

public class Mole extends Animal{
    public Mole(int coorX, int coorY){
        super(coorX, coorY);

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