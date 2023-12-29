package com.myProject.parkinglot.strategies;

import com.myProject.parkinglot.models.Gate;
import com.myProject.parkinglot.models.ParkingSpot;
import com.myProject.parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate);
}
