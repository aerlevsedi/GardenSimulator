package garden_simulator.simulation;

import java.io.IOException;

public class Simulation {

    public void run(GardenProperties gardenProperties) throws IOException {
        RandomPlantsPositionGenerator randomPlantsPositionGenerator =
                new RandomPlantsPositionGenerator(gardenProperties, new RandomPlantGenerator());

        RandomAnimalsPositionGenerator randomAnimalsPositionGenerator =
                new RandomAnimalsPositionGenerator(gardenProperties, new RandomAnimalGenerator());

        Garden garden = new Garden(gardenProperties, randomPlantsPositionGenerator.generate(), randomAnimalsPositionGenerator.generate());

        System.out.println("Sim: " + gardenProperties.getGardenHeight() + " " + gardenProperties.getGardenWidth() + " " + gardenProperties.getPlantsStartingNumber());

        garden.listPlants();
        int daysCounter=1;
        while (!garden.isEmpty() && !garden.isFull() && daysCounter<=365) {
            garden.draw();
            //garden.listPlants();
            //garden.listAnimals();
            garden.update();
            garden.stats();
            daysCounter++;
            //TODO: nice logs with dayNumber, number of plants etc
        }
        garden.draw();

    }
}
