package garden_simulator;

public class Flower extends Plants {
    public Flower(int coorX, int coorY){
        super(coorX, coorY);
    };

    public void evalWeatherImpact(WeatherConditions weather) {
        double frost = -0.6*weather.getFrost();
        double wind = -0.2*weather.getWind();
        double sun = 0.8*weather.getSun();
        double rain = 0.6*weather.getRain();

        currentLife += (int) (frost + wind + sun + rain);
    }

    public void evalAnimalImpact(Animal animal) {
        currentLife += animal.getImpact();
    }


}
