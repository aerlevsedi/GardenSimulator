package garden_simulator.weather;

import garden_simulator.simulation.day.Season;

import java.util.Random;

public class WeatherConditions {
    private final int rain;
    private final int frost;
    private final int wind;
    private final int sun;
    private final int storm;
    private final int temperature;

    private final Random randomGenerator = new Random();

    public WeatherConditions(Season season) {
        Random rand = new Random();
        rain = this.setRain(season);
        frost = this.setFrost(season);
        wind = this.setWind(season);
        sun = this.setSun(season);
        storm = this.setStorm(season);
        temperature = this.setTemperature(season);
    }

    private int setTemperature(Season season) {
        int temperatureValue = 0;
        switch (season.getName()) {
            case "Spring":
                temperatureValue = randomGenerator.nextInt(15) + 10;
                break;
            case "Summer":
                temperatureValue = randomGenerator.nextInt(10) + 25;
                break;
            case "Fall":
                temperatureValue = randomGenerator.nextInt(20) + 5;
                break;
            case "Winter":
                temperatureValue = randomGenerator.nextInt(10) - 5;
                break;
        }
        return temperatureValue;
    }

    private int setSun(Season season) {
        int sunValue = 0;
        switch (season.getName()) {
            case "Spring":
                sunValue = randomGenerator.nextInt(5) + 10;
                break;
            case "Summer":
                sunValue = randomGenerator.nextInt(5) + 15;
                break;
            case "Fall":
                sunValue = randomGenerator.nextInt(5) + 5;
                break;
            case "Winter":
                sunValue = randomGenerator.nextInt(5);
                break;
        }
        return sunValue;
    }

    private int setStorm(Season season) {
        int stormValue = 0;
        switch (season.getName()) {
            case "Spring":
                stormValue = randomGenerator.nextInt(5) + 5;
                break;
            case "Summer":
                stormValue = randomGenerator.nextInt(5) + 15;
                break;
            case "Fall":
                stormValue = randomGenerator.nextInt(5) + 10;
                break;
            case "Winter":
                stormValue = randomGenerator.nextInt(5);
                break;
        }
        return stormValue;
    }

    private int setWind(Season season) {
        int windValue = 0;
        switch (season.getName()) {
            case "Spring":
                windValue = randomGenerator.nextInt(5) + 15;
                break;
            case "Summer":
                windValue = randomGenerator.nextInt(5) + 10;
                break;
            case "Fall":
                windValue = randomGenerator.nextInt(5) + 15;
                break;
            case "Winter":
                windValue = randomGenerator.nextInt(5) + 15;
                break;
        }
        return windValue;
    }

    private int setFrost(Season season) {
        int frostValue = 0;
        switch (season.getName()) {
            case "Spring":
                frostValue = randomGenerator.nextInt(5) + 5;
                break;
            case "Summer":
                frostValue = randomGenerator.nextInt(5) - 5;
                break;
            case "Fall":
                frostValue = randomGenerator.nextInt(5);
                break;
            case "Winter":
                frostValue = randomGenerator.nextInt(5) + 5;
                break;
        }
        return frostValue;
    }

    private int setRain(Season season) {
        int rainValue = 0;
        switch (season.getName()) {
            case "Spring":
                rainValue = randomGenerator.nextInt(5) + 15;
                break;
            case "Summer":
                rainValue = randomGenerator.nextInt(5) + 5;
                break;
            case "Fall":
                rainValue = randomGenerator.nextInt(5) + 10;
                break;
            case "Winter":
                rainValue = randomGenerator.nextInt(5);
                break;
        }
        return rainValue;
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

    public int getStorm() {
        return storm;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "WeatherConditions{" +
                "rain=" + rain +
                ", frost=" + frost +
                ", wind=" + wind +
                ", sun=" + sun +
                ", storm=" + storm +
                ", temperature=" + temperature +
                '}';
    }
}