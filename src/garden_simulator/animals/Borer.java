package garden_simulator.animals;

public class Borer extends Animal{
    public Borer(int coorX, int coorY){
        super(coorX, coorY);

        impact = -10;
        range = 1; //TODO: should depend on garden size
    }

    @Override
    public String toString() {
        return "Borer[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + ");]";
    }
}
