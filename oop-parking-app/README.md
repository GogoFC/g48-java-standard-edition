# Parking App

## ParkingLot
- Represents a parking area that contains multiple parking spots
- **Attributes**
    - `areaCode: int` - the unique identifier for the parking lot
- **Associations**
    - To ParkingSpots

## ParkingSpot
- Represents a parking spot where the vehicle will stand, within a parking lot.
- **Attributes**
  - `spotNumber: int`
  - `occupied: boolean` - value indicate if spot is available or not.


## Reservation
- Represents an accusation when a vehicle is parked in a spot.
- **Attributes**
  - `id: String` - the unique identifier for the reservation.
  - `startTime:LocalTime` - the start time for the parking.
  - `endTime:LocalTime` - the end time for the parking.

- **Associations**
    - To Customer
    - To Vehicle
    - To ParkingSpot

## Customer
- Represents a person/user of the application.

## Vehicle
- Represents information about the vehicle being parked.

## VehicleType
- Represents what kind of vehicle.

# Class Diagram
![class-diagram.png](img%2Fclass-diagram.png)