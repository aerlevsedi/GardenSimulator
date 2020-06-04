package garden_simulator.plants;

import garden_simulator.coordinates.Coordinates;
import garden_simulator.animals.Animal;
import garden_simulator.weather.WeatherConditions;

public class Flower extends Plants {
    public Flower() {
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
        double frost = -0.2 * weather.getFrost();
        double wind = -0.3 * weather.getWind();
        double sun = 2 * weather.getSun();
        double rain = 1 * weather.getRain();

        int temperature=weather.getSpringTemperature();
        currentLife += (int) (frost + wind + sun + rain+temperature);
        updateGrowthPhase();
    }

    public void evalSummer(WeatherConditions weather)
    {
        double wind = -0.5 * weather.getWind();
        double sun = 3 * weather.getSun();
        double rain = 1 * weather.getRain();
        double storm = -1.5 * weather.getStorm();

        int temperature=weather.getSummerTemperature();
        currentLife += (int) (storm + wind + sun + rain+temperature);
        updateGrowthPhase();
    }
    public void evalFall(WeatherConditions weather)
    {
        double wind = -1 * weather.getWind();
        double sun = 1 * weather.getSun();
        double rain = 0.5 * weather.getRain();
        double storm = -0.5 * weather.getStorm();
        double frost = -0.2 * weather.getFrost();

        int temperature=weather.getFallTemperature();
        currentLife += (int) (frost+storm + wind + sun + rain+temperature);
        updateGrowthPhase();
    }
    public void evalWinter(WeatherConditions weather)
    {
        double wind = -0.1 * weather.getWind();
        double sun = 0.9 * weather.getSun();
        double rain = 0.8 * weather.getRain();
        double frost = -1 * weather.getFrost();

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
        return "Flower[currentLife: " + currentLife + "; growthPhase: " + growthPhase + ";]";
    }
}
