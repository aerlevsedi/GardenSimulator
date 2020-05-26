package garden_simulator.simulation;

import garden_simulator.app.UserInteractor;
import garden_simulator.plants.RandomPlantGenerator;
import garden_simulator.plants.RandomPlantsPositionGenerator;

import java.io.IOException;

public class Simulation {

    public void run(GardenProperties gardenProperties) throws IOException {
        RandomPlantsPositionGenerator randomPlantsPositionGenerator =
                new RandomPlantsPositionGenerator(gardenProperties, new RandomPlantGenerator());
        Garden garden = new Garden(gardenProperties, randomPlantsPositionGenerator.generate());

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
