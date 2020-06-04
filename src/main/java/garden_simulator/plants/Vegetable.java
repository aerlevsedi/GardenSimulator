package garden_simulator.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

public class Vegetable extends Plants {
    public Vegetable() {
    }

    public void evalWeatherImpact(WeatherConditions weather, String season) {

        switch(season)
        {
            case "Spring":
                evalSpring(weather);
                break;
            case "Summer":
                evalSummer(weather);
                break;
            case "Fall":
                evalFall(weather);
                break;
            case "Winter":
                evalWinter(weather);
                break;
        }

    }

    public void evalSpring(WeatherConditions weather) {
        double frost = -1.2 * weather.getFrost();
        double wind = -0.2 * weather.getWind();
        double sun = 1.5 * weather.getSun();
        double rain = 1.5 * weather.getRain();

        int temperature=weather.getSpringTemperature();
        currentLife += (int) (frost + wind + sun + rain+temperature);
        updateGrowthPhase();
    }

    public void evalSummer(WeatherConditions weather)
    {
        double wind = -0.3 * weather.getWind();
        double sun = 2.5 * weather.getSun();
        double rain = 0.5* weather.getRain();
        double storm = -0.5 * weather.getStorm();

        int temperature=weather.getSummerTemperature();
        currentLife += (int) (storm + wind + sun + rain+temperature);
        updateGrowthPhase();
    }
    public void evalFall(WeatherConditions weather)
    {
        double wind = -0.3 * weather.getWind();
        double sun = 0.8 * weather.getSun();
        double rain = 0.6 * weather.getRain();
        double storm = -0.2 * weather.getStorm();
        double frost = -0.5 * weather.getFrost();

        int temperature=weather.getFallTemperature();
        currentLife += (int) (frost+storm + wind + sun + rain+temperature);
        updateGrowthPhase();
    }
    public void evalWinter(WeatherConditions weather)
    {
        double wind = -0.3 * weather.getWind();
        double sun = 0.7 * weather.getSun();
        double rain = 0.8 * weather.getRain();
        double frost = -0.9 * weather.getFrost();

        int temperature=weather.getWinterTemperature();
        currentLife += (int) (frost+ wind + sun + rain+temperature);
        updateGrowthPhase();
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
        updateGrowthPhase();
    }

    @Override
    public String toString() {
        return "Vegetable[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
