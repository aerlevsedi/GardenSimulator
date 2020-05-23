package garden_simulator.simulation;

import java.io.IOException;

public class Simulation {

    public void run() throws IOException {
        UserInteractor interactor = new UserInteractor();
        GardenProperties gardenProperties = interactor.askForGardenDimensions();

        interactor.askForNumberOfPlants(gardenProperties);

        Garden garden = new Garden(gardenProperties);

        while (!garden.isEmpty() && !garden.isFull()) {
            garden.draw();
            garden.listPlants();
            //garden.listAnimals();

            garden.update();

            //TODO: nice logs with dayNumber, number of plants etc
        }
        garden.draw();
    }
}
