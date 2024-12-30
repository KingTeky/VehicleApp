package com.carrental;

public interface TruckVehicle extends Vehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    void setTransmissionType(String transmissionType);
    String getTransmissionType();
}
