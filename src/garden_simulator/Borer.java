package garden_simulator;

public class Borer extends Animal{
    public Borer(int coorX, int coorY){
        super(coorX, coorY);

        impact = -15;
        range = 10; //TODO: should depend on garden size
    }

}
