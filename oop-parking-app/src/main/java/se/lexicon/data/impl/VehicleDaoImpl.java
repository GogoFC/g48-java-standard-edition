package se.lexicon.data.impl;

import se.lexicon.data.VehicleDao;
import se.lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {

    private List<Vehicle> storage; // [v1, v2 ,v3, v4]

    public VehicleDaoImpl() {
        storage = new ArrayList<>();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("Vehicle Was null!");
        if (find(vehicle.getLicensePlate()).isPresent()){
            throw new IllegalArgumentException("License Plate is Duplicate.");
        }
        storage.add(vehicle);
        return vehicle;
    }

    @Override
    public Optional<Vehicle> find(String licensePlate) {
        for (Vehicle element: storage){
            if (element.getLicensePlate().equals(licensePlate)){
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(String licensePlate) {
        Optional<Vehicle> vehicleOptional = find(licensePlate);
        if (vehicleOptional.isEmpty()){
            return false;
        }
        storage.remove(vehicleOptional.get());
        return true;
    }

    @Override
    public Collection<Vehicle> findAll() {
        return null;
    }

    @Override
    public void update(Vehicle toUpdate) { //v2 ={ABC123, CAR} -> {ABC123, VAN}
        //Step 1: Check the method params
        //Step 2: find vehicle to update (Original Data)
        //Step 3: find the index of the object to update
        //Step 4: replace the object at index #

        if (toUpdate == null) throw new IllegalArgumentException("Vehicle data was null!");
        Optional<Vehicle> original = find(toUpdate.getLicensePlate());
        if (original.isEmpty()) throw new IllegalArgumentException("License Plate not found!");
        Vehicle vehicle = original.get();
        int index = storage.indexOf(vehicle);
        if (index == -1) throw new IllegalArgumentException("Existing vehicle not found in the storage");
        storage.set(index,toUpdate);
    }
}
