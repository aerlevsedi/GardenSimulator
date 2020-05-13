package garden_simulator.animals;


public class Bee extends Animal{
    public Bee(int coorX, int coorY){
        super(coorX, coorY);

        impact = 20;
        range = (int)0.3*width*height;
        if(range<1)
            range=1;

    }

    @Override
    public String toString() { //can it be in superclass?
        return "Bee[ coors: (" + coordinates.getX() + ", " + coordinates.getY() + ");]";
    }
}
