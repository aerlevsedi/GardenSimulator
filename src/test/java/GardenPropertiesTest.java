import garden_simulator.simulation.GardenProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GardenPropertiesTest {

    @Test
    public void testGetWidth(){
        GardenProperties.GardenDimensions gardenDimensions = new GardenProperties.GardenDimensions(10, 5);
        GardenProperties gardenProperties = new GardenProperties(gardenDimensions, 1);
        int expected = 10;

        Assertions.assertEquals(expected, gardenProperties.getGardenWidth());
    }

    @Test
    public void testGetHeight(){
        GardenProperties.GardenDimensions gardenDimensions = new GardenProperties.GardenDimensions(10, 5);
        GardenProperties gardenProperties = new GardenProperties(gardenDimensions, 1);
        int expected = 5;

        Assertions.assertEquals(expected, gardenProperties.getGardenHeight());
    }

    @Test
    public void testGetMaxPlantsNumber(){
        GardenProperties.GardenDimensions gardenDimensions = new GardenProperties.GardenDimensions(10, 5);
        GardenProperties gardenProperties = new GardenProperties(gardenDimensions, 1);
        int expected = 50;

        Assertions.assertEquals(expected, gardenProperties.getMaxPlantsNumber());
    }
}
