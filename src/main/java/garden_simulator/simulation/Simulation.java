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
            String season;
            season="";
            if(daysCounter>=0 && daysCounter<=79 || daysCounter>=356)
                season="Winter";
            if(daysCounter>=80 && daysCounter<=172)
                season="Spring";
            if(daysCounter>=173 && daysCounter<=265)
                season="Fall";
            if(daysCounter>=266 && daysCounter<=254)
                season="Winter";

            switch(season)
            {
                case "Spring":
                    garden.update("Spring");
                    break;
                case "Summer":
                    garden.update("Summer");
                    break;
                case "Fall":
                    garden.update("Fall");
                    break;
                case "Winter":
                    garden.update("Winter");
                    break;
            }

            System.out.println("Season of the year" + season);
            System.out.println("Day: " + daysCounter);
            garden.stats();
            daysCounter++;
            //TODO: nice logs with dayNumber, number of plants etc
        }
        garden.draw();

    }
}
