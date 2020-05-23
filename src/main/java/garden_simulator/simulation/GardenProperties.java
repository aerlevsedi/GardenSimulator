package garden_simulator.simulation;

public class GardenProperties {
    private final int gardenWidth;
    private final int gardenHeight;
    private int plantsStartingNumber;

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

    public void setPlantsStaringNumber(int plantsNumber) {
        this.plantsStartingNumber = plantsNumber;
    }

    public int getPlantsStartingNumberNumber() {
        return plantsStartingNumber;
    }

    public int getMaxPlantsNumber() {
        return gardenHeight * gardenWidth;
    }

}
