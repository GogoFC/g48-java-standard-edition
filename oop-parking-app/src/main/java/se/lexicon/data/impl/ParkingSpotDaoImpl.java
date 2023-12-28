package se.lexicon.data.impl;

import se.lexicon.data.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {
    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        //TODO - Implement method
        return null;
    }

    @Override
    public Optional<ParkingSpot> find(Integer spotNumber) {
        //TODO - Implement method
        return Optional.empty();
    }

    @Override
    public void occupyParkingSpot(int spotNumber) {
        //TODO - Implement method
    }

    @Override
    public void vacateParkingSpot(int spotNumber) {
        //TODO - Implement method
    }
}
