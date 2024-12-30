package com.carrental;

public interface MotorVehicle extends Vehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setMotorcycleType(String type);
    String getMotorcycleType();
}
