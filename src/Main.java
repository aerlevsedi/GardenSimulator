import garden_simulator.WeatherConditions;
import garden_simulator.animals.Bee;
import garden_simulator.animals.Mole;
import garden_simulator.plants.Flower;
import garden_simulator.plants.Plants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Number of plants: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String plantsString = reader.readLine();

        //TODO: get size of the garden

        int plantsNumber = 1; //default number, put it to catch?
        try {
            plantsNumber = Integer.parseInt(plantsString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        //TODO: add exception if flowersNumber<1

        int gardenWidth = 2;
        int gardenHeight = 2;
        Plants[][] plantsGarden = new Plants[gardenWidth][gardenHeight];

        Plants[] plantsArray = new Plants[plantsNumber];
        for(int i=0; i<plantsNumber; i++){
            Random coor = new Random();

            int X = coor.nextInt(gardenWidth);
            int Y = coor.nextInt(gardenHeight);

            Plants plant = new Flower(X, Y);

            plantsArray[i] = plant;
            //TODO: if this coors are taken get new
            plantsGarden[X][Y] = plant;
        }

        System.out.println("\nplantsArray:");
        for(int i=0; i<plantsNumber; i++){
            System.out.println(plantsArray[i].toString());
        }

        System.out.println("\nplantsGarden:");
        for(int i=0; i<gardenHeight; i++){
            for(int j=0; j<gardenWidth; j++){
                try {
                    System.out.println(plantsGarden[j][i].toString());
                } catch(NullPointerException e){
                    System.out.println("none");
                }
            }
        }
        Bee bee1 = new Bee(1, 1);
        for(int i=0; i<plantsNumber; i++){
            plantsArray[i].evalAnimalImpact(bee1);
        }

        System.out.println("\nplantsGarden:");
        for(int i=0; i<gardenHeight; i++){
            for(int j=0; j<gardenWidth; j++){
                try {
                    System.out.println(plantsGarden[j][i].toString());
                } catch(NullPointerException e){
                    System.out.println("none");
                }
            }
        }


        System.out.println("\nTesting objects:");
        WeatherConditions weather = new WeatherConditions();
        Bee bee = new Bee(1, 1);
        Mole mole = new Mole(2, 2);
        Flower tulip = new Flower(1, 1);

        System.out.println(tulip.toString());

        tulip.evalAnimalImpact(bee);
        tulip.evalAnimalImpact(bee);
        tulip.evalAnimalImpact(bee);
        tulip.evalAnimalImpact(bee);
        tulip.evalAnimalImpact(bee);
        tulip.evalAnimalImpact(bee);
        tulip.evalAnimalImpact(bee);
        System.out.println(tulip.toString());

        tulip.evalAnimalImpact(mole);
        System.out.println(tulip.toString());
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        tulip.evalAnimalImpact(mole);
        System.out.println(tulip.toString());
    }
}
