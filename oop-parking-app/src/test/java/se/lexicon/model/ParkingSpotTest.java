package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingSpotTest {


    private ParkingSpot testObject;

    @BeforeEach
    public void setup(){
        testObject = new ParkingSpot(1);
    }

    @Test
    public void testGetSpotNumber(){
        //Arrange
        int expected = 1;
        //Act
        int actual = testObject.getSpotNumber();
        //Assert
        assertEquals(expected,actual);
    }


    @Test
    void testOccupy() {
        testObject.occupy(); //Occupied = true
        assertTrue(testObject.isOccupied());

    }

    @Test
    void vacate() {
        testObject.vacate(); //Occupied = false
        assertFalse(testObject.isOccupied());
    }
}
