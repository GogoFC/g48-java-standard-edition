package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot testObject;

    @BeforeEach
    void setUp() {

        int psNumber1 = 1;
        Map<Integer, ParkingSpot> parkingSpotMap = new HashMap<>();
        parkingSpotMap.put(psNumber1,new ParkingSpot(psNumber1,true));
        parkingSpotMap.put(2,new ParkingSpot(2,false));
        parkingSpotMap.put(3,new ParkingSpot(3,true));

        testObject = new ParkingLot(123, parkingSpotMap);
    }

    @Test
    void testGetAreaCode(){
        //Arrange = 123
        //Act = getAreaCode()
        //Assert = asserEquals()
        assertEquals(123,testObject.getAreaCode());
    }

    @Test
    void testGetParkingSpotsSize3(){
        assertEquals(3,testObject.getParkingSpots().size());
    }

    @Test
    void testGetAvailableParkingSpots(){
        int expected = 1;
        int actual = testObject.getAvailableParkingSpots().size();
        assertEquals(expected, actual);
    }

    @Test
    void testGetParkingSpotBySpotId2() {
        ParkingSpot parkingSpot = testObject.getParkingSpotBySpotNumber(2);
        assertNotNull(parkingSpot);
    }

    @Test
    void testGetParkingSpotByInvalidSpotId() {
        ParkingSpot parkingSpot = testObject.getParkingSpotBySpotNumber(843);
        assertNull(parkingSpot);
    }
}