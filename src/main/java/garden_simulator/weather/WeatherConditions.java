package garden_simulator.weather;

import java.util.Random;

public class WeatherConditions {
    private final int rain;
    private final int frost;
    private final int wind;
    private final int sun;


    public WeatherConditions() {
        Random rand = new Random();
        rain = rand.nextInt(21);
        frost = rand.nextInt(21);
        wind = rand.nextInt(21);
        sun = rand.nextInt(21);
    }

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