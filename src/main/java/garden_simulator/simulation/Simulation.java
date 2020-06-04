package garden_simulator.simulation;

import garden_simulator.simulation.animals.RandomAnimalGenerator;
import garden_simulator.simulation.animals.RandomAnimalsPositionGenerator;
import garden_simulator.simulation.day.DayOfYear;
import garden_simulator.simulation.plants.RandomPlantGenerator;
import garden_simulator.simulation.plants.RandomPlantsPositionGenerator;

import java.io.IOException;

public class Simulation {

    public void run(GardenProperties gardenProperties) throws IOException {
        RandomPlantsPositionGenerator randomPlantsPositionGenerator =
                new RandomPlantsPositionGenerator(gardenProperties, new RandomPlantGenerator());

        RandomAnimalsPositionGenerator randomAnimalsPositionGenerator =
                new RandomAnimalsPositionGenerator(gardenProperties, new RandomAnimalGenerator());

        DayOfYear dayOfYear = new DayOfYear();

        Garden garden = new Garden(gardenProperties, randomPlantsPositionGenerator.generate(), randomAnimalsPositionGenerator.generate(), dayOfYear.getSeason());


        System.out.println("Sim: " + gardenProperties.getGardenHeight() + " " + gardenProperties.getGardenWidth() + " " + gardenProperties.getPlantsStartingNumber());

        garden.listPlants();

        while (!garden.isEmpty() && dayOfYear.getDayNumber() <= 365) {
            garden.update(dayOfYear.getSeason());
            System.out.println("Season of the year: " + dayOfYear.getSeason().getName());
            System.out.println("Day: " + dayOfYear.getDayNumber());
            System.out.println("Today's garden state:");
            garden.draw();
            System.out.println("Today's garden statistics: ");
            garden.stats();
            System.out.println("\n");

            dayOfYear.update();
        }
        System.out.println("\nFinal garden state: ");
        garden.draw();
        garden.stats();

    }
}
