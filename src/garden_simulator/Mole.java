package garden_simulator;

public class Mole extends Animal{
    public Mole(int coorX, int coorY){
        super(coorX, coorY);

        impact = -5;
        range = 2; //TODO: should depend on garden size
    }
}