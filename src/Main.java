import garden_simulator.WeatherConditions;
import garden_simulator.animals.Bee;
import garden_simulator.animals.Mole;
import garden_simulator.plants.Flower;

public class Main {

    public static void main(String[] args) {
        //TODO: this should not be in this package(?)

        /* temporary */

        WeatherConditions weather = new WeatherConditions();
        Bee bee = new Bee(1, 1);
        Mole mole = new Mole(2, 2);
        Flower tulip = new Flower(1, 1);

        System.out.println(tulip.toString());
    }
}
