package garden_simulator.simulation;

public class GardenProperties {
    private int gardenWidth;
    private int gardenHeight;
    private int plantsNumber;

    public GardenProperties(int width, int height){
        gardenWidth = width;
        gardenHeight = height;
    }

    public int getGardenHeight() {
        return gardenHeight;
    }

    public int getGardenWidth() {
        return gardenWidth;
    }

    public void setPlantsNumber(int plantsNumber) {
        this.plantsNumber = plantsNumber;
    }

    public int getPlantsNumber() {
        return plantsNumber;
    }

    public int getMaxPlantsNumber() {
        return gardenHeight * gardenWidth;
    }

}
