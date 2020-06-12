package garden_simulator.app;

import garden_simulator.simulation.GardenProperties;
import garden_simulator.simulation.Simulation;
import java.io.IOException;
import static garden_simulator.simulation.GardenProperties.*;

/**
 * Main class for starting the simulation
 * and interaction with user.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Simulation simulation = new Simulation();
        UserInteractor interactor = new UserInteractor();

        GardenDimensions gardenDimensions = interactor.askForGardenDimensions();
        int maxPlantsNumber = interactor.askForNumberOfPlants(gardenDimensions);

        GardenProperties gardenProperties = new GardenProperties(gardenDimensions, maxPlantsNumber);
        simulation.run(gardenProperties);



    }
}
