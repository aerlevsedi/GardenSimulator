package garden_simulator.animals;

public class Bee extends Animal{
    public Bee(int coorX, int coorY){
        super(coorX, coorY);

        impact = 10;
        range = 10; //TODO: should depend on garden size
    }

    @Override
    public String toString() { //can it be in superclass?
        return "Bee[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + ");]";
    }
}
