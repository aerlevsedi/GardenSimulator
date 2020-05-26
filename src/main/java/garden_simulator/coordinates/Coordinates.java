package garden_simulator.coordinates;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "(" + X + "," + Y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return X == that.X &&
                Y == that.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
