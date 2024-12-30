package com.carrental;

public interface CarVehicle extends Vehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}
