package garden_simulator;

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

    public void setCoors(int x, int y){
        X = x;
        Y = y;
    }
}
