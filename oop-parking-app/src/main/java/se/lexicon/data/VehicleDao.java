package se.lexicon.data;

import se.lexicon.model.Vehicle;

import java.util.Collection;
import java.util.Optional;

//Contract
public interface VehicleDao {

    //CRUD = CREATE READ UPDATE DELETE

    Vehicle create(Vehicle vehicle);

    Optional<Vehicle> find(String licensePlate);

    boolean remove(String licensePlate);

    Collection<Vehicle> findAll();

    void update(Vehicle data);

}
