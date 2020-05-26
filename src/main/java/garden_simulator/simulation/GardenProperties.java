package garden_simulator.simulation;

public class GardenProperties {
    private final GardenDimensions dimensions;
    private final int plantsStartingNumber;

    public GardenProperties(GardenDimensions dimensions, int plantsStartingNumber) {
        this.dimensions = dimensions;
        System.out.println("plantsStartingNumber " + plantsStartingNumber);
        this.plantsStartingNumber = plantsStartingNumber;
    }

    public int getGardenHeight() {
        return dimensions.getHeight();
    }

    public int getGardenWidth() {
        return dimensions.getWidth();
    }

    public int getPlantsStartingNumber() {
        return plantsStartingNumber;
    }

    public int getMaxPlantsNumber() {
        return dimensions.getMaxPlantsNumber();
    }


    public static class GardenDimensions {
        private final int width;
        private final int height;

        public GardenDimensions(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int getMaxPlantsNumber() {
            return width * height;
        }
    }
}
