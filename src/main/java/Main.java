import garden_simulator.simulation.Garden;
import garden_simulator.simulation.GardenProperties;
import garden_simulator.simulation.Simulation;
import garden_simulator.simulation.UserInteractor;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Simulation simulation = new Simulation();
        simulation.run();

    }
}