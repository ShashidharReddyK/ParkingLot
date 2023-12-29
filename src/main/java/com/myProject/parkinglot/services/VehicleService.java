package com.myProject.parkinglot.services;

import com.myProject.parkinglot.models.Vehicle;
import com.myProject.parkinglot.models.VehicleType;
import com.myProject.parkinglot.repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle getVehicle(String vehicleNumber){

        return vehicleRepository.getVehicleFromVehicleNumber(vehicleNumber);
//        return null;
    }
    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType){
        return null;
    }
}
