package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation testObject;

    @Test
    void setUp() {
        Customer customer = new Customer("Test Testsson", "123456789");
        Vehicle vehicle = new Vehicle("ABC123", VehicleType.CAR);
        ParkingSpot parkingSpot = new ParkingSpot(1);

        testObject = new Reservation(
                LocalTime.parse("07:00")
                , LocalTime.parse("13:00")
                , customer
                , vehicle
                , parkingSpot
        );

        System.out.println(testObject);

    }
}