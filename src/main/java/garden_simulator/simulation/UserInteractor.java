package garden_simulator.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInteractor {
    //TODO scanner
    //TODO check exceptions!

    public GardenProperties askForGardenDimensions() throws IOException {

        int gardenWidth = 2;
        int gardenHeight = 2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Garden width: ");
        String widthString = reader.readLine();

        try {
            gardenWidth = Integer.parseInt(widthString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        while (gardenWidth < 1) {
            System.out.println("The width of garden is incorrect, set new value");
            System.out.println("Garden width: ");
            widthString = reader.readLine();

            try {
                gardenWidth = Integer.parseInt(widthString.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }

        System.out.println("Garden height: ");
        String heightString = reader.readLine();

        try {
            gardenHeight = Integer.parseInt(heightString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        while (gardenHeight < 1) {
            System.out.println("The height of garden is incorrect, set new value");
            System.out.println("Garden height: ");
            heightString = reader.readLine();

            try {
                gardenHeight = Integer.parseInt(heightString.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }

        }

        return new GardenProperties(gardenWidth, gardenHeight);
    }

    public void askForNumberOfPlants(GardenProperties gardenProp) throws IOException {
        int plantsNumber = 2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Number of plants: ");
        String plantsString = reader.readLine();

        try {
            plantsNumber = Integer.parseInt(plantsString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        while (plantsNumber < 1 || plantsNumber > gardenProp.getGardenWidth() * gardenProp.getGardenHeight()) {
            System.out.println("Number of plants is incorrect, please set new one");

            System.out.println("Number of plants: ");
            plantsString = reader.readLine();

            try {
                plantsNumber = Integer.parseInt(plantsString.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }

        gardenProp.setPlantsStaringNumber(plantsNumber);
    }

}

