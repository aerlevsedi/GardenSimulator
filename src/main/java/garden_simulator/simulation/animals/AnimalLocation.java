package garden_simulator.simulation.animals;

import garden_simulator.animals.Animal;
import garden_simulator.coordinates.Coordinates;

public class AnimalLocation {
    private Coordinates coors;
    private final Animal animal;

    public AnimalLocation(Coordinates coors, Animal animal) {
        this.coors = coors;
        this.animal = animal;
    }

    public Coordinates getCoors() {
        return coors;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setCoors(Coordinates newCoors) {
        this.coors = newCoors;
    }
}