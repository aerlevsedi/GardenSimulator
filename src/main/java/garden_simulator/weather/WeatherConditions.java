package garden_simulator.weather;

import java.util.Random;

public class WeatherConditions {
    private final int rain;
    private final int frost;
    private final int wind;
    private final int sun;
    private final int storm;
    private int springTemperature;
    private int summerTemperature;
    private int fallTemperature;
    private int winterTemperature;


    public WeatherConditions() {
        Random rand = new Random();
        rain = rand.nextInt(21);
        frost = rand.nextInt(21);
        wind = rand.nextInt(21);
        sun = rand.nextInt(21);
        storm= rand.nextInt(21);
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

    public int getStorm(){ return storm;}

    private int SpringTemperature()
    {
        Random rand=new Random();
        springTemperature= rand.nextInt(10+1)+10;
        return springTemperature;
    }

    private int  SummerTemperature()
    {
        Random rand=new Random();
        summerTemperature= rand.nextInt(10+1)+20;
        return summerTemperature;
    }

    private int FallTemperature()
    {
        Random rand=new Random();
        fallTemperature= rand.nextInt(10+1);
        return fallTemperature;
    }

    private int  WinterTemperature()
    {
        Random rand=new Random();
       winterTemperature= rand.nextInt(10+1)-10;
       return winterTemperature;
    }
    public int getSpringTemperature() { return SpringTemperature(); }
    public int getSummerTemperature() { return SummerTemperature(); }
    public int getFallTemperature() { return FallTemperature(); }
    public int getWinterTemperature() { return WinterTemperature(); }

}