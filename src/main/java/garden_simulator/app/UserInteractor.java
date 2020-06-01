package garden_simulator.app;

import garden_simulator.simulation.GardenProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static garden_simulator.simulation.GardenProperties.*;

public class UserInteractor {
    private final Scanner scanner = new Scanner(System.in);

    public GardenDimensions askForGardenDimensions() {

        int gardenWidth = askForInteger("Garden width (needs to be > 1)", value -> value > 1);
        int gardenHeight = askForInteger("Garden height (needs to be > 1)", value -> value > 1);

        return new GardenDimensions(gardenWidth, gardenHeight);
    }

    private int askForInteger(String question, IntPredicate validationRequirement) {
        int userInput;
        do {
            System.out.println(question);
            askUntilIntegerIsProvided(question);
            userInput = scanner.nextInt();
        } while (!validationRequirement.test(userInput));

        return userInput;
    }

    private void askUntilIntegerIsProvided(String question) {
        while (!scanner.hasNextInt()) {
            System.out.println(question);
            scanner.next();
        }
    }

    public int askForNumberOfPlants(GardenDimensions gardenDimensions) {

        int maxPlantsNumber = gardenDimensions.getMaxPlantsNumber();

        IntPredicate startingPlantsNumberValidation = value -> value >= 1 && value <= maxPlantsNumber;
        int startingPlantsNumber = askForInteger(
                "Number of plants (needs to be <= " + maxPlantsNumber + ")",
                startingPlantsNumberValidation
        );


        return startingPlantsNumber;
    }

}

