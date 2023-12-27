package se.lexicon.model;

import java.time.LocalTime;

public class Reservation {

    private String id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Customer customer;
    private Vehicle associatedVehicle;
    private ParkingSpot parkingSpot;

    public Reservation(String id, LocalTime startTime, LocalTime endTime, Customer customer, Vehicle associatedVehicle, ParkingSpot parkingSpot) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
        this.associatedVehicle = associatedVehicle;
        this.parkingSpot = parkingSpot;
    }

    public Reservation(LocalTime startTime, LocalTime endTime, Customer customer, Vehicle associatedVehicle, ParkingSpot parkingSpot) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.customer = customer;
        this.associatedVehicle = associatedVehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getAssociatedVehicle() {
        return associatedVehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", customer=" + customer +
                ", associatedVehicle=" + associatedVehicle +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
