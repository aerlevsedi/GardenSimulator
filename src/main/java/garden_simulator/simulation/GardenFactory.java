package garden_simulator.simulation;

public class GardenFactory {
    //is it needed??

    public Garden create(GardenProperties gardenProp){
        return new Garden(gardenProp);
    }
}
