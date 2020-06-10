package garden_simulator.simulation.day;

/**
 * Keeps information about number of the day in simulation
 * and returns current Season of the year.
 */
public class DayOfYear {
    private int number;

    public DayOfYear() {
        number = 1;
    }

    public void update() {
        number++;
    }

    public Season getSeason() {
        String season = "";
        if ((number >= 0 && number <= 79) || (number >= 355 && number <= 365))
            season = "Winter";

        if (number >= 80 && number <= 172)
            season = "Spring";

        if (number >= 173 && number <= 265)
            season = "Summer";

        if (number >= 266 && number <= 354)
            season = "Fall";

        return new Season(season);
    }

    public int getDayNumber() {
        return number;
    }
}
