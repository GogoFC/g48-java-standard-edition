package se.lexicon.data.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDaoImplTest {

    private VehicleDaoImpl testObject;
    private Vehicle vehicle;


    @BeforeEach
    void setUp() {
        testObject = new VehicleDaoImpl();
        vehicle = new Vehicle("ABC123", VehicleType.CAR);
    }


//testCreate
    @Test
    public void testCreate(){
        Vehicle addedV = testObject.create(vehicle);

        Assertions.assertEquals(vehicle,addedV);
    }

//testCreateExistingVehicle
    @Test
    public void testCreateExistingVehicle(){
        testObject.create(vehicle);
//        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                testObject.create(vehicle);
//            }
//        });

        //Lambda Expression
        Assertions.assertThrows(IllegalArgumentException.class, () -> testObject.create(vehicle));

    }
    //testFindExistingVehicle
    @Test
    void testFindExistingVehicle() {
        testObject.create(vehicle);

        Optional<Vehicle> vehicleOptional = testObject.find(vehicle.getLicensePlate());
        Assertions.assertTrue(vehicleOptional.isPresent());

    }
    //testFindNonExistingVehicle
    @Test
    void testFindNonExistingVehicle() {
        Optional<Vehicle> vehicleOptional = testObject.find("qwe456");
        Assertions.assertFalse(vehicleOptional.isPresent());
    }

//testRemoveExistingVehicle
//testRemoveNonExistingVehicle


//testUpdate


    @Test
    void testUpdate() {
        testObject.create(vehicle); // {ABC123, CAR} -> {ABC123, VAN}

        Vehicle toUpdate = new Vehicle("ABC123", VehicleType.VAN);
        testObject.update(toUpdate);

        Optional<Vehicle> found = testObject.find("ABC123");
        assertTrue(found.isPresent());

        Vehicle vehicle = found.get();
        assertEquals(VehicleType.VAN, vehicle.getType());


    }
}