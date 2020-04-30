import garden_simulator.WeatherConditions;
import garden_simulator.animals.Animal;
import garden_simulator.animals.Bee;
import garden_simulator.animals.Borer;
import garden_simulator.animals.Mole;
import garden_simulator.plants.Flower;
import garden_simulator.plants.Fruit;
import garden_simulator.plants.Plants;
import garden_simulator.plants.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        int gardenWidth = 2;
        int gardenHeight = 2;
        int plantsNumber = 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Garden width: ");
        String widthString = reader.readLine();

        System.out.println("Garden height: ");
        String heightString = reader.readLine();

        System.out.println("Number of plants: ");
        String plantsString = reader.readLine();

        try {
            gardenWidth = Integer.parseInt(widthString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        try {
            gardenHeight = Integer.parseInt(heightString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        try {
            plantsNumber = Integer.parseInt(plantsString.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        //TODO: add exception if flowersNumber<1 || >width*height

        int maxPlantsNumber = gardenHeight*gardenWidth;

        Plants[][] plantsGarden = new Plants[gardenWidth][gardenHeight];
        Plants[] plantsArray = new Plants[maxPlantsNumber];

        for(int i=0; i<plantsNumber; i++){
            Random coor = new Random();

            int X = coor.nextInt(gardenWidth);
            int Y = coor.nextInt(gardenHeight);

            while(plantsGarden[X][Y] != null) {
                X = coor.nextInt(gardenWidth);
                Y = coor.nextInt(gardenHeight);
            }

            Plants plant;

            Random kindRand = new Random();
            int kind = kindRand.nextInt(3);
            switch(kind){
                case 0:
                    plant = new Flower(X, Y);
                    break;
                case 1:
                    plant = new Vegetable(X, Y);
                    break;
                case 2:
                    plant = new Fruit(X, Y);
                    break;
                default:
                    plant = new Flower(X, Y);
            }

            plantsArray[i] = plant;
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

        System.out.println("\nplantsGarden drawing:");
        for(int i=0; i<gardenHeight; i++){
            for(int j=0; j<gardenWidth; j++){
                if(plantsGarden[j][i] == null){
                    //System.out.print("O");
                    System.out.print("(X,Y)");
                }else{
                    System.out.print(plantsGarden[j][i].getCoordinates().toString());
                }
            }
            System.out.println();
        }

        int animalsNumber = maxPlantsNumber;
        Animal[] animalsArray = new Animal[animalsNumber];
        for(int i=0; i<animalsNumber; i++){
            Random coor = new Random();

            int X = coor.nextInt(gardenWidth);
            int Y = coor.nextInt(gardenHeight);

            Animal animal;

            Random kindRand = new Random();
            int kind = kindRand.nextInt(3);
            switch(kind){
                case 0:
                    animal = new Bee(X, Y);
                    break;
                case 1:
                    animal = new Borer(X, Y);
                    break;
                case 2:
                    animal = new Mole(X, Y);
                    break;
                default:
                    animal = new Bee(X, Y);
            }

            animalsArray[i] = animal;
        }

        WeatherConditions weather = new WeatherConditions();

        for(int k=0; k<10; k++){
            for(int i=0; i<animalsNumber; i++){
                int X = animalsArray[i].getCoordinates().getX();
                int Y = animalsArray[i].getCoordinates().getY();

                if(X>=0 && X<gardenWidth && Y>=0 && Y<gardenHeight) {
                    if (plantsGarden[X][Y] != null) {
                        plantsGarden[X][Y].evalAnimalImpact(animalsArray[i]);
                    }
                }
            }

            for(int i=0; i<plantsNumber; i++){
                plantsArray[i].evalWeatherImpact(weather);
            }

            System.out.println("\nplantsArray:");
            for(int i=0; i<plantsNumber; i++){
                System.out.println(plantsArray[i].toString());
            }

            for(int i=0; i<animalsNumber; i++){
                animalsArray[i].move();
            }

            for(int i=0; i<animalsNumber; i++){
                System.out.println(animalsArray[i].toString());
            }

            weather.changeWeather();
        }
    }
}
