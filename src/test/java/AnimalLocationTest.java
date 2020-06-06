import garden_simulator.animals.Bee;
import garden_simulator.coordinates.Coordinates;
import garden_simulator.simulation.animals.AnimalLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalLocationTest {

    @Test
    public void testGetCoors(){
        Coordinates coordinates = new Coordinates(5, 2);
        Bee bee = new Bee();
        AnimalLocation animalLocation = new AnimalLocation(coordinates, bee);

        Assertions.assertEquals(coordinates, animalLocation.getCoors());
    }

    @Test
    public void testGetAnimal(){
        Coordinates coordinates = new Coordinates(5, 2);
        Bee bee = new Bee();
        AnimalLocation animalLocation = new AnimalLocation(coordinates, bee);

        Assertions.assertEquals(bee, animalLocation.getAnimal());
    }

    @Test
    public void testSetCoors(){
        Coordinates coordinates = new Coordinates(5, 2);
        Bee bee = new Bee();
        AnimalLocation animalLocation = new AnimalLocation(coordinates, bee);
        Coordinates newCoordinates = new Coordinates(4, 2);

        animalLocation.setCoors(newCoordinates);

        Assertions.assertEquals(newCoordinates, animalLocation.getCoors());
    }
}
