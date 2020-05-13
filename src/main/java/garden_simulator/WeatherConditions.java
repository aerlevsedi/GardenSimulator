package garden_simulator;
import java.util.Random;

public class WeatherConditions {
    private int rain;
    private int frost;
    private int wind;
    private int sun;


    public WeatherConditions(){
        rain = 10;
        frost = 10;
        wind = 10;
        sun = 10;
    }

    public void changeWeather(){
        Random rand = new Random();
        rain = rand.nextInt(21);
        frost = rand.nextInt(21);
        wind = rand.nextInt(21);
        sun = rand.nextInt(21);
    };

    public int getFrost() {
        return frost;
    }

    public int getRain() {
        return rain;
    }

    public int getSun() {
        return sun;
    }

    public int getWind() {
        return wind;
    }
}
