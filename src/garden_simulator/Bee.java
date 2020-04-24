package garden_simulator;

public class Bee extends Animal{
    public Bee(int coorX, int coorY){
        super(coorX, coorY);

        impact = 10;
        range = 10; //TODO: should depend on garden size

    }
}
