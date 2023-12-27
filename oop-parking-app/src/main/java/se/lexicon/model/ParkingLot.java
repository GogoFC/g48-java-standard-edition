package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private int areaCode;

    private Map<Integer,ParkingSpot> parkingSpots;

    public ParkingLot(int areaCode, Map<Integer, ParkingSpot> parkingSpots) {
        this.areaCode = areaCode;
        this.parkingSpots = parkingSpots;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public List<ParkingSpot> getParkingSpots() {
        return new ArrayList<>(parkingSpots.values());
    }

    public List<ParkingSpot> getAvailableParkingSpots(){
        List<ParkingSpot> availableSpots = new ArrayList<>();

        for (ParkingSpot parkingSpot : parkingSpots.values()){
            if (!parkingSpot.isOccupied()){
                availableSpots.add(parkingSpot);
            }
        }

        return availableSpots;
    }

    public ParkingSpot getParkingSpotBySpotNumber(int spotNumber){
        return parkingSpots.get(spotNumber);
    }


}
